package dhm.profile.controller;

import dhm.profile.service.CheckLoginService;
import dhm.profile.model.Cards;
import dhm.profile.service.CardsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService serviCards;

    @Autowired
    CheckLoginService serviCheckLogin;

    @GetMapping("/accounts/{idUser}/cards")
    public ResponseEntity<List<Cards>> getListCards(@PathVariable Integer idUser){
        return ResponseEntity.ok(serviCards.getListCards(idUser));
    }

    @GetMapping("/accounts/{idUser}/cards/{idCard}")
    public ResponseEntity<Cards> getCard(@PathVariable("idUser") Integer idUser, @PathVariable("idCard") Integer idCard){
        return  ResponseEntity.ok(serviCards.getCard(idUser,idCard));
    }

    @PostMapping("/accounts/{idUser}/cards")
    public ResponseEntity saveCard(@RequestBody Cards card, @PathVariable("idUser") Integer idUser, HttpServletRequest request){
        Boolean check = serviCheckLogin.checkLogin(request, idUser);
        if(!check){
            return new ResponseEntity<>("Success to create card", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
        card.setId(idUser);
        serviCards.saveCard(card);
        return new ResponseEntity<>("Success to create card", HttpStatus.CREATED);

    }

}
