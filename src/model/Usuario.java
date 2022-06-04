/*
 * Nome da Classe: Usuario
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

public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;
    
    // Construtor
    public Usuario(){
        // Construtor padrão;
    }
    
    // Métodos get e set
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setId(int idUsuario) {
        this.idUsuario = idUsuario;
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