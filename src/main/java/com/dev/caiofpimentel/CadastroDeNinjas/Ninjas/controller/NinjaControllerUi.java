package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.controller;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    @Autowired
    NinjaService ninjaService;

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);

        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id){

       ninjaService.deletarNinja(id);
       return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjaPorId(@PathVariable Long id, Model model) {
        Optional<NinjaDTO> ninja = ninjaService.listarNinjaPorId(id);
        if (ninja.isPresent()) {
            model.addAttribute("ninja", ninja.get()); // ✅ Agora funciona no Thymeleaf
            return "detalhesNinjas";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }


    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizarNinja(@PathVariable Long id, Model model) {
        Optional<NinjaDTO> ninjaOpt = ninjaService.listarNinjaPorId(id);
        if (ninjaOpt.isPresent()) {
            model.addAttribute("ninja", ninjaOpt.get());
            return "atualizarNinja"; // nome da sua página HTML para editar ninja
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado.");
            return "listarNinjas";
        }
    }






}
