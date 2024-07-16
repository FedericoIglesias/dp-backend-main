package dhm.transacctions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        Float money;
        @OneToOne
        Users user;
        @OneToMany(mappedBy = "account")
        List<Cards> listCards;
        @OneToMany(mappedBy = "account")
        List<Transactions> listTransactions;

    }