package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author diogo.Sfelix
 */
@Controller
@RequestMapping("/sessao")
@Scope("session")
public class SessaoController implements Serializable{
    
    @GetMapping
    public ModelAndView mostrarTela(){
        return new ModelAndView("carrinho");
    }
    
}
