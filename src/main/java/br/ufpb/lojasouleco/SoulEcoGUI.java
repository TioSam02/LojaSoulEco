package br.ufpb.lojasouleco;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SoulEcoGUI extends JFrame{

	private GravadorDeProdutos gravador;
	private SistemaEco eco;
	JLabel linha1, linha2;
	ImageIcon naturezaImg = new ImageIcon("./imgs/natureza.jpg");
	ImageIcon addImg = new ImageIcon("./imgs/add.png");
	ImageIcon pesqImg = new ImageIcon("./imgs/search.png");
	ImageIcon removeImg = new ImageIcon("./imgs/delete.png");
	ImageIcon saveImg = new ImageIcon("./imgs/download.png");
	JButton botaoAdicionar, botaoPesquisar, botaoRemover, botaoSalvar;

	public SoulEcoGUI(){
		gravador = new GravadorDeProdutos();
		eco = new SoulEco();

		try{
			Collection<Produto> produtosRecuperados = gravador.recuperarProdutos();
			eco.setProdutos(produtosRecuperados);
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso", "Sucesso!", JOptionPane.DEFAULT_OPTION);
		}
		setTitle("Sistema Eco");
		setSize(800,600);
		setLocation(150,150);
		setResizable(true);
		getContentPane().setBackground(Color.white);
		linha1 = new JLabel("Soul Eco!", JLabel.CENTER);
		linha1.setForeground(Color.green);
		linha1.setFont(new Font("Serif", Font.BOLD, 28));
		linha2 = new JLabel(naturezaImg, JLabel.CENTER);

		botaoAdicionar = new JButton("Adicionar",addImg);
		botaoAdicionar.addActionListener((ae) ->{
			this.setVisible(false);
			String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto", "cadastrar produto", JOptionPane.QUESTION_MESSAGE);
			double preco = Double.parseDouble(JOptionPane.showInputDialog(this,"Digite o preço do produto", "cadastrar produto", JOptionPane.QUESTION_MESSAGE));
			int emEstoque = Integer.parseInt(JOptionPane.showInputDialog(this,"Digite a quantidade do produto", "cadastrar produto", JOptionPane.QUESTION_MESSAGE));
			boolean validade = false;

			Produto produto = new Produto(nomeProduto, preco, emEstoque, validade);
			try {
				eco.cadastraProduto(produto);
				JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso", "Sucesso!", JOptionPane.DEFAULT_OPTION);
			} catch (ProdutoJaExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			this.setVisible(true);
		});

		botaoPesquisar = new JButton("Pesquisar", pesqImg);
		botaoPesquisar.addActionListener((ae) -> {
			this.setVisible(false);
			String nomeProduto = JOptionPane.showInputDialog(this,"Qual o nome do produto a pesquisar? ", "Pesquisar",JOptionPane.DEFAULT_OPTION);

			try {
				Produto produto = eco.pesquisarProduto(nomeProduto);
				JOptionPane.showMessageDialog(this, "Informações do produto: " + produto, "", JOptionPane.DEFAULT_OPTION);
			} catch (ProdutoNaoExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			this.setVisible(true);
		});

		botaoRemover = new JButton("Remover", removeImg);

		botaoSalvar = new JButton("Salvar", pesqImg);
		botaoSalvar.addActionListener((ae) -> {
			try {
				gravador.gravarProdutos(eco.getProdutos());
				JOptionPane.showMessageDialog(this,"Produtos salvos com sucesso");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,"Problema ao salvar produtos");
				e.printStackTrace();

			}
		});
		getContentPane().setLayout(new GridLayout(4,3));
		getContentPane().add(linha1);
		getContentPane().add(botaoAdicionar);
		getContentPane().add(linha2);
		getContentPane().add(botaoPesquisar);
		getContentPane().add(new JLabel());
		getContentPane().add(botaoRemover);
		getContentPane().add(botaoSalvar);

	}

	public static void main (String[] args) {
		JFrame janela = new SoulEcoGUI();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}