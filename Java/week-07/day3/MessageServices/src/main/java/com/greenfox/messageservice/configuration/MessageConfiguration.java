package com.greenfox.messageservice.configuration;

public class MessageConfiguration {

    public String getConfiguration(String address) {
        if (address.contains("@") && address.contains(".")) {
            return "email";
        }
        return "twitter";
    }
}
