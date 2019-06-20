package com.greenfox.messageservice.services;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("email")
public class EmailService implements MessageService {
    @Override
    public void sendMessage() {

    }
}
