package org.sid.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

        @Autowired
        private KafkaProducer kafkaProducer;

        @GetMapping
        public ResponseEntity<String> testKafka() {
            kafkaProducer.sendMessage("factures", "Hello, Kafka!");
            return ResponseEntity.ok("Message sent to Kafka!");
        }
    }


