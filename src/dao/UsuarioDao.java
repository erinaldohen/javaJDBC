/*
 * Nome da Classe: UsuarioDao
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
package dao;

import conect.Conexao;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDao {
    
    // Construtor
    public UsuarioDao(){
        // Construtor padrão;
    }
    
    // Declaração dos métodos
    public static boolean validaLogin(String login, String senha) {
        boolean autenticado = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // Neste primeiro bloco será feita a criptografia do valor digitado no campo senha. 
        // Se não fizer este procedimento a validação vai comparar a senha do formulário (não criptografada) com a do banco (criptografada) e vai dar sempre incorreto.
        try {
                MessageDigest md = MessageDigest.getInstance("SHA-256"); // MessageDigest define o tipo de criptografia utilizada
                byte[] messageDigest = md.digest(senha.getBytes(StandardCharsets.UTF_8));
                
                StringBuilder sb = new StringBuilder();
                    for (byte b : messageDigest) {
                    sb.append(String.format("%02X", 0xFF & b));
                    }
                    senha = sb.toString();
                } catch (NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(null, "Erro de criptografia!", "Mensagem de Erro", 0);
            }
        
        String sql = "select * from usuario where login=? and senha=?";
        try {
            Connection con = Conexao.conectaBD();
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                //String Nome = rs.getString("nome");
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps, rs);
        }
        return autenticado;
    }
    
    public static void inserir(Usuario usuario){
        Connection con = Conexao.conectaBD();
        PreparedStatement ps = null;
        
        // Declaração da instrução sql
        String sql = "insert into usuario (login, senha) values (?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!"
                    , "Mensagem", 1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha na concexão! Os dados não"
                    + " foram inseridos no banco de dados!", "Mensagem de Erro",
                    0);
        } finally {
            // Chama o método que fecha a conexão e libera o recurso do PreparedStatement
            Conexao.fechaConexaoBD(ps); 
        }
    }
    
    public static void excluir(Usuario usuario){
        PreparedStatement ps = null;
        String sql = "delete from usuario where idUsuario = ?";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! Usuário não excluído!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
}