/*
 * Nome da Classe: Teste
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

package model;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        // Armazenar os dados obtidos do formulário num objeto Cliente
        cliente.setCpf("cpf");
        cliente.setNome("nome");
        cliente.setEmail("email");
        cliente.setTelefone("telefone");
        endereco.setLogradouro("logradouro");
        endereco.setNumero(123);
        endereco.setComplemento("complemento");
        endereco.setBairro("bairro");
        endereco.setCidade("cidade");
        endereco.setUf("uf");
        endereco.setCep("cep");
        
        cliente.setEndereco(endereco);
        
        System.out.println(cliente.getEndereco().getLogradouro());
    }
}
