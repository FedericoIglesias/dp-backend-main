package dhm.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
        Double amount = 00.00;
        @Column(nullable = false,unique = true)
        String alias;
        @Column(nullable = false,unique = true)
        String cvu;
        String token;
        @OneToMany(mappedBy = "account")
        List<Cards> listCards;
        @OneToMany(mappedBy = "account")
        List<Transactions> listTransactions;
}