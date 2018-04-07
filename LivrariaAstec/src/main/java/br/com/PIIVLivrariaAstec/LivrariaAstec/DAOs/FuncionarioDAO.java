/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.DAOs;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.FuncionarioModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Utils.ConexaoDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public class FuncionarioDAO {
    public static void inserir(FuncionarioModel func)
            throws SQLException, Exception {

        /*
        String sql = "INSERT INTO FUNCIONARIO (FUNC_NOME, SEXO, STATUS, DATANASC, ESTADOCIVIL,"
                + "CPF, TEL, CEL, EMAIL, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, "
                + "BAIRRO, CIDADE, ESTADO, LOGIN, SENHA, IDFILIAL, IDCARGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?)";
        */
        String sql = "INSERT INTO FUNCIONARIO (IDFILIAL, IDCARGO, NOME, LOGIN, SENHA, STATUS) "
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        
        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            System.out.println("Entrei no try");
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, func.getFilial().getIdFilial());
            preparedStatement.setInt(2, func.getCargo().getIdCargo());
            preparedStatement.setString(3, func.getNome());
            preparedStatement.setString(4, func.getLogin());
            preparedStatement.setString(5, func.getSenha());
            preparedStatement.setBoolean(6, true);

            //Executa o comando no banco de dados
            System.out.println("VOu Executar query");
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

    public static void atualizar(FuncionarioModel func)
            throws SQLException, Exception {
        String sql = "UPDATE FUNCIONARIO SET IDFILIAL=?, IDCARGO=?, NOME=?, " 
                + "LOGIN=?, SENHA=?"
            + "WHERE (IDFUNC=?)";
        
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
            preparedStatement.setInt(1, func.getFilial().getIdFilial());
            preparedStatement.setInt(2, func.getCargo().getIdCargo());
            preparedStatement.setString(3, func.getNome());
            preparedStatement.setString(4, func.getLogin());
            preparedStatement.setString(5, func.getSenha());
            preparedStatement.setInt(6, func.getIdFunc());

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
    
    public static List<FuncionarioModel> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM FUNCIONARIO WHERE (STATUS=?)";

        List<FuncionarioModel> listaFuncionarios = null;

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
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<>();
                }

                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setFilial(FilialDAO.obter(result.getInt("IDFILIAL")));
                funcionario.setCargo(CargoDAO.obter(result.getInt("IDCARGO")));
                funcionario.setNome(result.getString("NOME"));
                funcionario.setLogin(result.getString("LOGIN"));
                funcionario.setSenha(result.getString("SENHA"));
                
                //Adiciona a instância na lista
                listaFuncionarios.add(funcionario);
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

        return listaFuncionarios;
    }
    
    public static List<FuncionarioModel> procurar(String nome)
            throws SQLException, Exception {
        String sql = "SELECT * FROM FUNCIONARIO "
                + "WHERE ((UPPER(NOME) LIKE UPPER(?)) AND STATUS=?)";
        
        //Lista de clientes de resultado
        List<FuncionarioModel> listaFuncionarios = null;
        
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
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<>();
                }
                
                FuncionarioModel funcionario;
                funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setFilial(FilialDAO.obter(result.getInt("IDFILIAL")));
                funcionario.setCargo(CargoDAO.obter(result.getInt("IDCARGO")));
                funcionario.setNome(result.getString("NOME"));
                
                funcionario.setStatus(result.getBoolean("STATUS"));
                
                
                //Adiciona a instância na lista
                listaFuncionarios.add(funcionario);
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
        
        return listaFuncionarios;        
    }

    public static FuncionarioModel obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM FUNCIONARIO WHERE IDFUNC=? AND STATUS=?";

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
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setFilial(FilialDAO.obter(result.getInt("IDFILIAL")));
                funcionario.setCargo(CargoDAO.obter(result.getInt("IDCARGO")));
                funcionario.setNome(result.getString("NOME"));
                funcionario.setLogin(result.getString("LOGIN"));
                funcionario.setSenha(result.getString("SENHA"));
                funcionario.setStatus(result.getBoolean("STATUS"));
                
                //Retorna o resultado
                return funcionario;
            }
        } catch(Exception e) {
            System.out.print(e);
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
        String sql = "UPDATE FUNCIONARIO SET STATUS=? WHERE IDFUNC=?";
        
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