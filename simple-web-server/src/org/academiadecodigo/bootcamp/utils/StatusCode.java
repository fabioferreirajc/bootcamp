package org.academiadecodigo.bootcamp.utils;

public enum StatusCode {

    NOT_FOUND(404),
    OK(200),
    VERB_NOT_ALLOWED(405),
    IM_A_TEAPOT(418);


    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
