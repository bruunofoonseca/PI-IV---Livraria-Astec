/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.DAOs;

import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.LoginModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.ModuloModel;
import br.com.PIIVLivrariaAstec.LivrariaAstec.Utils.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public class LoginDAO {
    public static LoginModel DoLogin(String login, String senha) throws SQLException, Exception {
        String sql = "SELECT f.IdFunc, f.IdCargo, f.login, f.nome, c.cargo_nome, s.setor_nome, f.IdFilial\n" +
                        "FROM funcionario f\n" +
                        "INNER JOIN cargo c on c.IdCargo = f.IdCargo\n" +
                        "INNER JOIN setor s on s.IdSetor = c.IdSetor\n" +
                        "INNER JOIN filial fili on fili.IdFilial = f.IdFilial\n" +
                        "WHERE f.login = ? and f.senha = ?";
        
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, login);            
            preparedStatement.setString(2, senha);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                LoginModel Login = new LoginModel();
                Login.setIdUsuario(result.getInt("IdFunc"));
                Login.setIdCargo(result.getInt("IdCargo"));
                Login.setFilial(FilialDAO.obter(result.getInt("IdFilial")));
                Login.setLogin(result.getString("login"));
                Login.setNome(result.getString("nome"));
                Login.setCargo(result.getString("cargo_nome"));
                Login.setSetor(result.getString("setor_nome"));
                
                //Retorna o resultado
                return getPermissao(Login);
            }
        }catch(SQLException e) {
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
        
    private static LoginModel getPermissao(LoginModel login) throws SQLException {
        
        List<ModuloModel> modulos = null;

        String sql = "SELECT m.IDMODULO, m.MODULO_NOME, m.SUB_NOME from MODULO m " +
                    "INNER JOIN PERMISSAO p on p.IDMODULO = m.IDMODULO AND p.IDCARGO = ?";
        
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, login.getIdCargo());

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (modulos == null) {
                    modulos = new ArrayList<>();
                }
                
                if(!modulos.isEmpty()) {
                    ModuloModel modulo = null;
                    boolean flag = true;

                    for (ModuloModel moduloAux : modulos) {
                        if(moduloAux.getModuloNome().equals(result.getString("MODULO_NOME"))) {
                            moduloAux.setSubNome(result.getString("SUB_NOME"));
                            flag = false;
                        }
                    }
                    
                    if(flag) {
                        modulo = new ModuloModel();
                        modulo.setModuloNome(result.getString("MODULO_NOME"));
                        modulo.setIdModulo(result.getInt("IDMODULO"));
                        modulo.setSubNome(result.getString("SUB_NOME"));
                        modulos.add(modulo);
                    }
                } else {
                    ModuloModel modulo = new ModuloModel();
                    modulo.setModuloNome(result.getString("MODULO_NOME"));
                    modulo.setIdModulo(result.getInt("IDMODULO"));
                    modulo.setSubNome(result.getString("SUB_NOME"));

                    //Adiciona a instância na lista
                    modulos.add(modulo);
                }   
            }
            
            login.setModulos(modulos);
        } catch(Exception e) {
            System.out.println(e);
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
        return login;
    }
}