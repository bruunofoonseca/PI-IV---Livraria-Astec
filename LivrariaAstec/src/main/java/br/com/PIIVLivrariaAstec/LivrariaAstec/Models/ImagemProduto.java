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
package br.com.PIIVLivrariaAstec.LivrariaAstec.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_IMAGEM")
public class ImagemProduto implements Serializable {

    @Id
    @Column(name = "ID_IMAGEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_IMAGEM", length = 255, nullable = false)
    private String nomeArquivo;

    @Column(name = "LEGENDA_IMAGEM", length = 1000)
    private String legenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTO")
    private ProdutoModel produto;

    public ImagemProduto() {

    }

    public ImagemProduto(Long id, String nomeArquivo, String legenda) {
      this.id = id;
      this.nomeArquivo = nomeArquivo;
      this.legenda = legenda;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNomeArquivo() {
      return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
      this.nomeArquivo = nomeArquivo;
    }

    public String getLegenda() {
      return legenda;
    }

    public void setLegenda(String legenda) {
      this.legenda = legenda;
    }

    public ProdutoModel getProduto() {
      return produto;
    }

    public void setProduto(ProdutoModel produto) {
      this.produto = produto;
    }

    public String getUrlArquivo() {
      return "/img/" + nomeArquivo;
    }

    @Override
    public String toString() {
      return "ImagemProduto{" + "id=" + id + ", legenda=" + legenda + ", nomeArquivo=" + nomeArquivo + '}';
    }
}
