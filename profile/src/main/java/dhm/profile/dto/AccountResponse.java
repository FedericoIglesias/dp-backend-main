package dhm.profile.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    String email;//username
    String name;
    String lastname;
    String phone;
    String password;
    String alias;
    String cvu;
    String token;
    Float money;
}
