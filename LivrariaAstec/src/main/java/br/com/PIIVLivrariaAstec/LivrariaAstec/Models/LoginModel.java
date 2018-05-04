/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public class LoginModel {
    
    private int idUsuario;
    private String login;
    private String nome;
    private List<ModuloModel> modulos;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ModuloModel> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloModel> modulos) {
        this.modulos = modulos;
    }
}