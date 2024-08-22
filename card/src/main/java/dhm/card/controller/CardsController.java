package dhm.card.controller;

import dhm.card.model.Cards;
import dhm.card.model.Transference;
import dhm.card.service.CardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService serviCards;

    @GetMapping("/status")
    public ResponseEntity getStatus(){
        return new ResponseEntity<>("STATUS UP",HttpStatus.OK);
    }

    @Operation(summary = "Card", description = "Get a card list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success to owned card list",
            content = @Content(
                schema = @Schema(implementation = Cards.class))),
    })
    @GetMapping
    public ResponseEntity getListCards(){
        return new ResponseEntity(serviCards.getListCards(),HttpStatus.OK);
    }

    @Operation(summary = "Card", description = "Get a card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success get a card",
            content = @Content(
                schema = @Schema(implementation = Cards.class))),
    })
    @GetMapping("/{numberCard}")
    public ResponseEntity getCard(@PathVariable Integer numberCard){
        Cards card = serviCards.getCardByNumber(numberCard);
        card.setAccount(null);
        return new ResponseEntity(card,HttpStatus.OK);
    }

    @Operation(summary = "Card", description = "Delete a card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success delete a card")
    })
    @DeleteMapping("/{numberCard}")
    public ResponseEntity deleteCard(@PathVariable Integer numberCard){
        serviCards.deleteCard(numberCard);
        return new ResponseEntity<>("Success to delete card", HttpStatus.OK);
    }

    @Operation(summary = "Card", description = "Create a card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Success to save a card"),
        @ApiResponse(responseCode = "409", description = "Fail to save card")
    })
    @PostMapping
    public ResponseEntity saveCard(@RequestBody Cards card){
        Integer res = serviCards.saveCards(card);
        if(res == 0){
            return new ResponseEntity("Fail to save Card",HttpStatus.CONFLICT);
        }
        return new ResponseEntity("Success to save Card",HttpStatus.CREATED);
    }


    @Operation(summary = "Card", description = "Modify a card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success to modify a card")
    })
    @PutMapping("/{numberCard}")
    public ResponseEntity modifyCard(@PathVariable Integer numberCard, @RequestBody Cards card){
        serviCards.modifyCard(numberCard,card);
        return new ResponseEntity("Success to modify card",HttpStatus.OK);
    }

    @Operation(summary = "Card", description = "Get a card list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success get a card",
            content = @Content(
                schema = @Schema(implementation = Cards.class))),
    })
    @GetMapping("/account")
    public List<Cards> getUsersCards(@RequestParam Integer idUser){
        List<Cards> listCards = serviCards.getUserCards(idUser);
                for (Cards card : listCards){
                    card.setAccount(null);
                }
        return listCards;
    }

    @Operation(summary = "Card", description = "Delete a card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Delete a  card")})
    @DeleteMapping("/delete")
    public Integer deleteCardFromAccount(@RequestParam Integer id){
        System.out.println("into the delete");
        return serviCards.deleteCardFromAccount(id);
    }

    @Operation(summary = "Card", description = "Save transference ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Success to save a transference"),
        @ApiResponse(responseCode = "406", description = "Fail to save transference")
    })
    @PostMapping("/accounts/{idAccount}/transferences")
    public ResponseEntity saveTransference(@RequestBody Transference transference){
        Integer res = serviCards.saveTransference(transference);
        if(res == 0){
            return new ResponseEntity<>("Unsuccessful to save transference", HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>("Success to save transference", HttpStatus.CREATED);
    }
}
