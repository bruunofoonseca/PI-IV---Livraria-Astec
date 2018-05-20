/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author diogo.Sfelix
 */
@Controller
@RequestMapping("/gerenciamento")
public class GerenciamentoVendaController {
    
    @Autowired
    private PedidoService servicePedido;
    
    @GetMapping()
    public ModelAndView listarVenda(){
        
        List<PedidoModel> lista  = servicePedido.listar();
        
        return new ModelAndView("vendasRealizadas").addObject("vendas", lista);
    }
    
    @GetMapping("/addProduto")
    public ModelAndView cadastrarProduto(){
        ProdutoModel produto = new ProdutoModel();
        
        return new ModelAndView("cadastroProduto").addObject("produto",produto);
    }
            
    @PostMapping("/addProduto/gravar")
    public ModelAndView gravarProduto(
    @Valid @ModelAttribute("produto") ProdutoModel produto,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/addProduto");
        }
        
        return new ModelAndView("/");
    }
    
}
