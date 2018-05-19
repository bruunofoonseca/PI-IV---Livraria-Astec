/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.EnderecoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bruno.flima4
 */
@Controller
@RequestMapping("/cadastroCliente")
public class ClienteController {
    
    @GetMapping
    public ModelAndView cadastroCliente(){
        UsuarioModel cliente = new UsuarioModel();
        return new ModelAndView("cadastroCliente").addObject("cliente", cliente);
    }

    @PostMapping("/cadastrarCliente")
    public ModelAndView validaEndereco(@ModelAttribute("cliente") UsuarioModel cliente,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {
        
        
        
        return new ModelAndView("redirect:/");
    }
}