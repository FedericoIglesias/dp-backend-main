package dhm.profile.controller;

import dhm.profile.model.Transactions;
import dhm.profile.service.CheckLoginService;
import dhm.profile.model.Cards;
import dhm.profile.service.CardsService;
import dhm.profile.service.TransactionsService;
import dhm.profile.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    TransactionsService serviHistory;
    @Autowired
    CardsService serviCards;

    @Autowired
    UsersService serviUser;

    @Autowired
    CheckLoginService serviCheckLogin;

    @GetMapping("/{idUser}/cards")
    public ResponseEntity<List<Cards>> getListCards(@PathVariable Integer idUser){
        return ResponseEntity.ok(serviCards.getListCards(idUser));
    }

    @GetMapping("/{idUser}/cards/{idCard}")
    public ResponseEntity<Cards> getCard(@PathVariable("idUser") Integer idUser, @PathVariable("idCard") Integer idCard){
        return  ResponseEntity.ok(serviCards.getCard(idUser,idCard));
    }

    @PostMapping("/{idUser}/cards")
    public ResponseEntity saveCard(@RequestBody Cards card, @PathVariable("idUser") Integer idUser, HttpServletRequest request){
        Boolean check = serviCheckLogin.checkLogin(request, idUser);
        if(!check){
            return new ResponseEntity<>("Unsuccessful to create card", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
        card.setId(idUser);
        serviCards.saveCard(card);
        return new ResponseEntity<>("Success to create card", HttpStatus.CREATED);
    }

    @DeleteMapping("/{idUser}/cards/{idCard}")
    public ResponseEntity deleteCard(@PathVariable("idCard") Integer idCard,@PathVariable("idUser") Integer idUser, HttpServletRequest request){
        Boolean check = serviCheckLogin.checkLogin(request, idUser);
        if(!check){
            return new ResponseEntity<>("Unsuccessful to check user", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
        boolean  exist = serviCards.deleteCard(idCard);
        if(exist){
            return new ResponseEntity<>("Success to delete card", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unsuccessful to create card", HttpStatus.CREATED);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity getMoney(@PathVariable("idUser") Integer idUser, HttpServletRequest request){
        Boolean check = serviCheckLogin.checkLogin(request, idUser);
        return new ResponseEntity(serviUser.getUser(idUser).getMoney(),HttpStatus.OK);
    }

    @GetMapping("/{idUser}/transactions")
    public ResponseEntity getTransactionsOfUser(@PathVariable("idUser") Integer idUser, HttpServletRequest request){
        Boolean check = serviCheckLogin.checkLogin(request, idUser);
        List<Transactions> listTransactions = serviHistory.getTransactionsUser(idUser);
        return new ResponseEntity<>(listTransactions.subList(listTransactions.size() - 5, listTransactions.size()),
                HttpStatus.OK);
    }
}
