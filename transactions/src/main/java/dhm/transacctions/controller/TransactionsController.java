package dhm.transacctions.controller;

import dhm.transacctions.model.Transactions;
import dhm.transacctions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacctions")
public class TransactionsController {

    @Autowired
    TransactionsService serviTransaction;

    @GetMapping("/{id}")
    public Transactions getTransaction(@RequestParam Integer id) {
        return serviTransaction.getTransaction(id);
    }
}
