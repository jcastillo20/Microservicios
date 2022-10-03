package nttdata.grupouno.com.operations.controllers;

import nttdata.grupouno.com.operations.models.CardAccountModel;
import nttdata.grupouno.com.operations.models.CardModel;
import nttdata.grupouno.com.operations.services.implementation.CardAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/operation/cardxAcc")
public class CardAccountController {

    @Autowired
    CardAccountService cardAccountService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRelation(@RequestBody CardAccountModel relation){cardAccountService.createCardAccount(relation);}

    @GetMapping("/id/{id}")
    public ResponseEntity<Mono<CardAccountModel>> findAssociationById(@PathVariable("id") Integer id){
        Mono<CardAccountModel> cardXAcc = cardAccountService.findAssociationById(id);
        return new ResponseEntity<>(cardXAcc, cardXAcc!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Integer id){
        return cardAccountService.findAssociationById(id).flatMap(a -> cardAccountService.deleteBydId(a.getId())
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
