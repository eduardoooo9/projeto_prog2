package br.ifpe.jaboatao.LOJA_MOVEIS.dao;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Movel;

import java.util.List;

public interface MovelDAO {
    List<Movel> getAllMoveis();
    Movel getMovelById(Long id);
    void saveMovel(Movel movel);
    void deleteMovel(Long id);
}
