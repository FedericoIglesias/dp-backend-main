package dhm.card.dto;

import dhm.card.model.Accounts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCardResponse {
    String bank;
    Integer number;
    String endDate;
    Integer cvv;
    Integer idAccount;
}
