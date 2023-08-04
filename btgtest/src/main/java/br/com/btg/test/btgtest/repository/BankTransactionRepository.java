package br.com.btg.test.btgtest.repository;

import br.com.btg.test.btgtest.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankTransactionRepository extends JpaRepository <BankTransaction , Integer> {
    List<BankTransaction> findByNumberAccount(Integer numberAccount);
}
