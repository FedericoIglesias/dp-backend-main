package dhm.jwt.controller;

import dhm.jwt.dto.Users;
import dhm.jwt.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
public class JwtController {

  @Autowired
  JwtService serviJwt;

  @Operation(summary = "JWT", description = "This endpoint jwt")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Deliveries a token"),
  })
  @GetMapping("/token")
  public String getToken(@RequestParam String username, @RequestParam Integer id) {
    return serviJwt.getToken(username, id);
  }

  @Operation(summary = "JWT", description = "This endpoint jwt")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Deliveries the name into from token"),
  })
  @GetMapping("/username")
  public String getUsernameFromToken(@RequestParam String token) {
    return serviJwt.getUsernameFromToken(token);
  }

  @Operation(summary = "JWT", description = "This endpoint jwt")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Deliveries the id into from token"),
  })
  @GetMapping("/id")
  public String getIdFromToken(@RequestParam String token) {
    if(serviJwt.isTokenExpired(token)){
      return  null;
    }
      return serviJwt.getIdFromToken(token);


  }

  @Operation(summary = "JWT", description = "This endpoint jwt")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Check if the token wasn't expired"),
  })
  @GetMapping("/validate")
  public Boolean isValidate(@RequestParam String token) {
    return serviJwt.isTokenExpired(token);
  }

  @GetMapping("/status")
  public ResponseEntity<String> status() {
    return ResponseEntity.ok("STATUS OK");
  }
}
