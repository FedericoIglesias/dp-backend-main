package dhm.account.controller;

import dhm.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService serviAccount;

    @GetMapping("/{id}/transactions")
    public ResponseEntity getTransacciontUser(@PathVariable Integer id){
        return new ResponseEntity(serviAccount.getListTransactionUser(id), HttpStatus.OK);
    }
}
