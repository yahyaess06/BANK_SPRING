package org.example.bankprojet.Presentation;

import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.DTOaffichageb;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Metier.IcbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Controller
@RestController
@AllArgsConstructor
public class BankRestController {
    IcbService icbService;

    @PostMapping("/AjouterAccourant")
    public CompteBancaire ajouterAccourant(@RequestBody Cbdto cbdto)throws Exception{
        return icbService.ajouterCompteCourant(cbdto);
    }
    @PostMapping("/AjouterAcepargne")
    public CompteBancaire ajouterAcepargne(@RequestBody Cbdto cbdto)throws Exception{
        return icbService.ajouterCompteEpargne(cbdto);
    }
    @GetMapping("/accs/{id}")
    public DTOaffichageb voireCompte(@PathVariable String id) throws Exception {
        return icbService.voireAcc(id);
    }
    @GetMapping("/accsbyclid/{id}")
    public List<DTOaffichageb> voireCbyCid(@PathVariable Long id) throws Exception {
        return  icbService.voireAccparClientID(id);
    }
}
