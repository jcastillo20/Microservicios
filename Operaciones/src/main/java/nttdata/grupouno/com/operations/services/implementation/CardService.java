package nttdata.grupouno.com.operations.services.implementation;

import nttdata.grupouno.com.operations.models.CardModel;
import nttdata.grupouno.com.operations.models.MasterAccountModel;
import nttdata.grupouno.com.operations.repositories.implementation.CardRepository;
import nttdata.grupouno.com.operations.services.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MasterAccountServices masterAccountServices;
    @Override
    public void createCard(CardModel card) {
        cardRepository.save(card).subscribe();
    }

    @Override
    public Mono<CardModel> findCardById(Integer id) {
        return cardRepository.findById(id);
    }

    @Override
    public Flux<CardModel> findAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Mono<CardModel> updateCard(CardModel card, Integer id) {
        //return cardRepository.findById(id).flatMap(c -> cardRepository.save(card));
        return cardRepository.save(card);
    }

    @Override
    public Mono<CardModel> findByNumberCard(String numberCard){return cardRepository.findByNumberCard(numberCard);}

    public Mono<MasterAccountModel> findMainId(Mono<CardModel> card){
        return card.flatMap(c -> masterAccountServices.findById(c.getIdMainMasterAccount()));
    }

}
