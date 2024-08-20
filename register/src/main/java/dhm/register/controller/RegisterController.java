package dhm.register.controller;

import dhm.register.dto.UsersResponse;
import dhm.register.model.RequestUsers;
import dhm.register.model.Accounts;
import dhm.register.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  AccountsService serviAccount;

  @GetMapping("/status")
  public ResponseEntity<String> status() {
    return ResponseEntity.ok("STATUS OK");
  }


  @Operation(summary = "Register user", description = "This endpoint register the a new user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User generated successful",
          content = @Content(
          schema = @Schema(implementation = UsersResponse.class))),
      @ApiResponse(responseCode = "406", description = "Invalid email")
  })
  @PostMapping("/user")
  public ResponseEntity register(@RequestBody RequestUsers request) {
    String emailPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,6}$";
    Pattern pattern = Pattern.compile(emailPattern);
    Matcher matcher = pattern.matcher(request.getEmail());
    if (!matcher.matches()) {
      return new ResponseEntity<>("The email is wrong", HttpStatus.NOT_ACCEPTABLE);
    }
    Accounts user = Accounts.builder()
        .name(request.getName())
        .phone(request.getPhone())
        .username(request.getEmail())
        .lastname(request.getLastname())
        .password(request.getPassword())
        .money(0.0)
        .build();
    UsersResponse resUser = serviAccount.registerUser(user);
    return new ResponseEntity<>(resUser, HttpStatus.CREATED);
  }
}
