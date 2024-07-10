package dhm.profile.controller;

import dhm.profile.model.Cards;
import dhm.profile.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService serviCards;

    @GetMapping("/accounts/{idUser}/cards")
    public ResponseEntity<List<Cards>> getListCards(@PathVariable Integer idUser){
        return ResponseEntity.ok(serviCards.getListCards(idUser));
    }

    @GetMapping("/accounts/{idUser}/cards/{idCard}")
    public ResponseEntity<Cards> getCard(@PathVariable("idUser") Integer idUser, @PathVariable("idCard") Integer idCard){
        return  ResponseEntity.ok(serviCards.getCard(idUser,idCard));
    }


}
