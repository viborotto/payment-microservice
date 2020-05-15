package br.com.mastertech.clientservice.controller;

import br.com.mastertech.clientservice.mapper.ClientMapper;
import br.com.mastertech.clientservice.model.Client;
import br.com.mastertech.clientservice.model.dto.ClientDTO;
import br.com.mastertech.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ClientDTO newClient(@RequestBody ClientDTO clientDTO){
        Client entity = clientMapper.fromDtoToEntity(clientDTO);

        entity = clientService.create(entity);
        //podemos retornar um ResponseEntity tbm, fica a criterio
        return clientMapper.fromEntityToDto(entity);
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id){
        Client entity = clientService.findById(id);
        return clientMapper.fromEntityToDto(entity);
    }

}
