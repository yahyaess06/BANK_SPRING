package org.example.bankprojet.Presentation;


import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Metier.IClientService;
import org.example.bankprojet.Metier.IcbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor

public class ClientRestController {

    IClientService clientService;


    @PostMapping("/ajouterClient")
    public Cdto ajouterClient(@RequestBody Cdto cdto) {
        return clientService.ajouterClient(cdto);
    }
    @GetMapping("/Clients")
    public List<Cdto> voireClients(){
        return clientService.VoireCients();
    }
    @PutMapping("/modifier")
    public void modifierClient(@RequestBody  Cdto cdto) throws Exception {
        clientService.modifierClient(cdto);
    }
    @DeleteMapping("/supprimer/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }

    @GetMapping("/get/{id}")
    public Cdto getClient(@PathVariable Long id) {
        Cdto cdto=clientService.getClient(id);
        return cdto;
    }


}
