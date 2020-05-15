package br.com.mastertech.cardservice.client;

import br.com.mastertech.cardservice.client.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service")
public interface ClientClient {

    ///client/{id}  ??
    @GetMapping("/{id}")
    ClientDTO findById(@PathVariable Long id);
}
