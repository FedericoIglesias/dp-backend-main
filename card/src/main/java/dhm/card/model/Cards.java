package dhm.card.model;

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
    @Column(nullable = false)
    String bank;
    @Column(unique = true,nullable = false)
    Integer number;
    @Column(nullable = false)
    String endDate;
    @Column(nullable = false)
    Integer cvv;
    @ManyToOne
    @JoinColumn(nullable = false)
    Accounts account;

}
