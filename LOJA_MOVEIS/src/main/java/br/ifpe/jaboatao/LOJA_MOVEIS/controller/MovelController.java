import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.ifpe.jaboatao.LOJA_MOVEIS.model.Movel;
import br.ifpe.jaboatao.LOJA_MOVEIS.repository.MovelRepository;

import java.util.List;

@Controller
@RequestMapping("/moveis")
public class MovelController {

    @Autowired
    private MovelRepository movelRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Movel> moveis = movelRepository.findAll();
        model.addAttribute("moveis", moveis);
        return "home";
    }

    @GetMapping
    public String listarTodos(Model model) {
        List<Movel> moveis = movelRepository.findAll();
        model.addAttribute("moveis", moveis);
        return "moveis";
    }

    @GetMapping("/novo")
    public String novoMovel(Model model) {
        model.addAttribute("movel", new Movel());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvarMovel(@Valid Movel movel, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        movelRepository.save(movel);
        return "redirect:/moveis";
    }

    @GetMapping("/editar/{id}")
    public String editarMovel(@PathVariable Long id, Model model) {
        Movel movel = movelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movel inválido:" + id));
        model.addAttribute("movel", movel);
        return "update";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarMovel(@PathVariable Long id, @Valid Movel movel, BindingResult result) {
        if (result.hasErrors()) {
            return "update";
        }
        movel.setId(id);
        movelRepository.save(movel);
        return "redirect:/moveis";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMovel(@PathVariable Long id) {
        Movel movel = movelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movel inválido:" + id));
        movelRepository.delete(movel);
        return "redirect:/moveis";
    }
}
