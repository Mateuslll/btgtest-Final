package br.com.btg.test.btgtest.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Client")
@Table(name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true, updatable = false)
    private int id;

    @Column(name = "name" , unique = true)
    private String name;

    @Column(name = "CPF" , unique = true , updatable = false)
    private String cpf;

    public Client (RequestClient requestClient){
        this.name = requestClient.name();
        this.cpf = requestClient.CPF();
    }
}
