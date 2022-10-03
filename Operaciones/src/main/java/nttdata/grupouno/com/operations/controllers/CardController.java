package nttdata.grupouno.com.operations.controllers;

import nttdata.grupouno.com.operations.models.CardModel;
import nttdata.grupouno.com.operations.services.implementation.CardService;
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

}
