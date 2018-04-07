/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  bruno.falmeida
 * Created: 06/11/2017
 */

create table cliente (
    IdCli int generated always as identity (start with 1, increment by 1) primary key,
    Nome varchar(100) not null,
    Sexo varchar (20),
    Status boolean,
    DataNasc Date not null,
    EstadoCivil varchar(30) not null,
    CPF varchar (30) not null,
    Tel varchar (30),
    Cel varchar (30),
    Email varchar(30),
    Logradouro varchar(150) not null,
    Numero varchar(30) not null,
    Complemento varchar(30),
    CEP varchar(10) not null,
    Bairro varchar(100) not null,
    Cidade varchar(100) not null,
    Estado varchar(100) not null
);

create table produto (
    IdProd int generated always as identity (start with 1, increment by 1) primary key,
    IdCategoria int not null,
    Nome varchar(100) not null,
    Fabricante varchar(100) not null,
    Quantidade int,
    Status boolean,
    Valor float,
    Garantia int,
    DataFab Date,
    Descricao varchar(300) not null,
    peso varchar(100),
    altura varchar(100),
    largura varchar(100),
    profundidade varchar(100),
    NumPag varchar(100),
    idioma varchar(100),
    acabamento varchar(100),
    foreign key (IdCategoria) references categoria(IdCategoria)
);

create table categoria (
    IdCategoria int generated always as identity (start with 1, increment by 1) primary key,
    Categoria varchar(100) not null
);

create table pedido (
    IdPedido int generated always as identity (start with 1, increment by 1) primary key,
    IdCli int not null,
    DataComp Date,
    Valor float,
    foreign key (IdCli) references cliente(IdCli)
);

create table itensPedidos (
    IdItem int generated always as identity (start with 1, increment by 1) primary key,
    IdProd int not null,
    IdPedido int not null,
    Quantidade int,
    SubTotal float,
    foreign key (IdProd) references produto(IdProd),
    foreign key (IdPedido) references pedido(IdPedido)
);