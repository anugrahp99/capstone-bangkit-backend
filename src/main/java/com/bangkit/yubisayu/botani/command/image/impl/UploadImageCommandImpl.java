package com.bangkit.yubisayu.botani.command.image.impl;

import com.bangkit.yubisayu.botani.command.image.UploadImageCommand;
import com.bangkit.yubisayu.botani.constant.BaseConstants;
import com.bangkit.yubisayu.botani.payload.request.image.UploadImageRequest;
import com.bangkit.yubisayu.botani.payload.response.image.UploadImageResponse;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.*;
import java.util.List;

@Service
public class UploadImageCommandImpl implements UploadImageCommand {

    @Autowired
    private Storage storage;

    @Value("${app.bucketName}")
    private String bucketName;

    @Value("${app.host}")
    private String host;


    @SneakyThrows
    @Override
    public Mono<UploadImageResponse> execute(UploadImageRequest request) {
        String fileName = "" + System.currentTimeMillis();
        return uploadFile(request.getImage(), request.getFilePath(), fileName)
                .map(this::createResponse);
    }

    private Mono<String> uploadFile(FilePart image, String filePath, String fileName) throws IOException {
        String fileUrl = "";
        try {
            byte [] file = convertToByteArray(image);
            fileUrl = host
                    + "/" + bucketName
                    + "/" + filePath
                    + "/" + fileName + BaseConstants.IMAGE_EXT_JPEG;
            uploadFileToBucket(filePath, fileName + BaseConstants.IMAGE_EXT_JPEG, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mono.just(fileUrl);
    }

    private void uploadFileToBucket(String filePath, String fileName, byte[] file) {
        BlobId blobId = BlobId.of(bucketName, filePath+"/"+fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, file);
    }

    private List<byte[]> getBytes(FilePart filePart) {
        return filePart.content().flatMap(dataBuffer -> {
            byte[] bytes = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(bytes);
            return Mono.just(bytes);
        }).collectList().subscribeOn(Schedulers.elastic()).block();
    }

    @SneakyThrows
    private byte[] convertToByteArray(FilePart filePart) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            filePart.content()
                    .subscribe(dataBuffer -> {
                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
//                        log.trace("readable byte count:" + dataBuffer.readableByteCount());
                        dataBuffer.read(bytes);
                        DataBufferUtils.release(dataBuffer);
                        try {
                            bos.write(bytes);
                        } catch (IOException e) {
//                            log.error("read request body error...", e);
                        }
                    });

            return bos.toByteArray();
        }
    }

    private UploadImageResponse createResponse(String fileUrl) {
        return UploadImageResponse.builder().imageUrl(fileUrl).build();
    }
}