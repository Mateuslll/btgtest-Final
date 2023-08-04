package br.com.btg.test.btgtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "BankTransaction")
@Table(name = "BankTransaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true)
    private int id;

    @Column(name = "valueEntry" , unique = true , updatable = false)
    private BigDecimal valueEntry;

    @Column(name = "typeOperation" , unique = true)
    private Integer typeOperation;

    @Column(name = "numberAccount" , unique = true , updatable = false)
    private Integer numberAccount;

    public BankTransaction(RequestBankTransaction requestBankTransaction) {
        this.valueEntry = requestBankTransaction.valueEntry();
        this.typeOperation = requestBankTransaction.typeOperation();
        this.numberAccount = requestBankTransaction.numberAccount();
    }

}
