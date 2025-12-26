package org.example.bankprojet.Presentation;


import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Metier.IClientService;
import org.example.bankprojet.Metier.IcbService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@CrossOrigin("*")
@EnableMethodSecurity(prePostEnabled = true)
public class ClientRestController {

    IClientService clientService;


    @PostMapping("/ajouterClient")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public Cdto ajouterClient(@RequestBody Cdto cdto) {
        return clientService.ajouterClient(cdto);
    }
    @GetMapping("/Clients")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<Cdto> voireClients(@RequestParam(required = false, defaultValue = "") String motcle){
        return clientService.VoireCients(motcle);
    }
    @PutMapping("/modifier")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public void modifierClient(@RequestBody  Cdto cdto) throws Exception {
        clientService.modifierClient(cdto);
    }
    @DeleteMapping("/supprimer/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public Cdto getClient(@PathVariable Long id) {
        Cdto cdto=clientService.getClient(id);
        return cdto;
    }


}
