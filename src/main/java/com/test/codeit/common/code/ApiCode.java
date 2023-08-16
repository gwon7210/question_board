package com.test.codeit.common.code;

public enum ApiCode {

    SUCCESS(200, "SUCCESS"),
    PARAM_ERROR(300, "PARAM_ERROR"),
    DATA_NOT_FOUND(204, "데이터가 존재하지 않습니다."),
    QUESTIONS_NOT_FOUND(1001, "존재하지 않는 질문(QUESTIONS)입니다.");

    private int code;
    private String msg;

    ApiCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static ApiCode CODE(int intCode) {
        ApiCode apiCode = null;
        for (ApiCode code : ApiCode.values()) {
            if (intCode == code.getCode()) {
                apiCode = code;
                break;
            }
        }

        if (apiCode == null) {
            apiCode = ApiCode.SUCCESS;
        }

        return apiCode;
    }
}