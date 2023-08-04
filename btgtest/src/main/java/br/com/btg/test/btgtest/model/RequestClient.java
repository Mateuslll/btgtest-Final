package br.com.btg.test.btgtest.model;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
import java.util.Date;

import java.time.LocalDateTime;
public record RequestClient(@NotBlank  String name, @NotBlank  String CPF) {

}

