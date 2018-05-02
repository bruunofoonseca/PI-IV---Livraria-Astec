/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author BruunoFoonseca
 */
@Entity
@Table(name = "TB_CATEGORIA")
@NamedQueries({
  @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM CategoriaModel c "
          + "INNER JOIN SubCategoriaModel sc ON sc.categoria.id = c.id"),
  @NamedQuery(name = "Categoria.findById", query = "SELECT c FROM CategoriaModel c WHERE c.id = :idCat")
})
public class CategoriaModel implements Serializable {
    
    @Id
    @Column(name = "ID_CATEGORIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "Nome inválido")
    @Column(name = "NOME_CATEGORIA", length = 100, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private Set<SubCategoriaModel> subCategorias;

    public CategoriaModel() {

    }

    public CategoriaModel(Long id, String nome) {
      this.id = id;
      this.nome = nome;
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

    public Set<SubCategoriaModel> getSubCategorias() {
      return subCategorias;
    }

    public void setSubCategorias(Set<SubCategoriaModel> subCategorias) {
      this.subCategorias = subCategorias;
    }

    @Override
    public String toString() {
      return "CategoriaModel{" + "id=" + id + ", nome=" + nome + '}';
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