package dhm.register.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UsersResponse {
    String email;//username
    String name;
    String lastname;
    String phone;
    String alias;
    String cvu;
    Double money;
}
