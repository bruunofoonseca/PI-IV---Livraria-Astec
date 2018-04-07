/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

/**
 *
 * @author Bruno Fonseca
 */
public class PermissaoModel {
    private int IdPerm;
    private int IdModulo;
    private int IdCargo;

    public int getIdPerm() {
        return IdPerm;
    }

    public void setIdPerm(int IdPerm) {
        this.IdPerm = IdPerm;
    }

    public int getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(int IdModulo) {
        this.IdModulo = IdModulo;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }
}