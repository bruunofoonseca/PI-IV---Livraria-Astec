package br.com.PIIVLivrariaAstec.LivrariaAstec.service;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;

import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public interface UsuarioService{

    public List<UsuarioModel> listar();
    public UsuarioModel obter(String email, String senha);
    public void inserir(UsuarioModel user);
    public void alterar(UsuarioModel user);
    public void remover(long idUsuario);
}