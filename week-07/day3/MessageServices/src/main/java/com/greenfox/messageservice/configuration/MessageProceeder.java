package com.greenfox.messageservice.configuration;

import com.greenfox.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageProceeder {
    /*
Hint: If it is necessary don't forget to scan for components(services) in the relevant package.
     */

    MessageService messageService;
    MessageConfiguration configuration = new MessageConfiguration();

    @Autowired
    public MessageProceeder (@Qualifier("email") MessageService messageService){
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage (String message, String address){
        if (configuration.getConfiguration (address).equals("email")){
            setMessageService(new MessageService() {
                @Override
                public void sendMessage() {

                }
            });
        }
    }
}
