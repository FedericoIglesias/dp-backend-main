package dhm.account.controller;

import dhm.account.model.Accounts;
import dhm.account.model.Cards;
import dhm.account.model.Transference;
import dhm.account.service.AccountService;
import dhm.account.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService serviAccount;

    @Autowired
    JwtService serviJwt;

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        return new ResponseEntity("STATUS UP", HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get transference list",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}/transactions")
    public ResponseEntity getTransacciontUser(@PathVariable Integer id, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(serviAccount.getListTransactionUser(id), HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get user transference",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}/activity/{transferenceId}")
    public ResponseEntity getTransferenceUser(@PathVariable Integer id, @PathVariable Integer transferenceId, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity("You transference is: " + transferenceId, HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get activity",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}/activity")
    public ResponseEntity getActivityUser(@PathVariable Integer id, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity("Your activity", HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get user activity",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/balance/{id}")
    public ResponseEntity getAmount(@PathVariable Integer id, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(serviAccount.getAmount(id), HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get account",
            content = @Content(
                schema = @Schema(implementation = Transference.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}")
    public ResponseEntity getInfo(@PathVariable Integer id, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(serviAccount.getAccount(id), HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modify account",
            content = @Content(
                schema = @Schema(implementation = Accounts.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @PutMapping("/{id}")
    public ResponseEntity modifyInfo(@PathVariable Integer id, @RequestBody Accounts account, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(serviAccount.modifyAccount(id, account), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get card list",
            content = @Content(
                schema = @Schema(implementation = Cards.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}/cards")
    public ResponseEntity getListCardsAccounts(@PathVariable Integer id, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(serviAccount.getCardsAccount(id), HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get card",
            content = @Content(
                schema = @Schema(implementation = Cards.class))),
        @ApiResponse(responseCode = "403", description = "User Unauthorized")
    })
    @GetMapping("/{id}/cards/{idCard}")
    public ResponseEntity getListCardsAccounts(@PathVariable Integer id, @PathVariable Integer idCard, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(serviAccount.getCard(idCard), HttpStatus.OK);
    }

    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Create card"),
        @ApiResponse(responseCode = "403", description = "User Unauthorized"),
        @ApiResponse(responseCode = "409", description = "Conflict to save a card")
    })
    @PostMapping("/{id}/cards")
    public ResponseEntity saveCard(@PathVariable Integer id, @RequestBody Cards card, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        Integer res = serviAccount.saveCard(card);
        if (res == 1) {
            return new ResponseEntity<>("Success to save card", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Conflict to save card", HttpStatus.CONFLICT);
    }


    @Operation(summary = "Account", description = "This endpoint Account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Delete card"),
        @ApiResponse(responseCode = "404", description = "User Unauthorized"),
        @ApiResponse(responseCode = "409", description = "Conflict to save a card")
    })
    @DeleteMapping("/{id}/cards/{idCard}")
    public ResponseEntity deleteCard(@PathVariable Integer id, @PathVariable Integer idCard, ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);
        if (!serviJwt.getIdFromToken(token).equals(id)) {
            return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        Integer res = serviAccount.deleteCard(idCard);
        if (res == 0) {
            return new ResponseEntity<>("Card not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Success to delete card", HttpStatus.OK);
    }
}
