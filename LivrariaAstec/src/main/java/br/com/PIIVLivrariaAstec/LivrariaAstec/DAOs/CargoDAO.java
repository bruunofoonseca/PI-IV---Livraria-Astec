/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PIIVLivrariaAstec.LivrariaAstec.DAOs;
 
 import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.CargoModel;
 import br.com.PIIVLivrariaAstec.LivrariaAstec.Models.SetorModel;
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
  * @author Bruno Fonseca
  */
 public class CargoDAO {
         public static void inserir(CargoModel cargo)
             throws SQLException, Exception {
         String sql = "INSERT INTO CARGO (IDSETOR, CARGO_NOME, DESCRICAO, STATUS) VALUES ("
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
             preparedStatement.setInt(1, cargo.Setor.getIdSetor());
             preparedStatement.setString(2, cargo.getCargo_Nome());
             preparedStatement.setString(3, cargo.getDescricao());
             preparedStatement.setBoolean(4, cargo.isStatus());
             
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
 
     public static void atualizar(CargoModel cargo)
             throws SQLException, Exception {
         String sql = "UPDATE CARGO SET IDSETOR=?, CARGO_NOME=?, DESCRICAO=?, STATUS=?"
             + "WHERE (IDCARGO=?)";
         
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
             preparedStatement.setInt(1, cargo.Setor.getIdSetor());
             preparedStatement.setString(2, cargo.getCargo_Nome());
             preparedStatement.setString(3, cargo.getDescricao());
             preparedStatement.setBoolean(4, cargo.isStatus());
             preparedStatement.setInt(5, cargo.getIdCargo());
 
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
     
     public static List<CargoModel> listar()
             throws SQLException, Exception {
         String sql = "SELECT * FROM CARGO c "
                 + "INNER JOIN SETOR s ON s.IDSETOR = c.IDSETOR "
                 + "WHERE c.STATUS=?";
 
         List<CargoModel> listaCargos = null;
 
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
                 if (listaCargos == null) {
                     listaCargos = new ArrayList<>();
                 }
                 
                 SetorModel setor = new SetorModel();
                 setor.setIdSetor(result.getInt("IDSETOR"));
                 setor.setSetor_Nome(result.getString("SETOR_NOME"));
                 setor.setDescricao(result.getString("DESCRICAO"));
                 setor.setStatus(result.getBoolean("STATUS"));
 
                 CargoModel cargo = new CargoModel();
                 cargo.setIdCargo(result.getInt("IDCARGO"));
                 cargo.setSetor(setor);
                 cargo.setCargo_Nome(result.getString("CARGO_NOME"));
                 cargo.setDescricao(result.getString("DESCRICAO"));
                 cargo.setStatus(result.getBoolean("STATUS"));
                 
                 //Adiciona a instância na lista
                 listaCargos.add(cargo);
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
 
         return listaCargos;
     }
     
     public static List<CargoModel> procurar(String nome)
             throws SQLException, Exception {
         String sql = "SELECT * FROM CARGO c "
                 + "INNER JOIN SETOR s ON s.IDSETOR = c.IDSETOR "
                 + "WHERE UPPER(c.CARGO_NOME) LIKE UPPER(?) AND c.STATUS=?";
         
         //Lista de clientes de resultado
         List<CargoModel> listaCargos = null;
         
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
                 if (listaCargos == null) {
                     listaCargos = new ArrayList<>();
                 }
                        
                 SetorModel setor = new SetorModel();
                 setor.setIdSetor(result.getInt("IDSETOR"));
                 setor.setSetor_Nome(result.getString("SETOR_NOME"));
                 setor.setDescricao(result.getString("DESCRICAO"));
                 setor.setStatus(result.getBoolean("STATUS"));
 
                 CargoModel cargo = new CargoModel();
                 cargo.setIdCargo(result.getInt("IDCARGO"));
                 cargo.setSetor(setor);
                 cargo.setCargo_Nome(result.getString("CARGO_NOME"));
                 cargo.setDescricao(result.getString("DESCRICAO"));
                 cargo.setStatus(result.getBoolean("STATUS"));
                 
                 //Adiciona a instância na lista
                 listaCargos.add(cargo);
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
         
         return listaCargos;        
     }
 
     public static CargoModel obter(Integer id)
             throws SQLException, Exception {
 
         String sql = "SELECT * FROM CARGO c "
                 + "INNER JOIN SETOR s ON s.IDSETOR = c.IDSETOR "
                 + "WHERE c.IDCARGO=? AND c.STATUS=?";
 
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
                 SetorModel setor = new SetorModel();
                 setor.setIdSetor(result.getInt("IDSETOR"));
                 setor.setSetor_Nome(result.getString("SETOR_NOME"));
                 setor.setDescricao(result.getString("DESCRICAO"));
                 setor.setStatus(result.getBoolean("STATUS"));
 
                 CargoModel cargo = new CargoModel();
                 cargo.setIdCargo(result.getInt("IDCARGO"));
                 cargo.setSetor(setor);
                 cargo.setCargo_Nome(result.getString("CARGO_NOME"));
                 cargo.setDescricao(result.getString("DESCRICAO"));
                 cargo.setStatus(result.getBoolean("STATUS"));
                 
                 //Retorna o resultado
                 return cargo;
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
         String sql = "UPDATE CARGO SET STATUS=? WHERE IDCARGO=?";
         
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