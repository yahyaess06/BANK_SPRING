package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.Cdto;

import java.util.List;

public interface IClientService {
    List<Cdto> VoireCients(String motcle);

    Cdto ajouterClient(Cdto cdto);

    void supprimerClient(Long id);

    Cdto getClient(Long id);

    void modifierClient(Cdto Cdto) throws Exception;


}
