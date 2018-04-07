/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.util.Date;

/**
 *
 * @author Bruno Fonseca
 * edit Diogo.Felix
 */
public class ProdutoModel {
     // Atributos
    private Integer id;
    private String nome;
    private String fabricante;
    private String tipoProduto;
    private int qtdProduto;
    private float valorProduto;
    private boolean status;
    private Date dtFabricacao;
    private int garantia;

    // Constructor
    public ProdutoModel(){
    
    }
    
    public ProdutoModel(
         String nome, String fabricante, String tipoProduto,
         int qtdProduto, float valorProduto,  
         Date dtFabricacao, int garantia
    ){
        this.nome = nome; this.fabricante = fabricante; 
        this.tipoProduto = tipoProduto; this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto; this.status = status;
        this.dtFabricacao = dtFabricacao; this.garantia = garantia;
    }
    
    // Get e Setter

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

    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getNome (){
        return this.nome;
    }
    
    public void setFabricante (String fabricante){
        this.fabricante = fabricante;
    }
    
    public String getFabricante (){
        return this.fabricante;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
     
    public void setValorProduto(Float ValorProd){
        this.valorProduto = ValorProd;
    }
    
    public Float getValorProduto(){
        return valorProduto;
    }
}