package com.example.demo.shared.application.exceptions.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "create")
@Getter
public class ResourceFail {
    private final String[] resource;
    private final String message;
}
