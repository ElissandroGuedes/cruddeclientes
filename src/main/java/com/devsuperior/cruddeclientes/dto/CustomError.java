package com.devsuperior.cruddeclientes.dto;


import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private int status;
    private String erros;
    private String path;

    public CustomError(Instant timestamp, int status, String erros, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.erros = erros;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getErros() {
        return erros;
    }

    public String getPath() {
        return path;
    }
}
