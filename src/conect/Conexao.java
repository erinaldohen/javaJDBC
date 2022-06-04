/*
 * Nome da Classe: Conexao
 * 
 * Versão: 1.0
 *
 * Data: 08/07/2020
 * 
 * Código liberado pelo desenvolvedor.
 *
 * @author Erinaldo Henrique
 *
 */

package conect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    // Declaração de variáveis constantes
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String BD = "jdbc:mysql://localhost:3306/javadesktop";
    
    // Construtor
    public Conexao(){
        // Construtor padrão;
    }
    
    // Declaração dos métodos
    // Método para conectar ao banco de dados
    public static Connection conectaBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Declaração do driver JDBC
            return DriverManager.getConnection(BD, USER, PASSWORD); // Configurações de acesso ao banco de dados
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Mensagem de Erro", 0);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! Favor verificar as credenciais de acesso ao banco de dados!", "Mensagem de Erro", 0);
        }
        return null;
    }
    
    public static void fechaConexaoBD(){
        try {
            conectaBD().close(); // Método para fechar a conexão com o banco de dados
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível finalizar a conexão com o banco de dados!", "Mensagem de Erro", 0);
        }
    }
    
    public static void fechaConexaoBD(PreparedStatement ps){
        try {
            ps.close(); // Libera o recurso do PreparedStatment;
            conectaBD().close(); // Método para fechar a conexão com o banco de dados
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível finalizar a conexão com o banco de dados!", "Mensagem de Erro", 0);
        }
    }
    
    public static void fechaConexaoBD(PreparedStatement ps, ResultSet rs){
        try {
            rs.close(); // Libera o recurso do ResultSet;
            ps.close(); // Libera o recurso do PreparedStatment;
            conectaBD().close(); // Método para fechar a conexão com o banco de dados
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível finalizar a conexão com o banco de dados!", "Mensagem de Erro", 0);
        }
    }
}