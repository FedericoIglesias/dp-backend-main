package dhm.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Users {
    @Id
    //@GeneratedValue
    Integer id;
    //@Column(nullable = false)*/
    String username;//email
    String password;
    String token;
   /* String name;
    String lastname;
    String phone;

    String alias;
    String cvu;*/

}
