package com.bangkit.yubisayu.botani.model.enums;

public enum ErrorCode {
    LOGIN_FAILED("AU-01","Login failed, incorrect email or password",401),
    TOKEN_INVALID("AU-02","Token is invalid",401),
    TOKEN_EXPIRED("AU-03","Token is expired",401),
    USER_NOT_FOUND("USR-01","User not found with the given email and password",404),
    CONNECTION_TIMEOUT("USR-00","CONNECTION TIMEOUT",408),
    EMAIL_HAS_BEEN_TAKEN("CUS-03","The email has been taken",500),
    UPLOAD_FAILED("BB-01","Upload failed",500);


    private String code;
    private String message;
    private int httpStatus;
    private ErrorCode(String code, String message, int httpStatus){
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
