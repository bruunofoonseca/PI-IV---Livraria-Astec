/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.DAOs;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.FilialModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Utils.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fonseca
 */
public class FilialDAO {
    public static void inserir(FilialModel filial)
            throws SQLException, Exception {
        String sql = "INSERT INTO FILIAL (FILIAL_NOME, ESTADO, CIDADE, STATUS) VALUES ("
                + "?, ?, ?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, filial.getFilial_Nome());
            preparedStatement.setString(2, filial.getEstado());
            preparedStatement.setString(3, filial.getCidade());
            preparedStatement.setBoolean(4, filial.isStatus());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        }
        catch (SQLException e) {
        }
        finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(FilialModel filial)
            throws SQLException, Exception {
        String sql = "UPDATE FILIAL SET FILIAL_NOME=?, ESTADO=?, CIDADE=?, STATUS=?"
            + "WHERE (IDFILIAL=?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, filial.getFilial_Nome());
            preparedStatement.setString(2, filial.getEstado());
            preparedStatement.setString(3, filial.getCidade());
            preparedStatement.setBoolean(4, filial.isStatus());
            preparedStatement.setInt(5, filial.getIdFilial());

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static List<FilialModel> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM FILIAL WHERE STATUS=?";

        List<FilialModel> listaFilial = null;

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaFilial == null) {
                    listaFilial = new ArrayList<>();
                }

                FilialModel filial = new FilialModel();
                filial.setIdFilial(result.getInt("IDFILIAL"));
                filial.setFilial_Nome(result.getString("FILIAL_NOME"));
                filial.setEstado(result.getString("ESTADO"));
                filial.setCidade(result.getString("CIDADE"));
                filial.setStatus(result.getBoolean("STATUS"));
                
                //Adiciona a instância na lista
                listaFilial.add(filial);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaFilial;
    }
    
    public static List<FilialModel> procurar(String nome)
            throws SQLException, Exception {
        String sql = "SELECT * FROM FILIAL "
                + "WHERE UPPER(FILIAL_NOME) LIKE UPPER(?) AND STATUS=?";
        
        //Lista de clientes de resultado
        List<FilialModel> listaFiliais = null;
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + nome + "%");
            preparedStatement.setBoolean(2, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaFiliais == null) {
                    listaFiliais = new ArrayList<>();
                }
                
                FilialModel filial = new FilialModel();
                filial.setIdFilial(result.getInt("IDFILIAL"));
                filial.setFilial_Nome(result.getString("FILIAL_NOME"));
                filial.setEstado(result.getString("ESTADO"));
                filial.setCidade(result.getString("CIDADE"));
                filial.setStatus(result.getBoolean("STATUS"));
                
                //Adiciona a instância na lista
                listaFiliais.add(filial);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return listaFiliais;        
    }

    public static FilialModel obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM FILIAL WHERE IDFILIAL=? AND STATUS=?";

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);            
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                FilialModel filial = new FilialModel();
                filial.setIdFilial(result.getInt("IDFILIAL"));
                filial.setFilial_Nome(result.getString("FILIAL_NOME"));
                filial.setEstado(result.getString("ESTADO"));
                filial.setCidade(result.getString("CIDADE"));
                filial.setStatus(result.getBoolean("STATUS"));
                
                //Retorna o resultado
                return filial;
            }            
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }

    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE FILIAL SET STATUS=? WHERE IDFILIAL=?";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}