package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.image.UploadImageCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.image.UploadImageRequest;
import com.bangkit.yubisayu.botani.payload.response.image.UploadImageResponse;
import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class ImageController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping(value = ApiPath.UPLOAD_IMAGE_FILE_PATH,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Response<UploadImageResponse>> uploadImage(
            @PathVariable("filePath") String filePath,
            @RequestPart("file") FilePart imageFile
    ) {
        UploadImageRequest request = UploadImageRequest.builder()
                .image(imageFile)
                .filePath(filePath)
                .build();
        return commandExecutor.execute(UploadImageCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
