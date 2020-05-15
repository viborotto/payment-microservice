package br.com.mastertech.cardservice.service;

import br.com.mastertech.cardservice.client.ClientClient;
import br.com.mastertech.cardservice.client.dto.ClientDTO;
import br.com.mastertech.cardservice.exception.CardNotFoundException;
import br.com.mastertech.cardservice.model.Card;
import br.com.mastertech.cardservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientClient clientClient;

    //falta os throw

    //POST
    public Card createCard(Card card){
        ClientDTO dto = clientClient.findById(card.getClientId());
        return cardRepository.save(card);
    }

    //GETS
    public Card findById(Long id){
        Optional<Card> card = cardRepository.findById(id);
//        return validatePresentCard(card);
        return card.get();
    }

    public Card findByNumber(String cardNumber){
        Optional<Card> optionalCard = cardRepository.findByNumber(cardNumber);
        return optionalCard.get();
    }

    //verifica se o cartao existe
    private Card validatePresentCard(Optional<Card> card) throws CardNotFoundException {
        if(!card.isPresent()) {
            throw new CardNotFoundException();
        }
        return card.get();
    }

    //UPDATE
    public Card updateActive(String cardNumber, boolean isActive) throws CardNotFoundException {
        Optional<Card> cardOptional = cardRepository.findByNumber(cardNumber);

        if(!cardOptional.isPresent()) {
            throw new CardNotFoundException();
        }

        Card card = cardOptional.get();
        card.setActive(isActive);
        return cardRepository.save(card);
    }

}
