package dhm_backend.register_login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    @PostMapping("/user")
    public String demo() {
        return "Hello world";
    }
}
