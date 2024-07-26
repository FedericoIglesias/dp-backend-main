package dhm.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accounts {
    @Id
    //@GeneratedValue
    Integer id;
    //@Column(nullable = false)*/
    String username;//email
    String password;
    String token;
}
