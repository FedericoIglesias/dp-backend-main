package dhm.transference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {


        Integer id;
        Float amount;
        List<Cards> listCards;
        List<Transference> listTransactions;

    }