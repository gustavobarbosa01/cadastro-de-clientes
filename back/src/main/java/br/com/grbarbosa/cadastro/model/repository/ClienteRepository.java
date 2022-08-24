package br.com.grbarbosa.cadastro.model.repository;

import br.com.grbarbosa.cadastro.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
