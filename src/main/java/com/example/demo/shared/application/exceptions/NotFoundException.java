package com.example.demo.shared.application.exceptions;

import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import com.example.demo.shared.application.exceptions.generics.UseCaseException;

public class NotFoundException extends UseCaseException {
    public NotFoundException(ResourceFail resourceFail) {
        super(resourceFail);
    }

    public NotFoundException(String resource, String message) {
        super(resource, message);
    }
}
