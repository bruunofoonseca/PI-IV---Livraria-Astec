/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@RequestMapping("/login")
@Scope("session")
public class LoginController {

    public UsuarioModel user = new UsuarioModel();
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ModelAndView login(){
        UsuarioModel user = new UsuarioModel();
        return new ModelAndView("login").addObject("user", user);
    }

    @PostMapping
    public ModelAndView doLogin(@Valid @ModelAttribute("user") UsuarioModel user,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {
        
        this.user = usuarioService.obter(user.getEmail(), user.getSenha());

        return new ModelAndView("login");
    }
}