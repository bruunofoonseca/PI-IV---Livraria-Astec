package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author diogo.Sfelix
 */
@Controller
@RequestMapping("/sessao")
@Scope("session")
public class SessaoController implements Serializable{
    
    private List<Integer> numerosDigitados = new ArrayList<>();
            
    
    @GetMapping
    public ModelAndView mostrarTela(){
        System.out.println("Get Sessao");
        numerosDigitados.add(23);
        numerosDigitados.add(25);
        System.out.println(numerosDigitados.isEmpty());
        return new ModelAndView("Carrinho");
    }
    
    @PostMapping
    public ModelAndView addProdutosCarrinho(
            @ModelAttribute("numero") Integer numero){
        System.out.println("Post Sessao");
        numerosDigitados.add(numero);
        return new ModelAndView("Carrinho");
    }
    
    public List<Integer> getNumerosDigitados() {
        return numerosDigitados;
    }
    
}
