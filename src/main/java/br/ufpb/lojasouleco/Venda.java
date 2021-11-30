package br.ufpb.lojasouleco;


public class Venda {
    private int diaDaVenda;
    private int mesDaVenda;
    private Produto produto;
    private Cliente cliente;

    public Venda(int diaDaVenda, int mesDaVenda, Produto produto, Cliente cliente){

        this.diaDaVenda = diaDaVenda;
        this.mesDaVenda = mesDaVenda;
        this.cliente = cliente;
        this.produto = produto;
    }
    public Venda (){
        this(00,00, null, null);
    }


    @Override
    public String toString() {
        return "Dia da venda = "+ diaDaVenda +", Mes da venda = "+ mesDaVenda +", Produto vendido = "+ this.produto+", Cliente que comprou = "+cliente;
    }

    public int getDiaDaVenda() {
        return diaDaVenda;
    }

    public void setDiaDaVenda(int diaDaVenda) {
        this.diaDaVenda = diaDaVenda;
    }

    public int getMesDaVenda() {
        return mesDaVenda;
    }

    public void setMesDaVenda(int mesDaVenda) {
        this.mesDaVenda = mesDaVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}