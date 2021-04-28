package com.message.test;

import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws JsonProcessingException {
        System.out.println("Received <" + message + ">");
        ObjectMapper mapper = new ObjectMapper();
        Object user = mapper.readValue(message.toString(), Object.class);
        System.out.println(user.name);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}