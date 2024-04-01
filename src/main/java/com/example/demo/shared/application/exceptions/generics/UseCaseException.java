package com.example.demo.shared.application.exceptions.generics;

import lombok.Getter;

@Getter
public class UseCaseException extends RuntimeException{
    private final ResourceFail[] resourceFails;
    public UseCaseException(ResourceFail resourceFail) {
        this.resourceFails = new ResourceFail[]{resourceFail};
    }
    public UseCaseException(String resource, String message) {
        this.resourceFails = new ResourceFail[]{
                ResourceFail.create(new String[]{resource}, message)
        };
    }
}
