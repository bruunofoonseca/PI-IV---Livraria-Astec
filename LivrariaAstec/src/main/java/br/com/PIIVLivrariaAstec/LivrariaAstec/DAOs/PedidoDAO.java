///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.PIIVLivrariaAstec.LivrariaAstec.DAOs;
//
//import br.com.PIIVLivrariaAstec.LivrariaAstec.Utils.ConexaoDB;
//import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ItemPedidoModel;
//import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.PedidoModel;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// *
// * @author Bruno Fonseca
// */
//public class PedidoDAO {
//    public static void inserir(PedidoModel pedido)
//            throws SQLException, Exception {
//        
//        String sql = "INSERT INTO pedido (IDCLI, IDFILIAL, DATACOMP, VALOR) "
//                + "VALUES (?, ?, ?, ?)";
//        
//        //Conexão para abertura e fechamento
//        Connection connection = null;
//
//        //Statement para obtenção através da conexão, execução de
//        //comandos SQL e fechamentos
//        PreparedStatement preparedStatement = null;
//        try {
//            //Abre uma conexão com o banco de dados
//            connection = ConexaoDB.getConnection();
//
//            //Cria um statement para execução de instruções SQL
//            preparedStatement = connection.prepareStatement(sql, 
//                    PreparedStatement.RETURN_GENERATED_KEYS);
//
//            //Configura os parâmetros do "PreparedStatement"
//            preparedStatement.setInt(1, pedido.getCliente().getId());
//            preparedStatement.setInt(2, pedido.getFilial().getIdFilial());
//            Timestamp t = new Timestamp(pedido.getDataVenda().getTime());
//            preparedStatement.setTimestamp(3, t);
//            preparedStatement.setFloat(4, pedido.getValorTotal());
//            
//            //Executa o comando no banco de dados
//            preparedStatement.execute();
//            
//            preparedStatement.getGeneratedKeys().next();
//            
//            int idPedido = preparedStatement.getGeneratedKeys().getInt(1);
//            
//            for(int i = 0; i < pedido.getItens().size(); i++) {
//                inserirItemPedido(idPedido, pedido.getItens().get(i));
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            //Se o statement ainda estiver aberto, realiza seu fechamento
//            if (preparedStatement != null && !preparedStatement.isClosed()) {
//                preparedStatement.close();
//            }
//            //Se a conexão ainda estiver aberta, realiza seu fechamento
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        }
//    }
//    
//    private static void inserirItemPedido(int idPedido, ItemPedidoModel itemPedido)
//            throws SQLException, Exception {
//        
//        String sql = "INSERT INTO itenspedidos (IDPROD, IDPEDIDO, QUANTIDADE, SUBTOTAL) "
//                + "VALUES (?, ?, ?, ?)";
//        
//        //Conexão para abertura e fechamento
//        Connection connection2 = null;
//
//        //Statement para obtenção através da conexão, execução de
//        //comandos SQL e fechamentos
//        PreparedStatement preparedStatement2 = null;
//        try {
//            //Abre uma conexão com o banco de dados
//            connection2 = ConexaoDB.getConnection();
//
//            //Cria um statement para execução de instruções SQL
//            preparedStatement2 = connection2.prepareStatement(sql);
//
//            //Configura os parâmetros do "PreparedStatement"
//            preparedStatement2.setInt(1, itemPedido.getProduto().getId());
//            preparedStatement2.setInt(2, idPedido);
//            preparedStatement2.setInt(3, itemPedido.getQtd());
//            preparedStatement2.setFloat(4, itemPedido.getValorParcial());
//            
//            //Executa o comando no banco de dados
//            preparedStatement2.execute();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            //Se o statement ainda estiver aberto, realiza seu fechamento
//            if (preparedStatement2 != null && !preparedStatement2.isClosed()) {
//                preparedStatement2.close();
//            }
//            //Se a conexão ainda estiver aberta, realiza seu fechamento
//            if (connection2 != null && !connection2.isClosed()) {
//                connection2.close();
//            }
//        }
//    }
//    
//    public static List<PedidoModel> listar()
//            throws SQLException, Exception {
//
//        String sql = "SELECT * FROM pedido";
//
//        List<PedidoModel> listaPedidos = null;
//
//        //Conexão para abertura e fechamento
//        Connection connection = null;
//
//        //Statement para obtenção através da conexão, execução de
//        //comandos SQL e fechamentos
//        PreparedStatement preparedStatement = null;
//
//        //Armazenará os resultados do banco de dados
//        ResultSet result = null;
//        try {
//            //Abre uma conexão com o banco de dados
//            connection = ConexaoDB.getConnection();
//
//            //Cria um statement para execução de instruções SQL
//            preparedStatement = connection.prepareStatement(sql);
//            
//            //Executa a consulta SQL no banco de dados
//            result = preparedStatement.executeQuery();
//            
//            //Itera por cada item do resultado
//            while (result.next()) {
//                //Se a lista não foi inicializada, a inicializa
//                if (listaPedidos == null) {
//                    listaPedidos = new ArrayList<>();
//                }
//
//                PedidoModel pedido = new PedidoModel();
//                pedido.setId(result.getInt("IDPEDIDO"));
//                pedido.setCliente(ClienteDAO.obter(result.getInt("IDCLI")));
//                pedido.setFilial(FilialDAO.obter(result.getInt("IDFILIAL")));
//                Date d = new Date(result.getTimestamp("DATACOMP").getTime());
//                pedido.setDataVenda(d);
//                pedido.setValorTotal(result.getFloat("VALOR"));
//                pedido.setItens(listarItem(result.getInt("IDPEDIDO")));
//                
//                //Adiciona a instância na lista
//                listaPedidos.add(pedido);
//            }
//        } finally {
//            //Se o result ainda estiver aberto, realiza seu fechamento
//            if (result != null && !result.isClosed()) {
//                result.close();
//            }
//            //Se o statement ainda estiver aberto, realiza seu fechamento
//            if (preparedStatement != null && !preparedStatement.isClosed()) {
//                preparedStatement.close();
//            }
//            //Se a conexão ainda estiver aberta, realiza seu fechamento
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        }
//
//        return listaPedidos;
//    }
//    
//    public static List<ItemPedidoModel> listarItem(int idPedido)
//            throws SQLException, Exception {
//
//        String sql = "SELECT * FROM itenspedidos WHERE IDPEDIDO=?";
//
//        List<ItemPedidoModel> listaItens = null;
//
//        //Conexão para abertura e fechamento
//        Connection connection = null;
//
//        //Statement para obtenção através da conexão, execução de
//        //comandos SQL e fechamentos
//        PreparedStatement preparedStatement = null;
//
//        //Armazenará os resultados do banco de dados
//        ResultSet result = null;
//        try {
//            //Abre uma conexão com o banco de dados
//            connection = ConexaoDB.getConnection();
//
//            //Cria um statement para execução de instruções SQL
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, idPedido);
//            
//            //Executa a consulta SQL no banco de dados
//            result = preparedStatement.executeQuery();
//            
//            //Itera por cada item do resultado
//            while (result.next()) {
//                //Se a lista não foi inicializada, a inicializa
//                if (listaItens == null) {
//                    listaItens = new ArrayList<>();
//                }
//
//                ItemPedidoModel item = new ItemPedidoModel();
//                item.setId(result.getInt("IDITEM"));
//                item.setQtd(result.getInt("QUANTIDADE"));
//                item.setValorParcial(result.getInt("SUBTOTAL"));
////                item.setProduto(ProdutoDAO.obter(result.getInt("IDPROD")));
//                
//                //Adiciona a instância na lista
//                listaItens.add(item);
//            }
//        } finally {
//            //Se o result ainda estiver aberto, realiza seu fechamento
//            if (result != null && !result.isClosed()) {
//                result.close();
//            }
//            //Se o statement ainda estiver aberto, realiza seu fechamento
//            if (preparedStatement != null && !preparedStatement.isClosed()) {
//                preparedStatement.close();
//            }
//            //Se a conexão ainda estiver aberta, realiza seu fechamento
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        }
//        
//        return listaItens;
//    }
//    
//    public static List<PedidoModel> listarPorFilial(int idFilial)
//            throws SQLException, Exception {
//
//        String sql = "SELECT * FROM pedido WHERE IDFILIAL=?";
//
//        List<PedidoModel> listaPedidos = null;
//
//        //Conexão para abertura e fechamento
//        Connection connection = null;
//
//        //Statement para obtenção através da conexão, execução de
//        //comandos SQL e fechamentos
//        PreparedStatement preparedStatement = null;
//
//        //Armazenará os resultados do banco de dados
//        ResultSet result = null;
//        try {
//            //Abre uma conexão com o banco de dados
//            connection = ConexaoDB.getConnection();
//
//            //Cria um statement para execução de instruções SQL
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, idFilial);
//            
//            //Executa a consulta SQL no banco de dados
//            result = preparedStatement.executeQuery();
//            
//            //Itera por cada item do resultado
//            while (result.next()) {
//                //Se a lista não foi inicializada, a inicializa
//                if (listaPedidos == null) {
//                    listaPedidos = new ArrayList<>();
//                }
//
//                PedidoModel pedido = new PedidoModel();
//                pedido.setId(result.getInt("IDPEDIDO"));
//                pedido.setCliente(ClienteDAO.obter(result.getInt("IDCLI")));
//                pedido.setFilial(FilialDAO.obter(result.getInt("IDFILIAL")));
//                Date d = new Date(result.getTimestamp("DATACOMP").getTime());
//                pedido.setDataVenda(d);
//                pedido.setValorTotal(result.getFloat("VALOR"));
//                pedido.setItens(listarItem(result.getInt("IDPEDIDO")));
//                
//                //Adiciona a instância na lista
//                listaPedidos.add(pedido);
//            }
//        } finally {
//            //Se o result ainda estiver aberto, realiza seu fechamento
//            if (result != null && !result.isClosed()) {
//                result.close();
//            }
//            //Se o statement ainda estiver aberto, realiza seu fechamento
//            if (preparedStatement != null && !preparedStatement.isClosed()) {
//                preparedStatement.close();
//            }
//            //Se a conexão ainda estiver aberta, realiza seu fechamento
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        }
//
//        return listaPedidos;
//    }
//}