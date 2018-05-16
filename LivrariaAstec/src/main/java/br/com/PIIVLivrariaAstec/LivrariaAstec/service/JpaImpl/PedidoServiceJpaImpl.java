/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemPedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.PedidoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno.falmeida
 */
@Repository
public class PedidoServiceJpaImpl implements PedidoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PedidoModel> listar() {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM PedidoModel p " +
                "INNER JOIN FETCH p.cliente " +
                "INNER JOIN FETCH p.enderecoEntrega " +
                "LEFT JOIN FETCH p.itens");

        List<PedidoModel> resultados = query.getResultList();

        return resultados;
    }

    @Override
    public PedidoModel obter(int id) {
        Query query = entityManager.createQuery(
                "SELECT p FROM PedidoModel p "
                + "WHERE p.id = :id");
        query.setParameter("id", id);
        PedidoModel p = (PedidoModel) query.getSingleResult();

        return p;
    }

    @Override
    @Transactional
    public void inserir(PedidoModel pedido) {
        if(pedido.getEnderecoEntrega().getId() == null) {
            entityManager.persist(pedido.getEnderecoEntrega());
        } else {
            entityManager.merge(pedido.getEnderecoEntrega());
        }
        entityManager.flush();
        entityManager.persist(pedido);
        entityManager.flush();

        for (ItemPedidoModel i : pedido.getItens()) {
            if (i.getId() == null) {
              entityManager.persist(i);
            } else {
              entityManager.merge(i);
            }
        }
    }
}
