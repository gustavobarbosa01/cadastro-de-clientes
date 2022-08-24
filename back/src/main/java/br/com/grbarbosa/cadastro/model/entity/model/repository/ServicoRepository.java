package br.com.grbarbosa.cadastro.model.entity.model.repository;

import br.com.grbarbosa.cadastro.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
