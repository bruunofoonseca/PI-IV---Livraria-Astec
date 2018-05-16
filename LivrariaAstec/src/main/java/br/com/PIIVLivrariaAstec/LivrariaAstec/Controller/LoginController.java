/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bruno.flima4
 */
@Controller
@RequestMapping("/login")
@Scope("session")
public class LoginController {
    
    public UsuarioModel user = new UsuarioModel();
    
    @GetMapping
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
