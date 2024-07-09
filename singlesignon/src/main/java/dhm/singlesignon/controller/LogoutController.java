package dhm.singlesignon.controller;

import dhm.singlesignon.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    LogoutService serviLogout;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("STATUS OK");
    }

    @PostMapping("/user")
    public ResponseEntity<String> logout(@RequestHeader(value = "Authorization") String token) {
        String msg = serviLogout.invalidateToken(token.substring(7));
        return ResponseEntity.ok(msg);
    }
}
