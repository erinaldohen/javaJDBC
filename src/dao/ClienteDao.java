/*
 * Nome da Classe: ClienteDao
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Endereco;

public class ClienteDao {
    
    // Construtor 
    public ClienteDao(){
        // Construtor padrão;
    }
    
    public static void alterarCliente(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "update cliente set nome = ?, email = ?, telefone = ? where cpf = ?"; 
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getCpf());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Mensagem", 1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
    public static void alterarEnderecoCliente(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "update endereco set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ? where cliente_cpf = ?";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getEndereco().getLogradouro());
            ps.setInt(2, cliente.getEndereco().getNumero());
            ps.setString(3, cliente.getEndereco().getComplemento());
            ps.setString(4, cliente.getEndereco().getBairro());
            ps.setString(5, cliente.getEndereco().getCidade());
            ps.setString(6, cliente.getEndereco().getUf());
            ps.setString(7, cliente.getEndereco().getCep());
            ps.setString(8, cliente.getEndereco().getClienteCpf());
            ps.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão do Endereço!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
    // Métodos
    public static void cadastrar(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "insert into cliente (cpf, nome, email, telefone) values (?, ?, ?, ?)"; 
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Mensagem", 1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
    public static void cadastrarEnderecoCliente(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "insert into endereco (logradouro, numero, complemento, bairro, cidade, uf, cep, cliente_cpf) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getEndereco().getLogradouro());
            ps.setInt(2, cliente.getEndereco().getNumero());
            ps.setString(3, cliente.getEndereco().getComplemento());
            ps.setString(4, cliente.getEndereco().getBairro());
            ps.setString(5, cliente.getEndereco().getCidade());
            ps.setString(6, cliente.getEndereco().getUf());
            ps.setString(7, cliente.getEndereco().getCep());
            ps.setString(8, cliente.getEndereco().getClienteCpf());
            ps.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão do Endereço!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
    // Método que consulta todos os clientes cadastrados no banco de dados
    public static ArrayList<Cliente> consultar(){
        ArrayList<Cliente> clientes = new ArrayList<>(); // Cria o ArrayList para armazenar todos os clientes cadastrados no banco de dados
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cliente";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                // Adiciona um valor ao ArrayList passando como parâmetro um novo objeto de Cliente chamando o construtor personalizado
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! A consulta não pode ser exibida!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps, rs);
        }
        
        return clientes;
    }
    
    // Método que consulta todos os endereços dos clientes cadastrados no banco de dados
    public static ArrayList<Cliente> consultaCompleta(){
        ArrayList<Cliente> clientes = new ArrayList<>(); // Cria o ArrayList para armazenar todos os clientes cadastrados no banco de dados
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cliente inner join endereco on cliente.cpf = endereco.Cliente_cpf"; // Faz um select em duas tabelas simultaneamente quando elas referenciam a mesma coluna como PK e FK
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            rs = ps.executeQuery();
         
            while(rs.next()){
                // Armazenar os dados do endereço num objeto Endereço
                Endereco endereco = new Endereco(rs.getString("logradouro"), rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"), rs.getString("cep"));
                
                // Armazena os dados do cliente num objeto cliente acrescentando o endereço do cliente                                    // aqui é a referência ao endereço do cliente. Um objeto endereco
                Cliente cliente = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), endereco);                
                // Adiciona ao ArrayList um objeto de Cliente
                clientes.add(cliente);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! A consulta não pode ser exibida!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps, rs);
        }
        
        return clientes;
    }
    
    // Método que consulta pelo nome do cliente
    public static ArrayList<Cliente> consultar(Cliente cliente){
        ArrayList<Cliente> clientes = new ArrayList<>(); // Cria o ArrayList para armazenar todos os clientes cadastrados no banco de dados
        PreparedStatement ps = null;
        ResultSet rs = null;
        String valor = cliente.getCpf();
        String sql = "select * from cliente where nome like '%"+ valor +"%'";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                // Adiciona um valor ao ArrayList passando como parâmetro um novo objeto de Cliente chamando o construtor personalizado
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! A consulta não pode ser exibida!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps, rs);
        }
        
        return clientes;
    }
    
    
    // Método que retorna true se o cpf informado já estiver cadastrado
    public static boolean verificaCpfCadastrado(Cliente cliente){
        boolean autentica = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cliente where cpf = ?";
        
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            rs = ps.executeQuery();
            
            if (rs.next()){
                autentica = true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps, rs);
        }
        return autentica;
    }
    
    public static void excluirCliente(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "delete from cliente where cpf = ?";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Mensagem", 1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! Cliente não excluído!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
    public static void excluirEnderecoCliente(Cliente cliente){
        PreparedStatement ps = null;
        String sql = "delete from endereco where Cliente_cpf = ?";
        try {
            ps = Conexao.conectaBD().prepareStatement(sql);
            ps.setString(1, cliente.getEndereco().getClienteCpf());
            ps.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão! Endeceço não excluído!", "Mensagem de Erro", 0);
        } finally {
            Conexao.fechaConexaoBD(ps);
        }
    }
    
}