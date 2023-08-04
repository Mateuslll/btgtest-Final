package br.com.btg.test.btgtest.repository;

import br.com.btg.test.btgtest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}