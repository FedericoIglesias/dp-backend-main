package dhm_backend.register_login.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersRegister {
    String email;//email
    String name;
    String lastname;
    String phone;
    String alias;
    String cvu;
}
