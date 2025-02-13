package br.ifpe.jaboatao.LOJA_MOVEIS.service;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Material;
import br.ifpe.jaboatao.LOJA_MOVEIS.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Optional<Material> findById(Long id) {
        return materialRepository.findById(id);
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}
