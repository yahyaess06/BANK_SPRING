package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.Client;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Entities.CompteCourant;
import org.example.bankprojet.Entities.CompteEpargne;

import java.util.List;

public interface IClientService {
    List<Cdto> VoireCients();

    Cdto ajouterClient(Cdto cdto);

    void supprimerClient(Long id);

    Cdto getClient(Long id);

    void modifierClient(Cdto Cdto) throws Exception;


}
