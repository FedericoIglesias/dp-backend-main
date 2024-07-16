package dhm.logout.model;

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
public class Accounts {
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false)
    String username;//email
    String name;
    String lastname;
    String phone;
    String password;
    String alias;
    String cvu;
    String token;

}