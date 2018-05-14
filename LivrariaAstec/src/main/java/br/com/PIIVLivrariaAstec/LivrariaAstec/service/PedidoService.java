/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public interface PedidoService extends Serializable {
    public List<PedidoModel> listar();

    List<UsuarioModel> listarUsuário();

    public PedidoModel obter(int id);

    public void inserir(PedidoModel pedido);
}