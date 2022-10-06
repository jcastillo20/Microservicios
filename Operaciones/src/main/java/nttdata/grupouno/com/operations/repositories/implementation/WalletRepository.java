package nttdata.grupouno.com.operations.repositories.implementation;

import nttdata.grupouno.com.operations.models.WalletModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends ReactiveMongoRepository<WalletModel, Integer> {
}
