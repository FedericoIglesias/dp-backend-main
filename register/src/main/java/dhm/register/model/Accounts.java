package dhm.register.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accounts {
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false, unique = true)
    String username;//email
    String password;
    String name;
    String lastname;
    String phone;
    @Column(nullable = false)
    Double money = 00.00;
    @Column(nullable = false,unique = true)
    String alias;
    @Column(nullable = false,unique = true)
    String cvu;
    String token;
}
