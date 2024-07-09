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
public class UsersResponse {
    String email;//username
    String name;
    String lastname;
    String phone;
    String alias;
    String cvu;
}
