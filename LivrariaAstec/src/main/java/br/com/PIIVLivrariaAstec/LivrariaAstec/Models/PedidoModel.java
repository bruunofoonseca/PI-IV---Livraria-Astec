/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

/**
 *
 * @author Bruno Fonseca
 */
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private ClienteModel cliente;

    @OneToMany(mappedBy = "pedido")
    private Set<ItemPedidoModel> itens;

    @Digits(integer = 6, fraction = 2)
    @Column(name = "VALOR_TOTAL", precision = 6, scale = 2, nullable = false)
    private float valorTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_VENDA", nullable = false)
    private Date dataVenda;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public ClienteModel getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(ClienteModel cliente) {
//        this.cliente = cliente;
//    }

    public Set<ItemPedidoModel> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedidoModel> itens) {
        this.itens = itens;
    }

    public void setItem(ItemPedidoModel item) {
        this.itens.add(item);
    }
}