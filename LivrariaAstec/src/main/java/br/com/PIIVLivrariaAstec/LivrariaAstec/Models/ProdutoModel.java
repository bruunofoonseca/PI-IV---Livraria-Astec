/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno Fonseca
 * edit Diogo.Felix
 */
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {
    // Atributos
    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "Nome inválido")
    @Column(name = "NOME_PRODUTO", length = 100, nullable = false)
    private String nome;
    
    @Size(min = 1, max = 100, message = "Fabricante inválido")
    @Column(name = "FABRICANTE_PRODUTO", length = 100, nullable = false)
    private String fabricante;

    @Digits(integer = 6, fraction = 0)
    @Column(name = "QUANTIDADE_PRODUTO", precision = 6, nullable = false)
    private int qtdProduto;

    @Digits(integer = 6, fraction = 2)
    @Column(name = "VALOR_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal valorProduto;
    
    @Column(name = "STATUS_PRODUTO", nullable = false)
    private boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_FABRICACAO", nullable = false)
    private Date dtFabricacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CADASTRO", nullable = false)
    private Date dtCadastro;

    @Size(min = 1, max = 1000)
    @Column(name = "DESCRICAO_PRODUTO", length = 1000)
    private String descricao;
    
    @Digits(integer = 6, fraction = 2)
    @Column(name = "PESO_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal peso;
    
    @Digits(integer = 6, fraction = 2)
    @Column(name = "ALTURA_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal altura;
    
    @Digits(integer = 6, fraction = 2)
    @Column(name = "LARGURA_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal largura;
    
    @Digits(integer = 6, fraction = 2)
    @Column(name = "PROFUNDIDADE_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal profundidade;
    
    @Digits(integer = 6, fraction = 0)
    @Column(name = "NUMPAGES_PRODUTO", precision = 6, nullable = false)
    private int numPaginas;
    
    @Size(min = 1, max = 100, message = "Idioma inválido")
    @Column(name = "IDIOMA_PRODUTO", length = 100, nullable = false)
    private String idioma;
    
    @Size(min = 1, max = 100, message = "Acabamento inválido")
    @Column(name = "ACABAMENTO_PRODUTO", length = 100, nullable = false)
    private String acabamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SUBCATEGORIA")
    private SubCategoriaModel subCategoria;
      
    @OneToMany(mappedBy = "produto")
    private Set<ImagemProduto> imagens;
    
    @OneToOne(mappedBy = "produto")
    private ItemPedidoModel item;

    // Constructor
    public ProdutoModel(){
    
    }

    public ProdutoModel(
            Long id,
            String nome, 
            String fabricante,
            int qtdProduto, 
            BigDecimal valorProduto, 
            boolean status, 
            Date dtFabricacao, 
            String descricao, 
            BigDecimal peso, 
            BigDecimal altura, 
            BigDecimal largura, 
            BigDecimal profundidade, 
            int numPaginas, 
            String idioma, 
            String acabamento, 
            SubCategoriaModel subCategoria, 
            Set<ImagemProduto> imagens
        ) {

        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
        this.status = status;
        this.dtFabricacao = dtFabricacao;
        this.descricao = descricao;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.acabamento = acabamento;
        this.subCategoria = subCategoria;
        this.imagens = imagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDtFabricacao() {
        return dtFabricacao;
    }

    public void setDtFabricacao(Date dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public SubCategoriaModel getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoriaModel subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Set<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(Set<ImagemProduto> imagens) {
        this.imagens = imagens;
    }
    
    @Override
    public String toString() {
      return "ProdutoModel(" +
                "id=" + id +
                ", nome=" + nome +
                ", fabricante=" + fabricante +
                ", qtdProduto=" + qtdProduto +
                ", valorProduto=" + valorProduto +
                ", status=" + status +
                ", dtFabricacao=" + dtFabricacao +
                ", descricao=" + descricao +
                ", peso=" + peso +
                ", altura=" + altura +
                ", largura=" + largura +
                ", profundidade=" + profundidade +
                ", numPaginas=" + numPaginas +
                ", idioma=" + idioma +
                ", acabamento=" + acabamento +
                ", subCategoria=" + subCategoria +
                ", imagens=" + imagens + ")";
    }
}