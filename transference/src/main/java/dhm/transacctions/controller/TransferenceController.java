package dhm.transacctions.controller;

import dhm.transacctions.model.Transference;
import dhm.transacctions.service.TransferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransferenceController {

    @Autowired
    TransferenceService serviTransaction;

    @GetMapping("/transaction")
    public Transference getTransaction(@RequestParam Integer id) {
        return serviTransaction.getTransaction(id);
    }

    @PostMapping
    public void saveTransaction(@RequestBody Transference transference) {
        serviTransaction.saveTransaction(transference);
    }
}
