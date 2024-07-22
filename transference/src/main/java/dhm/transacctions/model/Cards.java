package dhm.transacctions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    Integer id;
    String bank;
    Integer number;
    String endDate;
    Integer cvv;
    Accounts account;

}
