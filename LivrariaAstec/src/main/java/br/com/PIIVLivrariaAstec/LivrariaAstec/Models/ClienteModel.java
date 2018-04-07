/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.util.Date;

/**
 *
 * @author bruno.falmeida
 * edit diogo.sfelix
 */
public class ClienteModel {
    //Atributos de dados pessoais
    private Integer id;
    private String nome;
    private String sexo;
    private Date data;
    private String estadoCivil;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;
    private boolean ativo;
    //Atributo de endereço
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String estado;
    private String cidade;

    // constructor
    
    public ClienteModel(){
    }
    
    public ClienteModel(
            String nome, String sexo, Date data,
            String estadoCivil, String cpf, String telefone,
            String celular, String email, String logradouro,
            String numero, String cep, String bairro, 
            String estado, String cidade
    ){
            this.nome = nome; this.sexo = sexo;
            this.data = data; this.estadoCivil = estadoCivil;
            this.cpf = cpf; this.telefone = telefone; this.celular = celular;
            this.email = email; this.logradouro = logradouro;
            this.numero = numero; this.cep = cep; this.bairro = bairro;
            this.estado = estado; this.cidade = cidade;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
