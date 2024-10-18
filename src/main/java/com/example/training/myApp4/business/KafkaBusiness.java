package com.example.training.myApp4.business;

import com.example.training.common2.request.EmailRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
public class KafkaBusiness {

    private final KafkaTemplate<String, EmailRequest> kafkaTemplate;

    public KafkaBusiness(KafkaTemplate<String,EmailRequest> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKafka(){
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setToEmail("soulxseeks4temp@gmail.com");
        emailRequest.setContent("gg call");

        //send kafka
        CompletableFuture<SendResult<String,EmailRequest>> future = kafkaTemplate.send("activation-email",emailRequest);
        future.whenComplete((result,ex)->{
            if(ex == null){
                log.info("kafka send sucess: "+result.getProducerRecord());
            }else {
                log.error("kafka send failed");
            }
        });
    }

}
