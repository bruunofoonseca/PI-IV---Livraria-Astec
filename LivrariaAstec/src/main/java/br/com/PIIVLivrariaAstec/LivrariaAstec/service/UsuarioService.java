/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public interface UsuarioService extends Serializable {

    public List<UsuarioModel> listar();

    public UsuarioModel obter(String email, String senha);

    public void inserir(UsuarioModel user);

    public void alterar(UsuarioModel user);

    public void remover(long idUsuario);
}