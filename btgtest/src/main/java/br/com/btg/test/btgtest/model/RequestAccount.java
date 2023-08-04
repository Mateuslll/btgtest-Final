package br.com.btg.test.btgtest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public record RequestAccount(int id, @NotNull Integer agency,@NotNull Integer number,@NotNull BigDecimal moneyValue, @NotBlank  String CPFClient) {

}
