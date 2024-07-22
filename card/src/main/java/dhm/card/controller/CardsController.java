package dhm.card.controller;

import dhm.card.model.Cards;
import dhm.card.model.Transference;
import dhm.card.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService serviCards;

    @GetMapping("/status")
    public ResponseEntity getStatus(){
        return new ResponseEntity<>("STATUS UP",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getListCards(){
        return new ResponseEntity(serviCards.getListCards(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable Integer id){
        Cards card = serviCards.getCard(id);
        card.setAccount(null);
        return new ResponseEntity(card,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Integer id){
        serviCards.deleteCard(id);
        return new ResponseEntity<>("Succes to delete card", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCard(@RequestBody Cards card){
        Integer res = serviCards.saveCards(card);
        if(res == 0){
            return new ResponseEntity("Fail to save Card",HttpStatus.CONFLICT);
        }
        return new ResponseEntity("Success to save Card",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyCard(@PathVariable Integer id, @RequestBody Cards card){
        serviCards.modifyCard(id,card);
        return new ResponseEntity("Success to modify card",HttpStatus.OK);
    }

    @GetMapping("/account")
    public List<Cards> getUsersCards(@RequestParam Integer idUser){
        List<Cards> listCards = serviCards.getUserCards(idUser);
                for (Cards card : listCards){
                    card.setAccount(null);
                }
        return listCards;
    }
    @PostMapping("/save")
    public Integer saveCardFromAccount(@RequestBody Cards card){
        return serviCards.saveCards(card);
    }

    @DeleteMapping("/delete")
    public Integer deleteCardFromAccount(@RequestParam Integer id){
        System.out.println("into the delete");
        return serviCards.deleteCardFromAccount(id);
    }

    @PostMapping("/accounts/{id}/transferences")
    public ResponseEntity saveTransference(@RequestBody Transference transference){
        Integer res = serviCards.saveTransference(transference);
        if(res == 0){
            return new ResponseEntity<>("Unsuccessful to save transference", HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>("Success to save transference", HttpStatus.CREATED);
    }
}
