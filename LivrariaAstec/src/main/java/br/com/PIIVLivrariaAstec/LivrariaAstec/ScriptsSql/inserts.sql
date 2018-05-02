/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 01/05/2018
 */

/* PRODUTOS */
insert tb_produto values (1, 'CAPA DURA', 1.2, 'ESSE LIVRO ABORDA DE FORMA SUTIL, A ARTE DE LIGA O FODA-SE', '2015-05-01 18:45', '2014-08-15 10:00', 'EDITORA PLANETA', 'PORTUGUES', 23.5, 'A SUTIL ARTE DE LIGAR O FODA-SE', 114, 1, 12.5, 15,TRUE, 32.18, 1);
insert tb_produto values (2, 'CAPA DURA', 1.2, 'APRENDE A ARTE DE DOMINAR QUALQUER DISCUSSAO EM 90 SEGUNDOS', '2015-05-01 18:45', '2014-08-15 10:00', 'EDITORA NOVA VIDA', 'PORTUGUES', 23.5, 'GANHE QUALQUER DISCUSSAO 90 SEGUNDOS', 215, 1, 12.5, 5, TRUE, 19.80, 2);
insert tb_produto values (3, 'CAPA DURA', 1.2, 'AUTO BIOGRAFIA DE ROBERTO JUSTUS', '2015-05-01 18:45', '2014-08-15 10:00', 'EDITORA W3C', 'PORTUGUES', 23.5, 'ROBERTO JUSTUS - UMA AUTOBIOGRAFIA', 128, 1, 12.5, 7, TRUE, 4.90, 3);
insert tb_produto values (4, 'CAPA DURA', 1.2, 'ENCANTE-SE COM ESSA MAGNIFICA HISTORIA DO VISIONARIO STEVE JOBS', '2015-05-01 18:45', '2014-08-15 10:00','EDITORA APPLE', 'PORTUGUES', 23.5, 'STEVE JOBS', 325,1, 12.5, 30, TRUE, 48.99, 4);
insert tb_produto values (5, 'CAPA DURA', 1.2, 'PORQUE FAZEMOS O QUE FAZEMOS, VOCE JA PAROU PARA REFLETIR?', '2015-05-01 18:45', '2014-08-15 10:00', 'EDITORA PLANETA', 'PORTUGUES', 23.5, 'PORQUE FAZEMOS O QUE FAZEMOS', 97, 1, 12.5, 3, TRUE, 15.89, 5);
insert tb_produto values (6, 'CAPA DURA', 1.2, 'CONHEÇA A SUPREENDENTE HISTORIA POR DE TRAS DA MAIOR SERIE DE TERROR DOS ULTIMOS TEMPOS', '2015-05-01 18:45', '2014-08-15 10:00', 'EDITORA PANINI', 'PORTUGUES', 23.5, 'THE WALKING DEAD - A HISTORIA', 521, 1, 12.5, 25, TRUE, 118.78, 6);

/* CATEGORIAS */
insert tb_categoria values (1, 'LIVROS');
insert tb_categoria values (2, 'PAPELARIA');
insert tb_categoria values (3, 'INFORMATICA');
insert tb_categoria values (4, 'FILMES E SERIES');

/* SUB CATEGORIAS */
insert tb_sub_categoria values (1, 'LITERATURA ESTRANGEIRA', 1);
insert tb_sub_categoria values (2, 'LITERATURA NACIONAL', 1);
insert tb_sub_categoria values (3, 'ESCOLAR', 2);
insert tb_sub_categoria values (4, 'DESENHO E PINTURA', 2);
insert tb_sub_categoria values (5, 'NOTEBOOKS', 3);
insert tb_sub_categoria values (6, 'LINHA GAMER', 3);
insert tb_sub_categoria values (7, 'PRE-VENDAS', 4);
insert tb_sub_categoria values (8, 'LANÇAMENTOS', 4);