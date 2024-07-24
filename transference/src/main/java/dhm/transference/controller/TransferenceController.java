package dhm.transference.controller;

import dhm.transference.model.Transference;
import dhm.transference.service.TransferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transference")
public class TransferenceController {

    @Autowired
    TransferenceService serviTransaction;

    @GetMapping("/status")
    public ResponseEntity getStatus(){
        return new ResponseEntity<>("STATUS UP", HttpStatus.OK);
    }

    @GetMapping
    public Transference getTransaction(@RequestParam Integer id) {
        return serviTransaction.getTransaction(id);
    }

    @PostMapping
    public void saveTransaction(@RequestBody Transference transference) {
        serviTransaction.saveTransaction(transference);
    }
}
