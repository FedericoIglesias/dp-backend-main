package dhm_backend.register_login.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String email;//username
    String name;
    String lastname;
    String phone;
    String password;
    String alias;
    Integer cvu;
}
