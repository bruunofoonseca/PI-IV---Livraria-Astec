/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.EnderecoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.UsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
/**
 *
 * @author bruno.flima4
 */
@Controller
@RequestMapping("/cadastroCliente")
public class ClienteController implements Serializable{
    
    @Autowired
    private UsuarioService usuario;
    
    @GetMapping
    public ModelAndView cadastroCliente(){
        UsuarioModel cliente = new UsuarioModel();
        return new ModelAndView("cadastroCliente").addObject("cliente", cliente);
    }

    @PostMapping("/cadastrarCliente")
    public ModelAndView validaEndereco(@Valid @ModelAttribute("cliente") UsuarioModel cliente,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {
        
        UsuarioModel user = new UsuarioModel();
        user = cliente;
        usuario.inserir(user);
        
        return new ModelAndView("redirect:/");
    }
}