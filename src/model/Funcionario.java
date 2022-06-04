/*
 * Nome da Classe: Funcionario
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

public class Funcionario {
    private int idFuncionario;
    private String cpf;
    private String nome;
    private Funcao funcao;
    private String email;
    private String telefone;
    private String login;
    private String senha;
    
    // Construtor
    public Funcionario(){
        // Construtor padrão;
    }
    
    // Métodos get e set
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}