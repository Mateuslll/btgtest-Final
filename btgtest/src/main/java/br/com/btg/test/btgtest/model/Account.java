package br.com.btg.test.btgtest.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Account")
@Table(name = "Account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") // Lombok
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "agency" , unique = true)
    private int agency;

    @Column(name = "number" , unique = true)
    private long number;

    @Column(name = "moneyValue" , unique = true)
    private BigDecimal moneyValue;

    @Column(name = "CPFClient" , unique = true , updatable = false)
    private String CPFClient;


    public Account (RequestAccount requestAccount){
        this.id = requestAccount.id();
        this.agency = (int) requestAccount.agency();
        this.number = (int) requestAccount.number();
        this.moneyValue = requestAccount.moneyValue();
        this.CPFClient = requestAccount.CPFClient();
    }

}
