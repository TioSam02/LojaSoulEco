package br.ufpb.lojasouleco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoulEco implements SistemaEco{
    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;
    private List<Venda> vendas;

    public SoulEco(){
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
        this.vendas = new ArrayList<>();

    }

    @Override
    public void cadastraProduto(Produto produto) throws ProdutoJaExisteException {

        if(this.produtos.containsKey(produto.getNome())){
            throw new ProdutoJaExisteException("Produto ja existente");
        }else{
            this.produtos.put(produto.getNome(), produto);
        }

    }

    @Override
    public void cadProdutoComVali(String nome, double preco, int quantidadeEmEstoque, boolean validade, int dia, int mes, int ano) throws ProdutoJaExisteException{

        ProdutoComValidade produto = new ProdutoComValidade(nome, preco, quantidadeEmEstoque, true, dia,mes,ano);
        this.produtos.put(produto.getNome(), produto);

    }

    @Override
    public void cadastraCliente(Cliente cliente) throws ClienteJaExisteException {
        if(this.clientes.containsKey(cliente.getCpf())){
            throw new ClienteJaExisteException(("Cliente já cadastrado"));
        }else {
            this.clientes.put(cliente.getCpf(), cliente);
        }

    }

    @Override
    public Produto pesquisarProduto(String nome) throws ProdutoNaoExisteException {

        if (produtos.containsKey(nome)) {

            return produtos.get(nome);
        }
        throw new ProdutoNaoExisteException("Não existe produto com o nome: "+ nome);
    }

    @Override
    public Collection<Produto> todosProdutos() {
        List<Produto> todosP = new ArrayList<>();

        for(Produto p: this.produtos.values()){
            todosP.add(p);
        }
        return todosP;
    }

    @Override
    public Collection<Cliente> pesquisarClientes(String nome) {
        List<Cliente> clientesNomesIguais = new ArrayList<>();

        for(Cliente c: this.clientes.values()){
            if(c.getNome().equals(nome)){
                clientesNomesIguais.add(c);
            }
        }
        return clientesNomesIguais;
    }

    @Override
    public Collection<Cliente> todosClientes() {
        List<Cliente> todosC = new ArrayList<>();

        for(Cliente c: this.clientes.values()){
            todosC.add(c);
        }

        return todosC;
    }

    @Override
    public List<Venda> todasAsVendas() {
        //TODO
        return null;
    }

    @Override
    public List<Venda> todasAsVendasDoDia() {
        //TODO
        return null;
    }

    @Override
    public List<Venda> todasAsVendasDoMes() {
        //TODO
        return null;
    }

    @Override
    public void removerCliente(String cpf) throws ClienteNaoExisteException{

        if(clientes.containsKey(cpf)){
            clientes.remove(cpf);
        }else{
            throw new ClienteNaoExisteException("Não existe cliente com o cpf "+cpf);
        }

    }

    @Override
    public void removerProduto(String nome) throws ProdutoNaoExisteException{

        if(produtos.containsKey(nome)){
            produtos.remove(nome);
        }else{
            throw new ProdutoNaoExisteException("Não existe produto com o nome "+nome);
        }

    }

    @Override
    public void setProdutos(Collection<Produto> produtosCollection) {
        for(Produto p: produtosCollection){
            this.produtos.put(p.getNome(), p);
        }

    }

    @Override
    public void setClientes(Collection<Cliente> clientesCollection) {
        for(Cliente c: clientesCollection){
            this.clientes.put(c.getCpf(), c);
        }
    }

    @Override
    public Collection<Produto> getProdutos() {
        return this.produtos.values();
    }

    @Override
    public Collection<Cliente> getClientes() {
        return this.clientes.values();

    }


}