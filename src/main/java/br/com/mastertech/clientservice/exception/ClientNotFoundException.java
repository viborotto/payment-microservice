package br.com.mastertech.clientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client not found")
public class ClientNotFoundException extends RuntimeException{
}
