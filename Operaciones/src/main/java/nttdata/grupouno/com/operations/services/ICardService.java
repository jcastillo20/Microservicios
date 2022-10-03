package nttdata.grupouno.com.operations.services;

import nttdata.grupouno.com.operations.models.CardModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICardService {

    void createCard(CardModel card);
    Mono<CardModel> findCardById(Integer id);
    Flux<CardModel> findAllCards();
    Mono<CardModel> findByNumberCard(String numberCard);
}
