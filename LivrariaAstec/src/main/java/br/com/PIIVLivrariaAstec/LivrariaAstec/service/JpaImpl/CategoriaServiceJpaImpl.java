/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.CategoriaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fernando.tsuda
 */
@Repository
public class CategoriaServiceJpaImpl implements CategoriaService {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<CategoriaModel> listar() {
    Query query = entityManager.createNamedQuery("Categoria.findAll");
    return query.getResultList();
  }

  @Override
  public CategoriaModel obter(Long id) {
    Query query = entityManager.createNamedQuery("Categoria.findById")
	    .setParameter("idCat", id);
    return (CategoriaModel) query.getSingleResult();
  }

}
