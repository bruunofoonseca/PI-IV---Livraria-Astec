/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bruno.almeida
 */
@Controller
@RequestMapping("/menu")
public class MenuItensController {

    @GetMapping("/meusDados")
    public ModelAndView meusDados() {
        UsuarioModel user = new UsuarioModel();

        return new ModelAndView("meusDados").addObject("user", user);
    }

    @GetMapping("/meusEnderecos")
    public ModelAndView meusEnderecos() {
        return new ModelAndView("meusEnderecos");
    }
    
    @GetMapping("/meusPedidos")
    public ModelAndView meusPedidos() {
        return new ModelAndView("meusPedidos");
    }
}