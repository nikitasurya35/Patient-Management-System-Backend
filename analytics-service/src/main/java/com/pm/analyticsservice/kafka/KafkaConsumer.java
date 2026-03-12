package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="patient", groupId = "analytics-service2")
    public void consumeEvent (byte[] event) {
        try {
            log.info("Received event");
            PatientEvent event1 = PatientEvent.parseFrom(event);
            log.info("Consuming event from kafka topic: {}", event1);
        } catch (Exception e) {
            log.info("Kafka Consumer event failed:: {}", e.getMessage() );
            //throw new RuntimeException(e);
        }
    }
}
