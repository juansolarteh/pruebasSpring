package com.example.demo.shared.presentation.handleExceptions;

import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class FieldErrorMapper {
    public ResourceFail toResourceFail(FieldError fieldError){
        if (fieldError.getDefaultMessage() == null)
            throw new IllegalArgumentException("fieldError.defaultMessage cannot be null");

        if (fieldError.getDefaultMessage().contains("$%"))
            return convertFromMethodError(fieldError.getDefaultMessage());
        return convertFromFieldError(fieldError);
    }

    private ResourceFail convertFromMethodError(String errorMessage){
        String[] split = errorMessage.split(":");
        String[] resources = split[0].replaceAll("[$%]", "").split(" ");
        return ResourceFail.create(resources, split[1]);
    }

    private ResourceFail convertFromFieldError(FieldError fieldError){
        return ResourceFail.create(new String[]{fieldError.getField()}, fieldError.getDefaultMessage());
    }
}
