package org.example.bankprojet.Mappers;

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
    public Operation aOperation(OpeDto opeDto) {
        Operation op = new Operation();
        BeanUtils.copyProperties(opeDto, op);
        return op;
    }
}
