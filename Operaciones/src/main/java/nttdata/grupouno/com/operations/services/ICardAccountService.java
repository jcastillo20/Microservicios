package nttdata.grupouno.com.operations.services;

import nttdata.grupouno.com.operations.models.CardAccountModel;
import nttdata.grupouno.com.operations.services.implementation.CardAccountService;
import reactor.core.publisher.Mono;

public interface ICardAccountService {
    void createCardAccount(CardAccountModel cardAcc);

    Mono<CardAccountModel> findAssociationById(Integer id);
    Mono<Void> deleteBydId(Integer id);
}
