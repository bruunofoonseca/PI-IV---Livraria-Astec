/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author bruno.falmeida
 */
@Entity
@Table(name = "TB_SUB_CATEGORIA")
public class SubCategoriaModel implements Serializable {
    @Id
    @Column(name = "ID_SUB_CATEGORIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 1, max = 100, message = "Nome inválido")
    @Column(name = "NOME_SUB_CATEGORIA", length = 100, nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA")
    private CategoriaModel categoria;
    
    @OneToMany(mappedBy = "subCategoria")
    private Set<ProdutoModel> produtos;
    
    public SubCategoriaModel() {

    }

    public SubCategoriaModel(Long id, String nome, CategoriaModel categoria, Set<ProdutoModel> produtos) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.produtos = produtos;
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

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public Set<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoModel> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public String toString() {
      return "SubCategoriaModel(" + 
                "id="+ id +
                ", nome=" + nome + 
                ", categoria=" + categoria + 
                ", produtos=" + produtos + ")";
    }
}