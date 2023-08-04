CREATE TABLE Account (
    idAccount BINARY(16) PRIMARY KEY,
   -- idClient BINARY(16) NOT NULL,
    agency INT NOT NULL,
    accountNumber INT NOT NULL,
    DAC INT NOT NULL,
    typeAccount VARCHAR(255) NOT NULL,
    moneyValue DECIMAL(18, 2) NOT NULL,

    idTypeAccount INT NOT NULL, -- CHAVE ESTRANGEIRA
    idClient BINARY(16) NOT NULL,

    Foreign key (idTypeAccount) REFERENCES typeAccount (idType),
    Foreign key (idClient) REFERENCES Client (id)
);