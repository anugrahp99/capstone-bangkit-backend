package com.bangkit.yubisayu.botani.command.image;

import com.bangkit.yubisayu.botani.payload.request.image.UploadImageRequest;
import com.bangkit.yubisayu.botani.payload.response.image.UploadImageResponse;
import com.blibli.oss.command.Command;

public interface UploadImageCommand extends Command<UploadImageRequest, UploadImageResponse> {
}
