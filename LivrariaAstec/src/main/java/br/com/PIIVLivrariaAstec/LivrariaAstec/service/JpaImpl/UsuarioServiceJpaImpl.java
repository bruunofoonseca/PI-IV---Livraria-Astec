/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.JpaImpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.EnderecoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.UsuarioService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno.falmeida
 */
@Repository
public class UsuarioServiceJpaImpl implements UsuarioService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
   
    
    @Override
    public List<UsuarioModel> listar() {
        Query query = entityManager.createQuery("SELECT p FROM UsuarioModel p");

        List<UsuarioModel> resultados = query.getResultList();

        return resultados;
    }

    @Override
    public UsuarioModel obter(String email, String senha) {
        Query query = entityManager.createQuery(
            "SELECT DISTINCT user FROM UsuarioModel user "
            + "LEFT JOIN FETCH user.pedidos "
            + "LEFT JOIN FETCH user.enderecos "
            + "WHERE user.email = :email AND user.senha = :senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        UsuarioModel user = (UsuarioModel) query.getSingleResult();
        return user;
    }

    @Override
    @Transactional
    public void inserir(UsuarioModel user) {
        for(EnderecoModel end : user.getEnderecos()) {
            entityManager.persist(end);
        }

        entityManager.persist(user);
    }

    @Override
    public void alterar(UsuarioModel user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
