/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemIds;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemPedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoTemp;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl.ProdutoServiceJpaImpl;
import java.io.Serializable;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno Fonseca
 * edit diogo.Sfelix
 */
@Controller
@RequestMapping("/Carrinho")
@Scope("session")
public class CarrinhoController implements Serializable {
  
    @Autowired
    private ProdutoService service;

    public List<ItemPedidoModel> itens = new ArrayList<>();

    @GetMapping
    public ModelAndView mostrarCarrinho() {
        List<ItemIds> temp = new ArrayList<>();
        for (ItemPedidoModel item : itens) {
            ItemIds i = new ItemIds();
            i.setIdProduto(item.getProduto().getId());
            i.setQtd(item.getQtd());
            temp.add(i);
        }
        PedidoTemp ptemp = new PedidoTemp();
        ptemp.setItems(temp);
        return new ModelAndView("Carrinho").addObject("ptemp", ptemp);
    }

    @PostMapping
    public ModelAndView adicionarProduto(@ModelAttribute("numero") Long id, 
            RedirectAttributes redirectAttributes) {
       /* 
      ProdutoModel p = service.obter(id);
      
      ItemPedidoModel item = new ItemPedidoModel();
      item.setProduto(p);
      item.setQtd(1);
      item.setValorParcial(p.getValorProduto());
      
      this.itens.add(item);
      */
        
        ProdutoModel p = service.obter(id);
      
        ItemPedidoModel item = new ItemPedidoModel();
        
        if(!itens.isEmpty()) {
//            List<ItemPedidoModel> aux = itens;
            boolean adicionou = false;
            for (ItemPedidoModel i : itens){
                if(i.getProduto().getId() == id){
                    i.setQtd(i.getQtd()+1);
                    i.setValorParcial(i.getProduto().getValorProduto().multiply(BigDecimal.valueOf(i.getQtd())));
                    adicionou = true;
                    break;
                }
            }
            
            if(!adicionou) {
                item.setProduto(p);
                item.setQtd(1);
                item.setValorParcial(p.getValorProduto());

                this.itens.add(item);
            }
        } else {
            item.setProduto(p);
            item.setQtd(1);
            item.setValorParcial(p.getValorProduto());
                
            this.itens.add(item);
        }

        // POST-REDIRECT-GET
        return new ModelAndView("redirect:/Carrinho");
    }
      
    @PostMapping("/validandoPedido")
    public ModelAndView teste(
            @ModelAttribute("ptemp") PedidoTemp ptemp,
            RedirectAttributes redirectAttributes
    ){
        
        for(ItemPedidoModel i : itens){
            for(ItemIds w : ptemp.getItems()){
                if(i.getProduto().getId() == w.getIdProduto()){
                    i.setQtd(w.getQtd());
                    i.setValorParcial(i.getProduto().getValorProduto().multiply(BigDecimal.valueOf(w.getQtd())));
                }
            }
        }
        
        return new ModelAndView("redirect:/login");
    }
}