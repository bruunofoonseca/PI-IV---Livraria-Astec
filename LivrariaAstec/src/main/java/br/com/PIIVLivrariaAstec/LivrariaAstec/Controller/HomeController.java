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
 * @author bruno.falmeida
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public ModelAndView home() {
        ModelAndView resposta = new ModelAndView();
        
        return resposta;
    }
}