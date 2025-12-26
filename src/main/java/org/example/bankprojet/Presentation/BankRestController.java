package org.example.bankprojet.Presentation;

import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.DTOaffichageb;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Metier.IcbService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Controller
@RestController
@AllArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class BankRestController {
    IcbService icbService;

    @PostMapping("/AjouterAccourant")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void ajouterAccourant(@RequestBody Cbdto cbdto)throws Exception{
        icbService.ajouterCompteCourant(cbdto);
    }
    @PostMapping("/AjouterAcepargne")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void ajouterAcepargne(@RequestBody Cbdto cbdto)throws Exception{
        icbService.ajouterCompteEpargne(cbdto);
    }
    @GetMapping("/accs/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public DTOaffichageb voireCompte(@PathVariable String id) throws Exception {
        return icbService.voireAcc(id);
    }
    @GetMapping("/accsbyclid/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<DTOaffichageb> voireCbyCid(@PathVariable Long id) throws Exception {
        return  icbService.voireAccparClientID(id);
    }
    @DeleteMapping("/accs/suprimmer/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void suprimerCompte(@PathVariable String id) throws Exception {
        icbService.suprimerAcc(id);
    }
    @GetMapping("accs/status/suspended/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public Boolean suspendreAcc(@PathVariable String id) throws Exception {
        icbService.suspendreAcc(id);
        return true;
    }
    @GetMapping("accs/status/activated/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public Boolean reactiverAcc(@PathVariable String id) throws Exception {
        icbService.activerAcc(id);
    return true;
    }
}
