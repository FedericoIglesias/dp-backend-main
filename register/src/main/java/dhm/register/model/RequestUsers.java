package dhm.register.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUsers {
    String email;//username
    String name;
    String lastname;
    String phone;
    String password;
}
