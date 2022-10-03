package nttdata.grupouno.com.operations.util;

import nttdata.grupouno.com.operations.models.MasterAccountModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Repository
public class WebClientApi {
    private WebClient webClient = WebClient.create("http://localhost:8001");
    
    public Mono<MasterAccountModel> findClient(String id){
        return webClient.get()
                        .uri("/api/clients/findByIdPerson/{idPerson}", id)
                        .retrieve()
                        .bodyToMono(MasterAccountModel.class);
    }
}
