package dhm.profile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    Integer id;
    String bank;
    String number;
    @ManyToOne
    Users users;

}
