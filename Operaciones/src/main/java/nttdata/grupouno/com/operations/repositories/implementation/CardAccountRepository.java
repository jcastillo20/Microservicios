package nttdata.grupouno.com.operations.repositories.implementation;

import nttdata.grupouno.com.operations.models.CardAccountModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardAccountRepository extends ReactiveMongoRepository<CardAccountModel, Integer> {}
