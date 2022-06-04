/*
 * Nome da Classe: FormaDePagamento
 * 
 * Versão: 1.0
 *
 * Data: 04/07/2020
 * 
 * Código liberado pelo desenvolvedor.
 *
 * @author Erinaldo Henrique
 *
 */
package model;

public class FormaDePagamento {
    private int idFormaDePagamento;
    private String descricao;
    
    // Construtor
    public FormaDePagamento(){
        // Construtor padrão;
    }
    
    // Métodos get e set
    public int getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(int idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}