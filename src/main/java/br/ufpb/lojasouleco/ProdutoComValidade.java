package br.ufpb.lojasouleco;

public class ProdutoComValidade extends Produto{
    private int dia;
    private int mes;
    private int ano;

    public ProdutoComValidade(String nome, double preco, int quantidadeEmEstoque, boolean validade, int dia, int mes, int ano){
        super(nome, preco, quantidadeEmEstoque, validade);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "ValidadeProduto [ano=" + ano + ", dia=" + dia + ", mes=" + mes + "]";
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


}