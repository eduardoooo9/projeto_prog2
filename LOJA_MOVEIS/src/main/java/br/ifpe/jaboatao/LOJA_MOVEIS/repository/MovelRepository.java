package br.ifpe.jaboatao.LOJA_MOVEIS.repository;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Movel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovelRepository extends JpaRepository<Movel, Long> {

}
