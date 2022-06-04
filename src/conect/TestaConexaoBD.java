package conect;

import dao.ClienteDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Endereco;

public class TestaConexaoBD {
    public static void main(String[] args) {
        Conexao.fechaConexaoBD();
    }
}