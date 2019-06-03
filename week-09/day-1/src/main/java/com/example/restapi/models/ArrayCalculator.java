package com.example.restapi.models;

import lombok.Getter;

@Getter
public class ArrayCalculator {

    int[] result;

    public ArrayCalculator(int[] numbers) {
        result = numbers;
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i]*2;
        }
    }
}