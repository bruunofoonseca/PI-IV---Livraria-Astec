/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import java.util.Date;
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

    @Size(min = 1, max = 100, message = "Telefone inválido")
    @Column(name = "TELEFONE", length = 100, nullable = false)
    private String telefone;

    @Size(min = 1, max = 100, message = "Celular inválido")
    @Column(name = "CELULAR", length = 100, nullable = false)
    private String celular;

    @Size(min = 1, max = 100, message = "Email inválido")
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "STATUS", nullable = false)
    private boolean ativo;
    
    @OneToMany(mappedBy = "usuario")
    private Set<EnderecoModel> enderecos;

    // constructor
    public UsuarioModel() {

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