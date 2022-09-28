package nttdata.grupouno.com.operations.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import nttdata.grupouno.com.operations.models.AccountClientModel;
import nttdata.grupouno.com.operations.repositories.implementation.AccountClientRepositorio;
import nttdata.grupouno.com.operations.services.implementation.AccountClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import nttdata.grupouno.com.operations.util.*;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class AccountClientServiceTest {
    @Mock
    private AccountClientRepositorio accountClientRepositorio;
    @Mock
    private WebClientApi apiClient;
    @InjectMocks
    private AccountClientService accountClientService;
    @Autowired
    private Mono<AccountClientModel> accountClientModel;
    @Autowired
    private Flux<AccountClientModel> accountClienteModels;
    @Autowired
    private Mono<Long> countClienType;

    @BeforeEach
    void init() {
        accountClientModel = Mono.just(new AccountClientModel("1", "12", "N", "T", "AHO1"));
        accountClienteModels = accountClientModel.flux();
        countClienType = Mono.just(Long.valueOf("1"));
    }

    @Test
	void findById() {
        assertNotNull(accountClientModel);

        Mockito.when(accountClientRepositorio.findById("1")).thenReturn(accountClientModel);
        Mono<AccountClientModel> response = accountClientService.findById("1");

        assertEquals(accountClientModel, response);
        response.subscribe(x -> {
            assertEquals(x.getCodeClient(), "1");
            assertEquals(x.getNumberAccount(), "12");
        });
	}

    @Test
    void countByCodeClientAndTypeAccount() {
        Mockito.when(accountClientRepositorio.countByCodeClientAndTypeAccount("1", "AHO")).thenReturn(countClienType);
        Mono<Long> countResponse = accountClientService.countByCodeClientAndTypeAccount("1", "AHO");
        
        assertEquals(countResponse, countClienType);
        countResponse.subscribe(x -> assertEquals(x, 1));
    }

    @Test
    void findAll(){
        Mockito.when(accountClientRepositorio.findAll()).thenReturn(accountClienteModels);
        Flux<AccountClientModel> response = accountClientService.findAll();
        assertEquals(response, accountClienteModels);
    }

    @Test
    void findByClientTypeAccount(){
        Mockito.when(accountClientRepositorio.findByNumberAccountAndTypeAccount("1", "AHO")).thenReturn(accountClienteModels);
        Flux<AccountClientModel> response = accountClientService.findByClientTypeAccount("1", "AHO");
        assertEquals(response, accountClienteModels);
    }
}
