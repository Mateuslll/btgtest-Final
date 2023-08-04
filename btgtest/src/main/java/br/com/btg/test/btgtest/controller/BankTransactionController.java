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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{transactionId}")
    public ResponseEntity updateTransactionValueEntry(@PathVariable int transactionId, @RequestBody RequestBankTransaction request) {
        Optional<BankTransaction> optionalTransaction = repository.findById(transactionId);

        if (optionalTransaction.isPresent()) {
            BankTransaction transaction = optionalTransaction.get();
            // Atualizar valor do valueEntry, typeOperation e numberAccount
            transaction.setValueEntry(request.valueEntry());
            transaction.setTypeOperation(request.typeOperation());
            transaction.setNumberAccount(request.numberAccount());
            repository.save(transaction);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
