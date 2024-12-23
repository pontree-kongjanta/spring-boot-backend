package com.example.training.myApp4.business;


import com.example.training.myApp4.request.EmailRequest;
import com.example.training.myApp4.request.RegisterRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
public class MessageBroker {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageBroker(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKafka(RegisterRequest registerRequest) {

        //send kafka
        CompletableFuture<SendResult<String,String>> future = kafkaTemplate.send("activation-email",registerRequest.getEmail());
        future.whenComplete((result,ex)->{
            if(ex == null){
                log.info("kafka send sucess: "+result.getProducerRecord());

            }else {
                log.info("kafka send failed");
            }
        });
    }

}
