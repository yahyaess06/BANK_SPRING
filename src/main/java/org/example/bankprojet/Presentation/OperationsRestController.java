package org.example.bankprojet.Presentation;


import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Metier.IOperationsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class OperationsRestController {
    private IOperationsService operationsService;

    @PostMapping("/DebitOperation")
    public void debitOperation(@RequestBody Odto ddto) throws Exception {
        operationsService.debitOperation(ddto);
    }
    @PostMapping("/CreditOperation")
    public void creditOperation(@RequestBody Odto ddto) throws Exception {
        operationsService.creditOperation(ddto);
    }

    @PostMapping("/VersementOperation")
    public void versementOperation(@RequestBody VDto dto)throws Exception{
        operationsService.VersementOperation(dto);
    }
    @GetMapping("Operations/{id}")
    public List<OpeDto> getOperations(@PathVariable String id) {
        return operationsService.voireOperationsAcc(id);
    }
    @GetMapping("Oprations/aujourdhui")
    public List<OpeDto> getOperationsAujourdhui() {
        return operationsService.voireOperationlyom();
    }
}
