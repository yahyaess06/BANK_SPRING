package org.example.bankprojet;

import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.Entities.*;
import org.example.bankprojet.Metier.IOperationsService;
import org.example.bankprojet.Metier.IcbService;
import org.example.bankprojet.Reposetories.IClientRepo;
import org.example.bankprojet.Reposetories.ICompteBancaireRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BankProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankProjetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IClientRepo clientRepo, IcbService cbs, ICompteBancaireRepo cr, IOperationsService os) {
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
            List<CompteBancaire> cobs=cr.findCompteBancaireByClientId(1L);
            for(CompteBancaire cb: cobs){
                Odto odto=Odto.builder().id(cb.getId())
                        .mantant(1000.0).build();
                os.debitOperation(odto);
                Odto odto1=Odto.builder().id(cb.getId())
                        .mantant(1000.0).build();
                os.debitOperation(odto1);
            }

            List<CompteBancaire> cobss=cr.findCompteBancaireByClientId(2L);
            for(CompteBancaire cb: cobss){
                Odto odto=Odto.builder().id(cb.getId())
                        .mantant(2000.0).build();
                os.creditOperation(odto);
                Odto odto1=Odto.builder().id(cb.getId())
                        .mantant(1000.0).build();
                os.debitOperation(odto1);
            }


        };
    }
}