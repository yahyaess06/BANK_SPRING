package org.example.bankprojet.Mappers;


import org.example.bankprojet.DTO.Cbdto;
import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.DTO.DTOaffichageb;
import org.example.bankprojet.Entities.Client;
import org.example.bankprojet.Entities.CompteBancaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperBank {
    public DTOaffichageb tBankDto(CompteBancaire cb) {
        DTOaffichageb dab = new DTOaffichageb();
        BeanUtils.copyProperties(cb, dab);
        return dab;
    }
}
