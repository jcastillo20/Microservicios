package nttdata.grupouno.com.operations.services.implementation;

import nttdata.grupouno.com.operations.models.CardAccountModel;
import nttdata.grupouno.com.operations.repositories.implementation.CardAccountRepository;
import nttdata.grupouno.com.operations.services.ICardAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CardAccountService implements ICardAccountService {

    @Autowired
    private CardAccountRepository cardAccountRepository;

    @Override
    public void createCardAccount(CardAccountModel cardAcc) {cardAccountRepository.save(cardAcc).subscribe();}

    @Override
    public Mono<CardAccountModel> findAssociationById(Integer id) {
        return cardAccountRepository.findById(id);
    }


    @Override
    public Mono<Void> deleteBydId(Integer id) {return cardAccountRepository.deleteById(id);}
}
