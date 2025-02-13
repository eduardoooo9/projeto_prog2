package br.ifpe.jaboatao.LOJA_MOVEIS.controller;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Material;
import br.ifpe.jaboatao.LOJA_MOVEIS.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/materiais")
    public String listarMateriais(Model model) {
        model.addAttribute("materiais", materialService.findAll());
        return "materiais";  // Exibe a lista de materiais
    }

    @GetMapping("/cadastro-material")
    public String showFormCadastroMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "cadastro-material";  // Página para cadastrar novo material
    }

    @PostMapping("/cadastro-material")
    public String cadastrarMaterial(@ModelAttribute Material material) {
        materialService.save(material);
        return "redirect:/materiais";  // Redireciona para a lista de materiais
    }

    @GetMapping("/editar-material/{id}")
    public String editarMaterial(@PathVariable Long id, Model model) {
        Material material = materialService.findById(id).orElseThrow(() -> new IllegalArgumentException("Material inválido: " + id));
        model.addAttribute("material", material);
        return "editar-material";  // Página para editar material
    }

    @PostMapping("/editar-material/{id}")
    public String atualizarMaterial(@PathVariable Long id, @ModelAttribute Material material) {
        material.setId(id);
        materialService.save(material);
        return "redirect:/materiais";  // Redireciona para a lista de materiais após a atualização
    }

    @GetMapping("/excluir-material/{id}")
    public String excluirMaterial(@PathVariable Long id) {
        materialService.deleteById(id);
        return "redirect:/materiais";  // Redireciona para a lista de materiais após a exclusão
    }
}
