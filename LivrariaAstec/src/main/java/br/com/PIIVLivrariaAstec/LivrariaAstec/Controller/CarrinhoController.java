/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.EnderecoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemIds;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemPedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoTemp;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.PedidoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.UsuarioService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno Fonseca edit diogo.Sfelix
 */
@Controller
@RequestMapping("/Carrinho")
@Scope("session")
public class CarrinhoController implements Serializable {

    @Autowired
    private ProdutoService service;
    
    @Autowired
    private PedidoService servicePedido;
    
    @Autowired
    private UsuarioService serviceUsuario;

    public PedidoModel pedido = new PedidoModel();

    @GetMapping
    public ModelAndView mostrarCarrinho() {
        List<ItemIds> temp = new ArrayList<>();
        if(!pedido.getItens().isEmpty()) {
            for (ItemPedidoModel item : pedido.getItens()) {
                ItemIds i = new ItemIds();
                i.setIdProduto(item.getProduto().getId());
                i.setQtd(item.getQtd());
                temp.add(i);
            }
        }
        
        List<UsuarioModel> usuarios = serviceUsuario.listar();
        pedido.setCliente(usuarios.get(0));

        PedidoTemp ptemp = new PedidoTemp();
        ptemp.setItems(temp);
        return new ModelAndView("Carrinho").addObject("ptemp", ptemp);
    }

    @PostMapping
    public ModelAndView adicionarProduto(@ModelAttribute("numero") Long id,
            RedirectAttributes redirectAttributes) {
        ProdutoModel p = service.obter(id);

        ItemPedidoModel item = new ItemPedidoModel();

        if (!pedido.getItens().isEmpty()) {
            boolean adicionou = false;
            for (ItemPedidoModel i : pedido.getItens()) {
                if (i.getProduto().getId() == id) {
                    i.setQtd(i.getQtd() + 1);
                    i.setValorParcial(i.getProduto().getValorProduto().multiply(BigDecimal.valueOf(i.getQtd())));
                    adicionou = true;
                    break;
                }
            }

            if (!adicionou) {
                item.setProduto(p);
                item.setQtd(1);
                item.setValorParcial(p.getValorProduto());
                item.setPedido(pedido);

                this.pedido.setItem(item);
            }
        } else {
            item.setProduto(p);
            item.setQtd(1);
            item.setValorParcial(p.getValorProduto());
            item.setPedido(pedido);

            this.pedido.setItem(item);
        }

        atualizaValorTotal();

        // POST-REDIRECT-GET
        return new ModelAndView("redirect:/Carrinho");
    }

    @PostMapping("/validandoPedido")
    public ModelAndView teste(
            @ModelAttribute("ptemp") PedidoTemp ptemp,
            RedirectAttributes redirectAttributes) {

        for (ItemPedidoModel i : pedido.getItens()) {
            for (ItemIds w : ptemp.getItems()) {
                if (i.getProduto().getId() == w.getIdProduto()) {
                    i.setQtd(w.getQtd());
                    i.setValorParcial(i.getProduto().getValorProduto().multiply(BigDecimal.valueOf(w.getQtd())));
                }
            }
        }

        pedido.setDataVenda(new Date());

        return new ModelAndView("redirect:/Carrinho/entrega");
    }
    
    @GetMapping("/{id}")
    public ModelAndView Remove(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {

        for (ItemPedidoModel i : pedido.getItens()) {
                if (i.getProduto().getId() == id) {
                    pedido.getItens().remove(i);
                    break;
                }
        }

        atualizaValorTotal();

        return new ModelAndView("redirect:/Carrinho");
    }

    @GetMapping("/entrega")
    public ModelAndView endereco() {
        EnderecoModel endereco = new EnderecoModel();
        return new ModelAndView("entrega").addObject("endereco", endereco);
    }
    
    @PostMapping("/validaEntrega")
    public ModelAndView validaEndereco(@ModelAttribute("endereco") EnderecoModel end,
	  BindingResult bindingResult,
	  RedirectAttributes redirectAttributes) {
        
        pedido.setEnderecoEntrega(end);
        end.setPedido(pedido);
        
        return new ModelAndView("redirect:/Carrinho/pagamento");
    }
    
    @GetMapping("/pagamento")
    public ModelAndView pagamento() {
        PedidoModel ped = new PedidoModel();
        return new ModelAndView("PagamentoTsuda").addObject("ped", ped);
    }
    
    @PostMapping("/validaPagamento")
    public ModelAndView validaPagamento(@ModelAttribute("ped") PedidoModel ped,
	  BindingResult bindingResult,
	  RedirectAttributes redirectAttributes) {

        if(ped.getBandeiraCartao().equals("")){
            this.pedido.setFormaDePagamento("Boleto");
        } else {
            this.pedido.setFormaDePagamento("Cartão");
            this.pedido.setBandeiraCartao(ped.getBandeiraCartao());
            this.pedido.setNumeroCartao(ped.getNumeroCartao());
            this.pedido.setNomeNoCartao(ped.getNomeNoCartao());
            this.pedido.setDataVencimento(ped.getDataVencimento());
            this.pedido.setCVV(ped.getCVV());
            this.pedido.setCPFTitular(ped.getCPFTitular());
        }

        servicePedido.inserir(pedido);
        
        int aux = pedido.getId();
        
        this.pedido = new PedidoModel();

        return new ModelAndView("confirmacaoCompra").addObject("idPedido", aux);
    }

    public void atualizaValorTotal() {
        float aux = 0;
        for(ItemPedidoModel i : this.pedido.getItens()) {
            aux += i.getValorParcial().floatValue();
        }

        this.pedido.setValorTotal(aux);
    }
}