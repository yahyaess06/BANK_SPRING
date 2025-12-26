package org.example.bankprojet.Presentation;


import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpDTO;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Metier.IOperationsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class OperationsRestController {
    private IOperationsService operationsService;

    @PostMapping("/DebitOperation")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public void debitOperation(@RequestBody Odto ddto) throws Exception {
        operationsService.debitOperation(ddto);
    }
    @PostMapping("/CreditOperation")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public void creditOperation(@RequestBody Odto ddto) throws Exception {
        operationsService.creditOperation(ddto);
    }

    @PostMapping("/VersementOperation")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public void versementOperation(@RequestBody VDto dto)throws Exception{
        operationsService.VersementOperation(dto);
    }
    @GetMapping("Operations/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<OpeDto> getOperations(@PathVariable String id) {
        return operationsService.voireOperationsAcc(id);
    }
    @GetMapping("Oprations/aujourdhui")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<OpDTO> getOperationsAujourdhui() {
        return operationsService.voireOperationlyom();
    }
}
