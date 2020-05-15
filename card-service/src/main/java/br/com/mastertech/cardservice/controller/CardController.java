package br.com.mastertech.cardservice.controller;

import br.com.mastertech.cardservice.mapper.CardMapper;
import br.com.mastertech.cardservice.model.Card;
import br.com.mastertech.cardservice.model.dto.CardDTO;
import br.com.mastertech.cardservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardDTO newCard(@RequestBody CardDTO dto){
        Card entity = cardMapper.fromDtoToEntity(dto);

        entity = cardService.createCard(entity);
        return cardMapper.fromEntityToDto(entity);
    }

    @PatchMapping("/{number}")
    public CardDTO updateActive(@PathVariable String number, @RequestBody CardDTO dto){
        Card entity = cardMapper.fromDtoToEntity(dto);
        entity= cardService.updateActive(number, );
        return cardMapper.fromEntityToDto(entity);
    }

    @GetMapping("/{number}")
    public CardDTO getCardByNumber(@PathVariable String cardNumber){

    }

    @GetMapping("/id/{id}")
    public CardDTO getCardById(@PathVariable Long id) {

    }

}
