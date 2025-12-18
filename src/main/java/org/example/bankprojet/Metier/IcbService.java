package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.*;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Entities.CompteCourant;
import org.example.bankprojet.Entities.CompteEpargne;

import java.util.List;

public interface IcbService {
    CompteCourant ajouterCompteCourant(Cbdto cbdto) throws Exception;
    CompteEpargne ajouterCompteEpargne(Cbdto cbdto) throws Exception;
    DTOaffichageb voireAcc(String id) throws Exception;

}
