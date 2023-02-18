package org.sid.kafkaproducer;

import java.time.LocalDate;
import java.util.Random;

public class FactureGenerator {

        private Random random = new Random();

        public String generateFacture() {
            int id = random.nextInt(1000);
            double montant = 10 + random.nextDouble() * 100;
            LocalDate date = LocalDate.now().minusDays(random.nextInt(30));
            return String.format("Facture-%d-%.2f-%s", id, montant, date.toString());
        }
    }


