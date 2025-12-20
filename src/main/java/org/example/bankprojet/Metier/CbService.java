package org.example.bankprojet.Metier;

import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.DTOaffichageb;
import org.example.bankprojet.Entities.*;
import org.example.bankprojet.Exceptions.ClientNonExistantException;
import org.example.bankprojet.Exceptions.CompteInexistantException;
import org.example.bankprojet.Mappers.MapperBank;
import org.example.bankprojet.Reposetories.IClientRepo;
import org.example.bankprojet.Reposetories.ICompteBancaireRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CbService implements IcbService{

    private IClientRepo clientRepo;
    private ICompteBancaireRepo cbrepo;
    private MapperBank mb;

    @Override
    public CompteCourant ajouterCompteCourant(Cbdto cbdto) throws Exception {
        CompteCourant cco=new CompteCourant();
        cco.setId(UUID.randomUUID().toString());
        cco.setDecouvert(cbdto.getDecouvert());
        Client c= clientRepo.findById(cbdto.getId()).orElse(null);
        if(c == null) {
            throw new Exception("Client non existant");
        }
        cco.setClient(c);
        cco.setSold(cbdto.getSold());
        cco.setDateCreation(new Date());
        cco.setStatus(StatCompte.ACTIVATED);
        cco.setDevise(cbdto.getDevise());
        cbrepo.save(cco);
        return cco;
    }
    @Override
    public CompteEpargne ajouterCompteEpargne(Cbdto cbdto)throws ClientNonExistantException{
        CompteEpargne ce=new CompteEpargne();
        ce.setId(UUID.randomUUID().toString());
        ce.setTauxInteret(cbdto.getTauxInteret());
        Client c= clientRepo.findById(cbdto.getId()).orElse(null);
        if(c == null) {
            throw new ClientNonExistantException("Client non existant");
        }
        ce.setClient(c);
        ce.setSold(cbdto.getSold());
        ce.setDateCreation(new Date());
        ce.setStatus(StatCompte.ACTIVATED);
        ce.setDevise(cbdto.getDevise());
        cbrepo.save(ce);
        return null;
    }
    @Override
    public DTOaffichageb voireAcc(String id) throws CompteInexistantException {
        CompteBancaire c=cbrepo.findById(id).orElse(null);

        if(c == null) {
            throw new CompteInexistantException("Compte non existant");
        }
        return mb.tBankDto(c);
    }
    @Override
    public List<DTOaffichageb> voireAccparClientID(Long id) throws ClientNonExistantException{
        Client c=clientRepo.findById(id).orElse(null);
        if(c == null) {
            throw new ClientNonExistantException("Client non existant");
        }
        List<CompteBancaire> cs=cbrepo.findCompteBancaireByClientId(id);
        return cs.stream().map(compte->mb.tBankDto(compte))
                .collect(Collectors.toList());
    }
}
