package nttdata.grupouno.com.Clients.util;

import org.springframework.web.reactive.function.client.WebClient;

import nttdata.grupouno.com.Clients.models.MasterAccount;
import reactor.core.publisher.Flux;

public class WebOperationsApi {
	
    private WebClient webClient = WebClient.create("http://localhost:8010");
    
    public Flux<MasterAccount> findMasterAccountsByClient(String id){
        return webClient.get()
                        .uri("/operation/account/client/{id}", id)
                        .retrieve()
                        .bodyToFlux(MasterAccount.class);
    }

}
