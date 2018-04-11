/*
 * The MIT License
 *
 * Copyright 2016 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.service.fakeimpl;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CategoriaModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ImagemProduto;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ProdutoModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.CategoriaService;
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.ProdutoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class ProdutoServiceFakeImpl implements ProdutoService {

  private static final Map<Long, ProdutoModel> MAPA_PRODUTOS = new LinkedHashMap<Long, ProdutoModel>();

  private static final String DESCRICAO_PADRAO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
          + "Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. "
          + "Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. "
          + "Phasellus nec posuere magna, in vehicula elit. "
          + "Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. "
          + "Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. "
          + "Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. "
          + "Cras posuere tempor lectus, ac porttitor tellus maximus vel.";

  static {
    CategoriaService categorias = new CategoriaServiceFakeImpl();
    ProdutoModel produto = new ProdutoModel(1L, "Floresta negra", "Editora Abril", 50, new BigDecimal(100), true,
            new Date(), 2, DESCRICAO_PADRAO, "2,40Kg", "1", "2", "5", "300", "Portugues", "Capa Dura",
            new LinkedHashSet<CategoriaModel>(Arrays.asList(categorias.obter(1), categorias.obter(3))),
            new LinkedHashSet<ImagemProduto>(Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg"))));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new ProdutoModel(2L, "Harry Potter", "Editora Abril", 50, new BigDecimal(100), true,
            new Date(), 2, DESCRICAO_PADRAO, "2,40Kg", "1", "2", "5", "300", "Portugues", "Capa Dura",
            new LinkedHashSet<CategoriaModel>(Arrays.asList(categorias.obter(1), categorias.obter(3))),
            new LinkedHashSet<ImagemProduto>(Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg"))));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new ProdutoModel(3L, "Percy Jackson", "Editora Abril", 50, new BigDecimal(100), true,
            new Date(), 2, DESCRICAO_PADRAO, "2,40Kg", "1", "2", "5", "300", "Portugues", "Capa Dura",
            new LinkedHashSet<CategoriaModel>(Arrays.asList(categorias.obter(1), categorias.obter(3))),
            new LinkedHashSet<ImagemProduto>(Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg"))));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new ProdutoModel(4L, "Game Of Thrones", "Editora Abril", 50, new BigDecimal(100), true,
            new Date(), 2, DESCRICAO_PADRAO, "2,40Kg", "1", "2", "5", "300", "Portugues", "Capa Dura",
            new LinkedHashSet<CategoriaModel>(Arrays.asList(categorias.obter(1), categorias.obter(3))),
            new LinkedHashSet<ImagemProduto>(Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg"))));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new ProdutoModel(5L, "Martelinho de Ouro", "Editora Abril", 50, new BigDecimal(100), true,
            new Date(), 2, DESCRICAO_PADRAO, "2,40Kg", "1", "2", "5", "300", "Portugues", "Capa Dura",
            new LinkedHashSet<CategoriaModel>(Arrays.asList(categorias.obter(1), categorias.obter(3))),
            new LinkedHashSet<ImagemProduto>(Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg"))));
    MAPA_PRODUTOS.put(produto.getId(), produto);
  }

  @Override
  public List<ProdutoModel> listar(int offset, int quantidade) {
    return new ArrayList<ProdutoModel>(MAPA_PRODUTOS.values());
  }

  @Override
  public List<ProdutoModel> listarPorCategoria(CategoriaModel categoria, int offset, int quantidade) {
    Set<ProdutoModel> lista = new LinkedHashSet<ProdutoModel>();
    for (Map.Entry<Long, ProdutoModel> entry : MAPA_PRODUTOS.entrySet()) {
      ProdutoModel p = entry.getValue();
      if (p.getCategorias().contains(categoria)) {
        lista.add(p);
      }
    }
    return Arrays.asList(lista.toArray(new ProdutoModel[1]));
  }

  @Override
  public ProdutoModel obter(long idProduto) {
    return MAPA_PRODUTOS.get(idProduto);
  }

  @Override
  public void incluir(ProdutoModel p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void alterar(ProdutoModel p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void remover(long idProduto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}