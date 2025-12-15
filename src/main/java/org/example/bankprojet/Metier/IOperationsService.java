package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.Operation;

import java.util.List;

public interface IOperationsService {
    void debitOperation(Odto ddto) throws Exception;
    void creditOperation(Odto odto) throws Exception;
    void VersementOperation(VDto vDto) throws Exception;
    List<OpeDto> voireOperationsAcc(String id);
}
