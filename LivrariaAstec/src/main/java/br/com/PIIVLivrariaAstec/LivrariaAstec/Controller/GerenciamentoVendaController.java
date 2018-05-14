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
import java.util.List;
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
}
