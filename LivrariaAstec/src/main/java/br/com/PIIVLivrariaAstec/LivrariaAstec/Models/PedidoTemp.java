/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diogo.sfelix
 */
public class PedidoTemp {
    
    private List<ItemIds> items = new ArrayList<>();

    public List<ItemIds> getItems() {
        return items;
    }

    public void setItems(List<ItemIds> items) {
        this.items = items;
    }
    
}
