/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno Fonseca
 */
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel implements Serializable {

    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private UsuarioModel cliente;

    @OneToMany(mappedBy = "pedido")
    private Set<ItemPedidoModel> itens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENDERECO")
    private EnderecoModel enderecoEntrega;

    @Digits(integer = 6, fraction = 20)
    @Column(name = "VALOR_TOTAL", precision = 6, scale = 2, nullable = false)
    private float valorTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_VENDA", nullable = false)
    private Date dataVenda;

    @Size(min = 1, max = 100, message = "Forma de pagamento inválida")
    @Column(name = "FORMA_DE_PAGAMENTO", length = 100, nullable = false)
    private String formaDePagamento;

    @Size(min = 0, max = 100, message = "Bandeira do cartão inválido")
    @Column(name = "BANDEIRA_CARTAO", length = 100, nullable = true)
    private String bandeiraCartao;

    @Size(min = 0, max = 100, message = "Número de cartão inválido")
    @Column(name = "NUMERO_CARTAO", length = 100, nullable = true)
    private String numeroCartao;

    @Size(min = 0, max = 100, message = "Data de Vencimento inválida")
    @Column(name = "DATA_VENCIMENTO_CARTAO", nullable = true)
    private String dataVencimento;

    @Size(min = 1, max = 100, message = "Nome no cartão inválido")
    @Column(name = "NOME_CARTAO", length = 100, nullable = true)
    private String nomeNoCartao;

    @Digits(integer = 3, fraction = 0)
    @Column(name = "CVV_CARTAO", precision = 3, nullable = true)
    private int CVV;

    @Size(min = 1, max = 100, message = "status inválido")
    @Column(name = "CPF_TITULAR_CARTAO", length = 100, nullable = true)
    private String CPFTitular;

    @Size(min = 1, max = 100, message = "status inválido")
    @Column(name = "STATUS_PEDIDO", length = 100, nullable = true)
    private String statusPedido;

    public String getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public String getCPFTitular() {
        return CPFTitular;
    }

    public void setCPFTitular(String CPFTitular) {
        this.CPFTitular = CPFTitular;
    }

    public EnderecoModel getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoModel enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public PedidoModel() {
        this.itens = new LinkedHashSet<>();
    }

    public PedidoModel(Integer id, UsuarioModel cliente,
            Set<ItemPedidoModel> itens,
            EnderecoModel enderecoEntrega,
            float valorTotal, Date dataVenda,
            String formaDePagamento,
            String numeroCartao,
            String dataVencimento,
            String nomeNoCartao,
            int CVV,
            String statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.enderecoEntrega = enderecoEntrega;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.formaDePagamento = formaDePagamento;
        this.numeroCartao = numeroCartao;
        this.dataVencimento = dataVencimento;
        this.nomeNoCartao = nomeNoCartao;
        this.CVV = CVV;
        this.statusPedido = statusPedido;
    }

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

    public Set<ItemPedidoModel> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedidoModel> itens) {
        this.itens = itens;
    }

    public void setItem(ItemPedidoModel item) {
        this.itens.add(item);
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }
}