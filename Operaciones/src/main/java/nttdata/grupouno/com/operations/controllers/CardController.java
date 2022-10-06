package nttdata.grupouno.com.operations.controllers;

import nttdata.grupouno.com.operations.models.CardModel;
import nttdata.grupouno.com.operations.models.MasterAccountModel;
import nttdata.grupouno.com.operations.services.implementation.CardService;
import nttdata.grupouno.com.operations.services.implementation.MasterAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/operation/card")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    MasterAccountServices masterAccountServices;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody CardModel card){cardService.createCard(card);}

    @GetMapping(value = "/all")
    @ResponseBody
    public Flux<CardModel> findAllCards(){return cardService.findAllCards();}

    @GetMapping("/id/{id}")
    public ResponseEntity<Mono<CardModel>> findCardById(@PathVariable("id") Integer id){
        Mono<CardModel> cardX = cardService.findCardById(id);
        return new ResponseEntity<>(cardX, cardX!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/numberCard/{numberCard}")
    public ResponseEntity<Mono<CardModel>> findByNumberCard(@PathVariable("numberCard") String numberCard){
        Mono<CardModel> cardX = cardService.findByNumberCard(numberCard);
        return new ResponseEntity<>(cardX, cardX!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mainAccount/{idCard}/{idAccount}")
    public ResponseEntity<Mono<CardModel>> update(@PathVariable Integer idCard,
                                                  @PathVariable String idAccount){
        Mono<CardModel> card = cardService.findCardById(idCard);
        if(card!=null){
            card.map(t -> {
                System.out.println("Tarjeta encontrada: " + t.getId());
                return masterAccountServices.findById(idAccount).map(a -> {
                    t.setIdMainMasterAccount(idAccount);
                    cardService.createCard(t);
                    System.out.println("Cuenta: " + t.getIdMainMasterAccount());
                    System.out.println("Agregado");
                    return a;
                }).subscribe();
            }).subscribe();
            return new ResponseEntity<>(cardService.findCardById(idCard), HttpStatus.OK);
        }
        else {
            System.out.println("Tarjeta no encontrada");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/checkMainAcc/{id}")
    public ResponseEntity<Mono<MasterAccountModel>> checkMainAccount(@PathVariable Integer id){
        Mono<CardModel> card = cardService.findCardById(id);
        Mono<MasterAccountModel> acc = cardService.findMainId(card);
        return new ResponseEntity<>(acc, acc!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
