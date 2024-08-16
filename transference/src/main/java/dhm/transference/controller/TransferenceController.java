package dhm.transference.controller;

import dhm.transference.model.Transference;
import dhm.transference.service.TransferenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Trasnference", description = "This endpoint deliveries transference")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get transference",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
    })
    @GetMapping
    public Transference getTransaction(@RequestParam Integer id) {
        return serviTransaction.getTransaction(id);
    }

    @Operation(summary = "Trasnference", description = "This endpoint create transference")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Save transference")
    })
    @PostMapping
    public void saveTransaction(@RequestBody Transference transference) {
        serviTransaction.saveTransaction(transference);
    }
}
