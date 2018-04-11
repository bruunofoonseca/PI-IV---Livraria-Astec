/*
 * The MIT License
 *
 * Copyright 2016 Fernando.
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
import br.com.PIIVLivrariaAstec.LivrariaAstec.service.CategoriaService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
public class CategoriaServiceFakeImpl implements CategoriaService {

  private static final Map<Integer, CategoriaModel> MAP_CATEGORIA = new LinkedHashMap<Integer, CategoriaModel>();

  static {
    MAP_CATEGORIA.put(1, new CategoriaModel(1, "Bolo"));
    MAP_CATEGORIA.put(2, new CategoriaModel(2, "Torta"));
    MAP_CATEGORIA.put(3, new CategoriaModel(3, "Chocolate"));
    MAP_CATEGORIA.put(4, new CategoriaModel(4, "Morango"));
    MAP_CATEGORIA.put(5, new CategoriaModel(5, "Light"));
    MAP_CATEGORIA.put(6, new CategoriaModel(6, "Crocante"));
    MAP_CATEGORIA.put(7, new CategoriaModel(7, "Abacaxi"));
    MAP_CATEGORIA.put(8, new CategoriaModel(8, "Coco"));
  }

  @Override
  public List<CategoriaModel> listar() {
    return new ArrayList<CategoriaModel>(MAP_CATEGORIA.values());
  }

  @Override
  public CategoriaModel obter(int id) {
    return MAP_CATEGORIA.get(id);
  }
}