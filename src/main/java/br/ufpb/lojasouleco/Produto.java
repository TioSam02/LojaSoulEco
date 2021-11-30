package br.ufpb.lojasouleco;

import java.io.Serializable;


public class Produto implements Serializable{
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private boolean validade;

    public Produto(String nome, double preco, int quantidadeEmEstoque, boolean validade){
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.validade = validade;
    }

    public Produto(){
        this("", 0.0, 0, false);
    }

    public Produto(String nome){
        this(nome, 0,0, false);
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Nome: ");
        stringBuffer.append(this.nome);
        stringBuffer.append("\nPreço: ");
        stringBuffer.append(this.preco);
        stringBuffer.append(" \nQuantidade em estoque: ");
        stringBuffer.append(this.quantidadeEmEstoque);
        stringBuffer.append(" \nTem validade: ");
        stringBuffer.append(this.validade);

        return stringBuffer.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean isValidade() {
        return validade;
    }

    public void setValidade(boolean validade) {
        this.validade = validade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}