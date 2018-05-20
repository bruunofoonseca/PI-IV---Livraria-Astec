/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author bruno.falmeida edit diogo.sfelix
 */
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Size(min = 1, max = 100, message = "Nome inválido")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    
    @Size(min = 1, max = 100, message = "Sobre nome inválido")
    @Column(name = "SOBRENOME", length = 100, nullable = false)
    private String sobrenome;

    @Size(min = 1, max = 100, message = "Sexo inválido")
    @Column(name = "SEXO", length = 100, nullable = false)
    private String sexo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private Date dataNascimento;

    @Size(min = 1, max = 100, message = "Estado Civil inválido")
    @Column(name = "ESTADO_CIVIL", length = 100, nullable = false)
    private String estadoCivil;

    @Size(min = 1, max = 100, message = "CPF inválido")
    @Column(name = "CPF", length = 100, nullable = false)
    private String cpf;

    @Size(min = 1, max = 100, message = "Telefone não informado")
    @Column(name = "TELEFONE", length = 100, nullable = false)
    private String telefone;

    @Size(min = 1, max = 100, message = "Celular não informado")
    @Column(name = "CELULAR", length = 100, nullable = false)
    private String celular;

    @Size(min = 1, max = 100, message = "Email inválido")
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;
    
    @Size(min = 1, max = 100, message = "Senha inválido")
    @Column(name = "SENHA", length = 100, nullable = false)
    private String senha;
    
    private String confirmarSenha;

    @Digits(integer = 6, fraction = 0)
    @Column(name = "PERMISSAO", precision = 6, scale = 2, nullable = false)
    private int permissao;

    @Column(name = "STATUS", nullable = false)
    private boolean ativo;
    
    @OneToMany(mappedBy = "usuario")
//    @Transient
    private Set<EnderecoModel> enderecos;
    
    @OneToMany(mappedBy = "cliente")
    private Set<PedidoModel> pedidos;

    // constructor
    public UsuarioModel() {
        EnderecoModel end = new EnderecoModel();
        enderecos = new LinkedHashSet<>();
        enderecos.add(end);
        pedidos = new LinkedHashSet<>();
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public Set<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<PedidoModel> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PedidoModel> pedidos) {
        this.pedidos = pedidos;
    }

    public UsuarioModel(
            String nome, String sexo, Date dataNascimento,
            String estadoCivil, String cpf, String telefone,
            String celular, String email
    ) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
}