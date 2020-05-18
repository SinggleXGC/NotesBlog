package com.xgc.notesblog.dto;

public enum STATUS {

    OK(200), FORBIDDEN(403), INTERNAL_SERVER_ERROR(500);

    int status;

    STATUS(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
