package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
            
    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView mostrarTela(){
        System.out.println("Get Sessao");
        return new ModelAndView("Carrinho");
    }
    
    @PostMapping
    public ModelAndView addProdutosCarrinho(
            @ModelAttribute("numero") Integer numero){
        
        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
        
        ProdutoModel p = service.obter(numero);
        
        produtos.add(p);
        System.out.println("-----");
        System.out.println(produtos.toString());
        
        return new ModelAndView("Carrinho").addObject("prod", produtos);
    }
    
    public List<Integer> getNumerosDigitados() {
        return numerosDigitados;
    }
    
}
