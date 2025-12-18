package org.example.bankprojet;

import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.Entities.Client;
import org.example.bankprojet.Entities.CompteCourant;
import org.example.bankprojet.Entities.Operation;
import org.example.bankprojet.Entities.StatCompte;
import org.example.bankprojet.Metier.IOperationsService;
import org.example.bankprojet.Metier.IcbService;
import org.example.bankprojet.Reposetories.IClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankProjetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IClientRepo clientRepo, IcbService cbs, IOperationsService os) {
        return args1 -> {





            Client client =Client.builder().name("yahya essalhi").email("yahya@gmail.com").build();
            clientRepo.save(client);
            Client client1 =Client.builder().name("Reda Elbikri").email("reda@gmail.com").build();
            clientRepo.save(client1);
            Cbdto cbdto = Cbdto.builder().id(1L)
                    .sold(9000.0).decouvert(0.0).devise("MAD")
                    .build();
            cbs.ajouterCompteCourant(cbdto);
            Cbdto cbdto1= Cbdto.builder().id(1L)
                    .sold(10000.0).tauxInteret(4.5).devise("MAD")
                    .build();
            cbs.ajouterCompteEpargne(cbdto1);

            Cbdto cbdto2 = Cbdto.builder().id(2L)
                    .sold(91000.0).decouvert(0.0).devise("MAD")
                    .build();
            cbs.ajouterCompteCourant(cbdto2);

        };
    }
}