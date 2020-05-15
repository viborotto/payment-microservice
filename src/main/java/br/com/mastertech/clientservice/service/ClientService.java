package br.com.mastertech.clientservice.service;

import br.com.mastertech.clientservice.exception.ClientNotFoundException;
import br.com.mastertech.clientservice.model.Client;
import br.com.mastertech.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @ResponseStatus(HttpStatus.CREATED)
    public Client create (Client client) {
        System.out.println("Cliente created!"+System.currentTimeMillis());
        return clientRepository.save(client);
    }

    public Client findById(Long id){
        System.out.println("Searching client..."+ System.currentTimeMillis());
        Optional<Client> optionalClient = clientRepository.findById(id);

        //throw caso nao encontre:
        if(!optionalClient.isPresent()){
            throw new ClientNotFoundException();
        }
        
        return optionalClient.get();
    }
}
