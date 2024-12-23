package com.example.training.myApp4;

import com.example.training.myApp4.business.MessageBroker;
import com.example.training.myApp4.request.EmailRequest;
import com.example.training.myApp4.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestKafkaSend {

    @Autowired
    MessageBroker kafkaBusiness;

    @Test
    void testSendKafka() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("soulxseeks4temp@gmail.com");
        registerRequest.setPassword("gg call");
       kafkaBusiness.sendKafka(registerRequest);
    }
}


