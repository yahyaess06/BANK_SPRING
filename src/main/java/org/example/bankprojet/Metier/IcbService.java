package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.*;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Entities.CompteCourant;
import org.example.bankprojet.Entities.CompteEpargne;
import org.example.bankprojet.Exceptions.ClientNonExistantException;
import org.example.bankprojet.Exceptions.CompteInexistantException;

import java.util.List;

public interface IcbService {
    CompteCourant ajouterCompteCourant(Cbdto cbdto) throws Exception;
    CompteEpargne ajouterCompteEpargne(Cbdto cbdto) throws Exception;
    DTOaffichageb voireAcc(String id) throws Exception;
    List<DTOaffichageb> voireAccparClientID(Long id) throws ClientNonExistantException;
    void suprimerAcc(String id);

    void suspendreAcc(String id) throws CompteInexistantException;

    void activerAcc(String id)throws CompteInexistantException;
}
