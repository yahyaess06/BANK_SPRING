package org.example.bankprojet.Mappers;

import org.example.bankprojet.DTO.Cdto;
import org.example.bankprojet.Entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperClients {
    public Cdto tClientaDto(Client client) {
        Cdto cdto = new Cdto();
        BeanUtils.copyProperties(client, cdto);
        return cdto;
    }
    public Client tDtoaClient(Cdto cdto) {
        Client client = new Client();
        BeanUtils.copyProperties(cdto, client);
        return client;
    }
}
