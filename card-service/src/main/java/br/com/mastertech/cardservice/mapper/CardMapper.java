package br.com.mastertech.cardservice.mapper;

import br.com.mastertech.cardservice.model.Card;
import br.com.mastertech.cardservice.model.dto.CardDTO;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public Card fromDtoToEntity(CardDTO dto){
        Card entity = new Card();

        entity.setNumber(dto.getNumber());
        entity.setActive(dto.isActive());
        entity.setUserId(dto.getUserId());

        return entity;
    }

    public CardDTO fromEntityToDto(Card entity){
        CardDTO dto = new CardDTO();

        dto.setActive(entity.isActive());
        dto.setNumber(entity.getNumber());
        dto.setUserId(entity.getUserId());

        return dto;
    }
}
