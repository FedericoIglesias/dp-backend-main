package dhm.transference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    @GeneratedValue
    Integer id;
    String bank;
    Integer number;
    String endDate;
    Integer cvv;
    @ManyToOne
    Accounts account;

}
