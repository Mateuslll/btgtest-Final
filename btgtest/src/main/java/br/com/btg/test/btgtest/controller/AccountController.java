package br.com.btg.test.btgtest.controller;


import br.com.btg.test.btgtest.model.Account;
import br.com.btg.test.btgtest.model.RequestAccount;
import br.com.btg.test.btgtest.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @GetMapping("/accounts")
    public ResponseEntity getAllAccounts() {
        var AllAccounts = repository.findAll();
        return ResponseEntity.ok(AllAccounts);
    }

    @PostMapping("/register")
    public ResponseEntity registerAccount(@RequestBody @Valid RequestAccount data) {
        Account newAccount = new Account(data);
        repository.save(newAccount);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/account/{accountId}")
    public ResponseEntity updateAccount(@RequestBody @Valid RequestAccount data) {
        Account account = repository.getReferenceById(data.id());
        account.setMoneyValue(data.moneyValue());
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{accountId}") //Consulta de conta pelo ID
    public ResponseEntity<Account> searchById(@PathVariable int accountId, @RequestBody @Valid RequestAccount data) {
        Optional<Account> optionalAccount = repository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setMoneyValue(data.moneyValue());
            Account updatedAccount = repository.save(account);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
