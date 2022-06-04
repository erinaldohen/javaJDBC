/*
 * Nome da Classe: PedidoDeCompra
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

public class PedidoDeCompra {
    private int idPedidoDeCompra;
    private Cliente cpf;
    private FormaDePagamento idFormaDePagamento;
    private Funcionario idFuncionario;
    
    // Construtor
    public PedidoDeCompra(){
        // Construtor padrão;
    }
    
    // Métodos get e set
    public int getIdPedidoDeCompra() {
        return idPedidoDeCompra;
    }

    public void setIdPedidoDeCompra(int idPedidoDeCompra) {
        this.idPedidoDeCompra = idPedidoDeCompra;
    }

    public Cliente getCpf() {
        return cpf;
    }

    public void setCpf(Cliente cpf) {
        this.cpf = cpf;
    }

    public FormaDePagamento getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(FormaDePagamento idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}