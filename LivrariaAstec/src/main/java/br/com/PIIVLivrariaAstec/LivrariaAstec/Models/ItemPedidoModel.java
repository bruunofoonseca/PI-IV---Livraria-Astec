/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

/**
 *
 * @author Bruno Fonseca
 */
@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedidoModel implements Serializable {
    // Atributos
    @Id
    @Column(name = "ID_ITEM_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTO")
    private ProdutoModel produto;

    @Digits(integer = 6, fraction = 2)
    @Column(name = "VALOR_PARCIAL", precision = 6, scale = 2, nullable = false)
    private BigDecimal valorParcial;
    
    @Digits(integer = 6, fraction = 0)
    @Column(name = "QUANTIDADE", precision = 6, nullable = false)
    private int qtd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO")
    private PedidoModel pedido;

    public ItemPedidoModel() {

    }

    public ItemPedidoModel(Long id, ProdutoModel produto, BigDecimal valorParcial, int qtd, PedidoModel pedido) {
        this.id = id;
        this.produto = produto;
        this.valorParcial = valorParcial;
        this.qtd = qtd;
        this.pedido = pedido;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public BigDecimal getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(BigDecimal valorParcial) {
        this.valorParcial = valorParcial;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}