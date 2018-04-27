/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl.ProdutoServiceJpaImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/carrinho")
@Scope("session")
public class CarrinhoController implements Serializable {

    private ProdutoService service = new ProdutoServiceJpaImpl();

    private List<ProdutoModel> produtosAdicionados = new ArrayList<ProdutoModel>();

    public List<ProdutoModel> getProdutosAdicionados() {
      return produtosAdicionados;
    }

    @GetMapping
    public ModelAndView mostrarCarrinho() {
      return new ModelAndView("Carrinho");
    }

    @PostMapping("/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long id, 
            RedirectAttributes redirectAttributes) {
      ProdutoModel p = service.obter(id);
      produtosAdicionados.add(p);

      // POST-REDIRECT-GET
      //redirectAttributes.addAttribute("prod", p);
      return new ModelAndView("redirect:/carrinho");
    }
}