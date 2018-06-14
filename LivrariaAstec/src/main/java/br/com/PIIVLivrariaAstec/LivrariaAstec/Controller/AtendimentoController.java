/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bruno.flima4
 */
@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {
    
     @GetMapping("/entreContato")
    public ModelAndView entreContato() {
        return new ModelAndView("entreContato");
    }
     @GetMapping("/politica")
    public ModelAndView politica() {
        return new ModelAndView("politica");
    }
    @GetMapping("/faq")
    public ModelAndView faq() {
        return new ModelAndView("faq");
    }
    
}
