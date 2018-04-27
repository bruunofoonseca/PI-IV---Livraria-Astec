/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno.falmeida
 */
@Repository
public class ProdutoServiceJpaImpl implements ProdutoService {
    
    @PersistenceContext
    private EntityManager entityManager;
      
    @Override
    public List<ProdutoModel> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p")
	    .setFirstResult(offset)
	    .setMaxResults(quantidade);

        List<ProdutoModel> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public List<ProdutoModel> listarPorCategoria(CategoriaModel categoria, int offset, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdutoModel obter(long idProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(ProdutoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdutoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long idProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
