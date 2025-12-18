package org.example.bankprojet.Metier;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.Entities.*;
import org.example.bankprojet.Mappers.MapperClients;
import org.example.bankprojet.Reposetories.IClientRepo;
import org.example.bankprojet.Reposetories.ICompteBancaireRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional
public class ClientService implements IClientService {

    private ICompteBancaireRepo cbrepo;
  private IClientRepo clientRepo;
  private MapperClients mClients;

    @Override
    public List<Cdto> VoireCients(String motcle) {
        List<Client> clients=clientRepo.findByNameContains(motcle);
        return  clients.stream().map(client->mClients.tClientaDto(client)).collect(Collectors.toList());
    }
    @Override
    public Cdto ajouterClient(Cdto cdto) {
        Client c=mClients.tDtoaClient(cdto);
        clientRepo.save(c);
        return mClients.tClientaDto(c);
    }
    @Override
    public void supprimerClient(Long id) {
cbrepo.deleteAllByClientId(id);
        clientRepo.deleteById(id);
    }
@Override
public Cdto getClient(Long id) {
        Client client = clientRepo.findById(id).orElse(null);
        return mClients.tClientaDto(client);
    }
    @Override
    public void modifierClient(Cdto cdto) throws Exception{
        Client client=mClients.tDtoaClient(cdto);
        clientRepo.save(client);

    }


}

//    @Override
//    public CompteBancaire ajouterCompteBancaire(Cbdto cbdto) throws Exception{
//        CompteBancaire cb;
//       if(("CompteCourant").equals(cbdto.getType()) && cbdto.getDecouvert() != null) {
//           CompteCourant cco=new CompteCourant();
//           cco.setDecouvert(cbdto.getDecouvert());
//           cb=cco;
//       }
//       else if(("CompteEpargne").equals(cbdto.getType()) && cbdto.getTauxInteret() != null) {
//           CompteEpargne ce=new CompteEpargne();
//           ce.setTauxInteret(cbdto.getTauxInteret());
//           cb=ce;
//       }else {
//           throw new Exception("type non assignee");
//       }
//       Client c= clientRepo.findById(cbdto.getId()).orElse(null);
//       if(c == null) {
//           throw new Exception("Client non existant");
//       }
//       cb.setClient(c);
//        cb.setSold(cbdto.getSold());
//        cb.setDateCreation(new Date());
//        cb.setStatus(StatCompte.CREATED);
//        cb.setDevise(cbdto.getDevise());
//        cbrepo.save(cb);
//return cb;
//    }
