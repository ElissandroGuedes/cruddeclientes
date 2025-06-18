package com.devsuperior.cruddeclientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> errors = new ArrayList<>();


    public ValidationError(Instant timestamp, int status, String erros, String path) {
        super(timestamp, status, erros, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldname, String message) {
        errors.add(new FieldMessage(fieldname, message));
    }
}
