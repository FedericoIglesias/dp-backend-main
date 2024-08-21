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
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.function.ServerRequest;

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
    @ApiResponse(responseCode = "401", description = "User Unauthorized")
  })
  // /*ServerWebExchange exchange,*/ , HttpHeaders headers
  @GetMapping("/{idAccount}/transactions")
  public ResponseEntity getTransacciontUser(@PathVariable String idAccount, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity(serviAccount.getListTransactionUser(Integer.valueOf(idAccount)), HttpStatus.OK);
  }

  @Operation(summary = "Account", description = "This endpoint Account")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Get user transference",
      content = @Content(
        schema = @Schema(implementation = Transference.class))),
    @ApiResponse(responseCode = "403", description = "User Unauthorized")
  })
  @GetMapping("/{idAccount}/activity/{transferenceId}")
  public ResponseEntity getTransferenceUser(@PathVariable Integer idAccount, @PathVariable Integer transferenceId, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    System.out.println(token);
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount.toString())) {
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
  @GetMapping("/{idAccount}/activity")
  public ResponseEntity getActivityUser(@PathVariable Integer idAccount, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
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
  @GetMapping("/balance/{idAccount}")
  public ResponseEntity getAmount(@PathVariable Integer idAccount, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(serviAccount.getAmount(idAccount), HttpStatus.OK);
  }

  @Operation(summary = "Account", description = "This endpoint Account")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Get account",
      content = @Content(
        schema = @Schema(implementation = Transference.class))),
    @ApiResponse(responseCode = "403", description = "User Unauthorized")
  })
  @GetMapping("/{idAccount}")
  public ResponseEntity getInfo(@PathVariable Integer idAccount, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity(serviAccount.getAccount(idAccount), HttpStatus.OK);
  }

  @Operation(summary = "Account", description = "This endpoint Account")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Modify account",
      content = @Content(
        schema = @Schema(implementation = Accounts.class))),
    @ApiResponse(responseCode = "403", description = "User Unauthorized")
  })
  @PutMapping("/{idAccount}")
  public ResponseEntity modifyInfo(@PathVariable Integer idAccount, @RequestBody Accounts account, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(serviAccount.modifyAccount(idAccount, account), HttpStatus.ACCEPTED);
  }

  @Operation(summary = "Account", description = "This endpoint Account")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Get card list",
      content = @Content(
        schema = @Schema(implementation = Cards.class))),
    @ApiResponse(responseCode = "403", description = "User Unauthorized")
  })
  @GetMapping("/{idAccount}/cards")
  public ResponseEntity getListCardsAccounts(@PathVariable Integer idAccount, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(serviAccount.getCardsAccount(idAccount), HttpStatus.OK);
  }

  @Operation(summary = "Account", description = "This endpoint Account")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Get card",
      content = @Content(
        schema = @Schema(implementation = Cards.class))),
    @ApiResponse(responseCode = "403", description = "User Unauthorized")
  })
  @GetMapping("/{idAccount}/cards/{idCard}")
  public ResponseEntity getListCardsAccounts(@PathVariable Integer idAccount, @PathVariable Integer idCard, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
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
  @PostMapping("/{idAccount}/cards")
  public ResponseEntity saveCard(@PathVariable Integer idAccount, @RequestBody Cards card, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
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
  @DeleteMapping("/{idAccount}/cards/{idCard}")
  public ResponseEntity deleteCard(@PathVariable Integer idAccount, @PathVariable Integer idCard, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("AUTHORIZATION");
    if (token == null || !serviJwt.getIdFromToken(token.substring(7)).equals(idAccount)) {
      return new ResponseEntity<>("User Unauthorized", HttpStatus.UNAUTHORIZED);
    }
    Integer res = serviAccount.deleteCard(idCard);
    if (res == 0) {
      return new ResponseEntity<>("Card not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Success to delete card", HttpStatus.OK);
  }
}
