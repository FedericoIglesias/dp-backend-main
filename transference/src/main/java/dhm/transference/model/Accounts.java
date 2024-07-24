package dhm.transference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id
    Integer id;
    Float amount;
    @OneToMany
    List<Cards> listCards;
    @OneToMany
    List<Transference> listTransactions;

}