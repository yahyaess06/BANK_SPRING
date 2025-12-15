package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Entities.CompteCourant;
import org.example.bankprojet.Entities.CompteEpargne;

import java.util.List;

public interface IcbService {
    CompteCourant ajouterCompteCourant(Cbdto cbdto) throws Exception;
    CompteEpargne ajouterCompteEpargne(Cbdto cbdto) throws Exception;
    CompteBancaire voireAcc(String id) throws Exception;

}
