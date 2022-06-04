/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author henco
 */
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
