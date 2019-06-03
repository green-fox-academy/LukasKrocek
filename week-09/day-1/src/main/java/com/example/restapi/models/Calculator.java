package com.example.restapi.models;

import lombok.Getter;

@Getter
public class Calculator {

    int result;


    public Calculator(String action, int [] numbers){
        if(action.equals("sum")){
            result = 0;
            for (int number:numbers) {
                result+=number;
            }
        }
        if(action.equals("multiply")){
            result = 1;
            for (int number:numbers) {
                result*=number;
            }
        }
    }
    //sum, multiply


}
