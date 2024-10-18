package com.example.training.myApp4;

import com.example.training.myApp4.business.KafkaBusiness;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class TestKafkaSend {

    @Autowired
    KafkaBusiness kafkaBusiness;

    @Test
    void testSendKafka(){
        kafkaBusiness.sendKafka();
    }
}
