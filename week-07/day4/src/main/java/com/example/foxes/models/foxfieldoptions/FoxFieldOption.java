package com.example.foxes.models.foxfieldoptions;

public abstract class FoxFieldOption {

    private String fieldOption;
    private String fieldClassName;

    public FoxFieldOption (String fieldOption){
        this.fieldOption = fieldOption;
        fieldClassName = getClass().getSimpleName();
    }

    public String getFieldOption() {
        return fieldOption;
    }

    public String getFieldClassName() {
        return fieldClassName;
    }
}
