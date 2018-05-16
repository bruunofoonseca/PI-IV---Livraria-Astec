/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.UsuarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.CategoriaService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.UsuarioService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bruno.falmeida
 */
@Controller
@RequestMapping
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService categoriaService;
    
//    @Autowired
//    private UsuarioService serviceUsuario;

    @GetMapping
    public ModelAndView listar() {
        List<ProdutoModel> lista = service.listar(0, 100);
        
//        UsuarioModel user = serviceUsuario.obter("usuario@usuario.com", "123456");

        List<CategoriaModel> categorias = categoriaService.listar();

        return new ModelAndView("listagemProdutos")
                .addObject("produtos", lista)
                .addObject("categorias", categorias);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarDetalhe(@PathVariable("id") Long id) {
        ProdutoModel p = service.obter(id);
        return new ModelAndView("detalheProduto").addObject("produto", p);
    }
}