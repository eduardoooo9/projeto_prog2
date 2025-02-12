package br.ifpe.jaboatao.LOJA_MOVEIS.service;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Movel;
import br.ifpe.jaboatao.LOJA_MOVEIS.repository.MovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovelService {

    @Autowired
    private MovelRepository movelRepository;

    public List<Movel> listarMoveis() {
        return movelRepository.findAll();
    }

    public Movel salvarMovel(Movel movel) {
        return movelRepository.save(movel);
    }

    public Movel buscarPorId(Long id) {
        Optional<Movel> movel = movelRepository.findById(id);
        return movel.orElse(null);
    }

    public Movel atualizarMovel(Movel movel) {
        return movelRepository.save(movel);
    }

    public void deletarMovel(Long id) {
        movelRepository.deleteById(id);
    }
}
