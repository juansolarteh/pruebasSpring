package com.example.demo.shared.application.exceptions;

import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import com.example.demo.shared.application.exceptions.generics.UseCaseException;

public class ExistingResourceException extends UseCaseException {

    public ExistingResourceException(ResourceFail resourceFail) {
        super(resourceFail);
    }
    public ExistingResourceException(String resource, String message) {
        super(resource, message);
    }
}
