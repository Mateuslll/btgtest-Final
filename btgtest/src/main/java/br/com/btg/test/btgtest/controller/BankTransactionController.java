package br.com.btg.test.btgtest.controller;
import br.com.btg.test.btgtest.model.BankTransaction;
import br.com.btg.test.btgtest.model.Client;
import br.com.btg.test.btgtest.model.RequestBankTransaction;
import br.com.btg.test.btgtest.model.RequestClient;
import br.com.btg.test.btgtest.repository.BankTransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banktransaction")
public class BankTransactionController {
    @Autowired
    private BankTransactionRepository repository;

    @GetMapping("/transactions")
    public ResponseEntity getAllTransactions(){
        var allTransactions = repository.findAll();
        return ResponseEntity.ok(allTransactions);
    }
    @PostMapping("/register")
    public ResponseEntity registerTransaction (@RequestBody @Valid RequestBankTransaction data){ //registra transação
        BankTransaction newBankTransaction = new BankTransaction (data);
        repository.save(newBankTransaction);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{numberAccount}") // Consulta p/ movimentações de uma conta
    public ResponseEntity<List<BankTransaction>> getTransactionsByAccount(@PathVariable Integer numberAccount) {
        List<BankTransaction> transactions = repository.findByNumberAccount(numberAccount);

        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transactions);
    }
}
