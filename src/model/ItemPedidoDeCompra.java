/*
 * Nome da Classe: ItemPedidoDeCompra
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

public class ItemPedidoDeCompra {
    private PedidoDeCompra idPedidoDeCompra;
    private int quantidade;
    private Produto idProduto;
    
    // Construtor
    public ItemPedidoDeCompra(){
        // Construtor padrão;
    }
    
    // Métodos get e set
    public PedidoDeCompra getIdPedidoDeCompra() {
        return idPedidoDeCompra;
    }

    public void setIdPedidoDeCompra(PedidoDeCompra idPedidoDeCompra) {
        this.idPedidoDeCompra = idPedidoDeCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }
    
}