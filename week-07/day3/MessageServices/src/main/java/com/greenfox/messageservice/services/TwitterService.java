package com.greenfox.messageservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier ("twitter")
public class TwitterService implements MessageService {
    @Override
    public void sendMessage() {

    }
}
