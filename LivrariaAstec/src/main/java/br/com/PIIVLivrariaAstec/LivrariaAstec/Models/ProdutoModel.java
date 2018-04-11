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

/**
 *
 * @author Bruno Fonseca
 * edit Diogo.Felix
 */
public class ProdutoModel implements Serializable {
     // Atributos
    private Long id;
    private String nome;
    private String fabricante;
    private int qtdProduto;
    private BigDecimal valorProduto;
    private boolean status;
    private Date dtFabricacao;
    private int garantia;
    private String descricao;
    private String peso;
    private String altura;
    private String largura;
    private String profundidade;
    private String numPaginas;
    private String idioma;
    private String acabamento;
    private Set<CategoriaModel> categorias;
    private Set<ImagemProduto> imagens;

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
            int garantia, 
            String descricao, 
            String peso, 
            String altura, 
            String largura, 
            String profundidade, 
            String numPaginas, 
            String idioma, 
            String acabamento, 
            Set<CategoriaModel> categorias, 
            Set<ImagemProduto> imagens
        ) {

        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
        this.status = status;
        this.dtFabricacao = dtFabricacao;
        this.garantia = garantia;
        this.descricao = descricao;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.acabamento = acabamento;
        this.categorias = categorias;
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

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(String profundidade) {
        this.profundidade = profundidade;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
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

    public Set<CategoriaModel> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriaModel> categorias) {
        this.categorias = categorias;
    }

    public Set<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(Set<ImagemProduto> imagens) {
        this.imagens = imagens;
    }
}