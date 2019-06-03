package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Until {

    Integer result;

    public Until(Integer until, String action) {
        this.result = 0;
        countResult(until,action);
    }

    public void countResult (Integer until, String action){
        if (action.equals("sum")){
            int startPoint = 1;
            for (int i = 0; i < until; i++) {
                result+=startPoint;
                startPoint++;
            }
        }
        if (action.equals("factor")){
            int startPoint = 1;
            result=1;
            for (int i = 0; i < until; i++) {
                result*=startPoint;
                startPoint++;
            }
        }
    }
}
/*
 eg. /dountil/sum with {"until": 5} will respond {"result": 15}
        eg. /dountil/factor with {"until": 5} will respond {"result": 120}
 */