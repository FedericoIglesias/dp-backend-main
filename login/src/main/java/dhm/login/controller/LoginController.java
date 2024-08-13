package dhm.login.controller;

import dhm.login.dto.LoginRequestDTO;
import dhm.login.dto.LoginResponseDTO;
import dhm.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService serviLogin;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("STATUS OK");
    }

    @Operation(summary = "Login user", description = "This endpoint logged the user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User logged successful",
            content = @Content(
                schema = @Schema(implementation = LoginResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid User or Password")
    })
    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO requestDTO){
        LoginResponseDTO res = serviLogin.login(requestDTO);
        if(res == null){
            return ResponseEntity.badRequest().body("Invalid User or Password");
        }
        return ResponseEntity.ok(res.getToken());
    }
}
