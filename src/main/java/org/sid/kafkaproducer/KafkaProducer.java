package org.sid.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

     @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;
        public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        }
        private FactureGenerator factureGenerator = new FactureGenerator();

        @Scheduled(fixedRate = 1000)
        public void publishFacture() {
            String facture = factureGenerator.generateFacture();
            kafkaTemplate.send("factures", facture);
        }

    }


