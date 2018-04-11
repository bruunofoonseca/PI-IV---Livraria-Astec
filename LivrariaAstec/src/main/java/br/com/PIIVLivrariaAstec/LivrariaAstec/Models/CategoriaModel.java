/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author BruunoFoonseca
 */
public class CategoriaModel implements Serializable {

  private Integer id;

  private String nome;

  private Set<ProdutoModel> produtos;

  public CategoriaModel() {

  }

  public CategoriaModel(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<ProdutoModel> getProdutos() {
    return produtos;
  }

  public void setProdutos(Set<ProdutoModel> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CategoriaModel other = (CategoriaModel) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }

    return true;
  }
}
