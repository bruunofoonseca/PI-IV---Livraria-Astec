/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ImagemProduto;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno.falmeida, diogo.Sfelix
 */
@Repository
public class ProdutoServiceJpaImpl implements ProdutoService {
    
    @PersistenceContext
    private EntityManager entityManager;
      
    @Override
    public List<ProdutoModel> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM ProdutoModel p " +
            "LEFT JOIN FETCH p.item")
	    .setFirstResult(offset)
	    .setMaxResults(quantidade);

        List<ProdutoModel> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public List<ProdutoModel> listarPorCategoria(CategoriaModel categoria, int offset, int quantidade) {
        Query query = entityManager.createQuery(
            "SELECT DISTINCT p FROM ProdutoModel p "
            + "LEFT JOIN FETCH p.categoria "
            + "LEFT JOIN FETCH p.imagens "
            + "INNER JOIN p.categoria c "
            + "WHERE c.nome LIKE :nmCat")
            .setParameter("nmCat", categoria.getNome())
            .setFirstResult(offset)
            .setMaxResults(quantidade);
        List<ProdutoModel> resultados = query.getResultList();

        return resultados;
    }

    @Override
    public ProdutoModel obter(long idProduto) {
        Query query = entityManager.createQuery(
                "SELECT p FROM ProdutoModel p "
                + "LEFT JOIN FETCH p.categoria "
                + "LEFT JOIN FETCH p.imagens "
                + "WHERE p.id = :idProd");
        query.setParameter("idProd", idProduto);
        ProdutoModel p = (ProdutoModel) query.getSingleResult();
        return p;
    }

    @Override
    @Transactional
    public void incluir(ProdutoModel p) {
        for (ImagemProduto img : p.getImagens()) {
            if (img.getId() == null) {
                entityManager.persist(img);
            } else {
                entityManager.merge(img);
            }
        }

        entityManager.persist(p);
    }

    @Override
    @Transactional
    public void alterar(ProdutoModel p) {
        for (ImagemProduto img : p.getImagens()) {
            if (img.getId() == null) {
                entityManager.persist(img);
            } else {
                entityManager.merge(img);
            }
        }

        entityManager.merge(p);
    }

    @Override
    @Transactional
    public void remover(long idProduto) {
        ProdutoModel p = entityManager.find(ProdutoModel.class, idProduto);
        entityManager.remove(p);
    }
}
