package br.ufpb.lojasouleco;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nome;
    private String cpf;
    private int cep;

    public Cliente(String nome,String cpf, int cep){
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
    }

    public Cliente(){
        this("","",0);
    }



    @Override
    public String toString() {
        return "Cliente: " +this.nome+ ", CPF: " +this.cpf+ ", Cep: "+this.cep;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getNome().equals(cliente.getNome()) && getCpf().equals(cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf());
    }
}