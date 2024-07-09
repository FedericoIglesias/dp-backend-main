package dhm.singlesignon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false, unique = true)
    String username;//email
    String name;
    String lastname;
    String phone;
    String password;
    @Column(nullable = false,unique = true)
    String alias;
    @Column(nullable = false,unique = true)
    String cvu;
    String token;

}
