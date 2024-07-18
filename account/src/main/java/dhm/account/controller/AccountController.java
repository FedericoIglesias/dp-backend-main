package dhm.account.controller;

import dhm.account.model.Accounts;
import dhm.account.model.Cards;
import dhm.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService serviAccount;

    @GetMapping("/{id}/transactions")
    public ResponseEntity getTransacciontUser(@PathVariable Integer id) {
        //return new ResponseEntity(serviAccount.getListTransactionUser(id), HttpStatus.OK);
        return new ResponseEntity("serviAccount.getListTransactionUser(id)", HttpStatus.OK);
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity getAmount(@PathVariable Integer id) {
        return new ResponseEntity<>(serviAccount.getAmount(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInfo(@PathVariable Integer id) {
        return new ResponseEntity(serviAccount.getAccount(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyInfo(@PathVariable Integer id, @RequestBody Accounts account) {

        return new ResponseEntity<>(serviAccount.modifyAccount(id, account), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/cards")
    public ResponseEntity getListCardsAccounts(@PathVariable Integer id) {
        return new ResponseEntity<>(serviAccount.getCardsAccount(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/cards/{idCard}")
    public ResponseEntity getListCardsAccounts(@PathVariable Integer id, @PathVariable Integer idCard) {
        return new ResponseEntity<>(serviAccount.getCard(idCard), HttpStatus.OK);
    }

    @PostMapping("/{id}/cards")
    public ResponseEntity saveCard(@PathVariable Integer id, @RequestBody Cards card) {
        Integer res = serviAccount.saveCard(card);
        if (res == 1) {
            return new ResponseEntity<>("Success to save card", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Conflict to save card", HttpStatus.CONFLICT);
    }

}
