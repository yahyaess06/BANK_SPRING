package org.example.bankprojet.Mappers;

import org.example.bankprojet.DTO.OpDTO;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.Entities.Operation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperOp {
    public OpeDto aOpeDto(Operation op) {
        OpeDto opeDto = new OpeDto();
        BeanUtils.copyProperties(op, opeDto);
        return opeDto;
    }
//    public Operation aOperation(OpeDto opeDto) {
//        Operation op = new Operation();
//        BeanUtils.copyProperties(opeDto, op);
//        return op;
//    }
    public OpDTO aOpDto(Operation op){
        OpDTO opDto = new OpDTO();
        opDto.setCompteId(op.getCompteBancaire().getId());
        opDto.setDateOp(op.getDateOp());
        opDto.setType_operation(op.getType_operation());
        opDto.setMontant(op.getMontant());
        return opDto;
    }
}
