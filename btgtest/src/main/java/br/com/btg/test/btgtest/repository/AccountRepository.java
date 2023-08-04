package br.com.btg.test.btgtest.repository;

import br.com.btg.test.btgtest.model.Account;
import br.com.btg.test.btgtest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.btg.test.btgtest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    //Aqui vamos com a lógica de négocios

}