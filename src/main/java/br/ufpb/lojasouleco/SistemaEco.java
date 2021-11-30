package br.ufpb.lojasouleco;

import java.util.Collection;
import java.util.List;

public interface SistemaEco {

    public void cadastraProduto(Produto produto) throws ProdutoJaExisteException;

    public void cadProdutoComVali(String nome, double preco, int quantidadeEmEstoque, boolean validade, int dia, int mes, int ano) throws ProdutoJaExisteException;

    public void cadastraCliente(Cliente cliente) throws ClienteJaExisteException;

    public Produto pesquisarProduto(String nome) throws ProdutoNaoExisteException;

    public Collection<Produto> todosProdutos();

    public Collection<Cliente> pesquisarClientes(String nome) throws ClienteNaoExisteException;

    public Collection<Cliente> todosClientes();

    public List<Venda> todasAsVendas();

    public List<Venda> todasAsVendasDoDia();

    public List<Venda> todasAsVendasDoMes();

    public void removerCliente(int cpf) throws ClienteNaoExisteException;

    public void removerProduto(String nome) throws ProdutoNaoExisteException;

    public void setProdutos(Collection<Produto> produtosCollection);

    public void setClientes(Collection<Cliente> clientesCollection);

    public Collection<Produto> getProdutos();

    public Collection<Cliente> getClientes();
}

