package br.ufpb.lojasouleco;

public class ProdutoJaExisteException extends Exception{
	private static final long serialVersionUID = 1L;

	public ProdutoJaExisteException(String msg) {
		super(msg);
	}
}