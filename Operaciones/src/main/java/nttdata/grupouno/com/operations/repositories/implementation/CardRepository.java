package nttdata.grupouno.com.operations.repositories.implementation;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import nttdata.grupouno.com.operations.models.CardModel;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<CardModel, Integer>{
    Mono<CardModel> findByNumberCard(String numberCard);
}
