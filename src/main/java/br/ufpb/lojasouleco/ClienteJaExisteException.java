package br.ufpb.lojasouleco;

public class ClienteJaExisteException extends Exception{
	private static final long serialVersionUID = 1L;

	public ClienteJaExisteException(String msg) {
		super(msg);
	}

}