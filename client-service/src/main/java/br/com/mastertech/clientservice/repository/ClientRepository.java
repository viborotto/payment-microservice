package br.com.mastertech.clientservice.repository;

import br.com.mastertech.clientservice.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
