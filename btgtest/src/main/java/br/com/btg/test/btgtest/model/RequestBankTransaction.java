package br.com.btg.test.btgtest.model;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestBankTransaction(@NotNull BigDecimal valueEntry,@NotNull Integer typeOperation, @NotNull Integer numberAccount) {
}
