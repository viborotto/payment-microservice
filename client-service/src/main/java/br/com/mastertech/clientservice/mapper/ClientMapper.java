package br.com.mastertech.clientservice.mapper;

import br.com.mastertech.clientservice.model.Client;
import br.com.mastertech.clientservice.model.dto.ClientDTO;

public class ClientMapper {

    public Client fromDtoToEntity(ClientDTO dto){
        Client entity = new Client();

        dto.setName(entity.getName());
        return entity;
    }

    public ClientDTO fromEntityToDto(Client entity){
        ClientDTO dto = new ClientDTO();

        entity.setName(dto.getName());
        return dto;
    }
}
