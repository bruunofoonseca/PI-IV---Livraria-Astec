/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.Controller;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.CategoriaService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        List<CategoriaModel> categorias = categoriaService.listar();

        return new ModelAndView("listagemProdutos")
            .addObject("produtos", lista)
            .addObject("categorias", categorias);
    }

    @GetMapping("/cat/{categoria}")
    public ModelAndView listarPorCategoria(
            @PathVariable("categoria") String categoria,
            @RequestParam(value = "pag", defaultValue = "0") int pagina,
            @RequestParam(value = "qt", defaultValue = "6") int quantidade) {

        List<CategoriaModel> categorias = categoriaService.listar();

        List<ProdutoModel> lista
                = service.listarPorCategoria(new CategoriaModel(categoria), pagina, quantidade);
        return new ModelAndView("listagemProdutos")
                .addObject("produtos", lista)
                .addObject("categorias", categorias);
    }

    @PostMapping("/busca")
    public ModelAndView buscaByName(@ModelAttribute("prod") String produto) {
        List<ProdutoModel> lista = service.obterByName(produto, 0, 100);

        List<CategoriaModel> categorias = categoriaService.listar();

        return new ModelAndView("listagemProdutos")
            .addObject("produtos", lista)
            .addObject("categorias", categorias);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarDetalhe(@PathVariable("id") Long id) {
        ProdutoModel p = service.obter(id);

        List<CategoriaModel> categorias = categoriaService.listar();

        return new ModelAndView("detalheProduto")
                .addObject("produto", p)
                .addObject("categorias", categorias);
    }
}