package dhm.card.controller;

import dhm.card.model.Cards;
import dhm.card.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService serviCards;

    @GetMapping
    public ResponseEntity getListCards(){
        return new ResponseEntity(serviCards.getListCards(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable Integer id){
        return new ResponseEntity(serviCards.getCard(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Integer id){
        serviCards.deleteCard(id);
        return new ResponseEntity<>("Succes to delete card", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCard(@RequestBody Cards card){
        serviCards.saveCards(card);
        return new ResponseEntity("Success to save Card",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyCard(@PathVariable Integer id, @RequestBody Cards card){
        serviCards.modifyCard(id,card);
        return new ResponseEntity("Success to modify card",HttpStatus.OK);
    }
}
