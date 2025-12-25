package org.example.bankprojet.Metier;

import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpDTO;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Exceptions.CompteNonActiveeException;

import java.util.List;

public interface IOperationsService {
    void debitOperation(Odto ddto) throws Exception, CompteNonActiveeException;
    void creditOperation(Odto odto) throws Exception;
    void VersementOperation(VDto vDto) throws Exception;
    List<OpeDto> voireOperationsAcc(String id);

    List<OpDTO> voireOperationlyom();
}
