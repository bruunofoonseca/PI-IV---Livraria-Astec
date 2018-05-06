/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemPedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl.ProdutoServiceJpaImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno Fonseca
 * edit diogo.Sfelix
 */
@Controller
@RequestMapping("/carrinho")
@Scope("session")
public class CarrinhoController implements Serializable {

    @Autowired
    private ProdutoService service;

    public List<ItemPedidoModel> itens = new ArrayList<>();

    @GetMapping
    public ModelAndView mostrarCarrinho() {
      return new ModelAndView("Carrinho");
    }

    @PostMapping
    public ModelAndView adicionarProduto(@ModelAttribute("numero") Long id, 
            RedirectAttributes redirectAttributes) {
      ProdutoModel p = service.obter(id);
      ItemPedidoModel item = new ItemPedidoModel();
      item.setProduto(p);
      item.setQtd(1);
      item.setValorParcial(p.getValorProduto());
      
      this.itens.add(item);
      
      // POST-REDIRECT-GET
      return new ModelAndView("redirect:/carrinho");
    }
    
    @PostMapping("/validandoPedido")
    public ModelAndView validandoPedido(
            //@ModelAttribute("numero") Long id,
            //@ModelAttribute("qtd") int qtd,
            RedirectAttributes redirectAttributes
    ){
        //System.out.println("Id" + id);
        //System.out.println("qtd" + qtd);
        
        System.out.println("Passei pelo validador");
        return new ModelAndView("redirect:/cadastroCliente");
    }
}