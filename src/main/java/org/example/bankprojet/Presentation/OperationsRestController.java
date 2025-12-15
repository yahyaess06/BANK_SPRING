package org.example.bankprojet.Presentation;


import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Metier.IOperationsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
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
    @GetMapping("Operations")
    public List<OpeDto> getOperations(String id){
        return operationsService.voireOperationsAcc(id);
    }
}
