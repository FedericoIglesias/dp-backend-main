package dmh.registerService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity @Setter @Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String dni;
    @Column(nullable = false,unique = true)
    private String email;
    private Integer phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private BigInteger cvu;
    @Column(nullable = false,unique = true)
    private String alias;


    public Users() {
    }

    public Users(String name, String password){
        this.name = name;
        this.password = password;
    }
    public Users(Integer id, String name, String lastName, String dni, String email, Integer phone, String password, BigInteger cvu, String alias) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.cvu = cvu;
        this.alias = alias;
    }

}
