package br.ufpb.lojasouleco;

import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GravadorDeProdutos {

    private String nomeArquivo;

    public GravadorDeProdutos() {
        this.nomeArquivo = "dados.txt";
    }

    public GravadorDeProdutos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void gravarProdutos(Collection<Produto> produtos) throws IOException{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            List<Produto> produtosAGravar = new ArrayList<>();
            produtosAGravar.addAll(produtos);
            out.writeObject(produtosAGravar);
        }catch(FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo "+nomeArquivo);
        }catch(IOException e){
            throw e;
        }finally{
            if(out != null){
                out.close();
            }
        }
    }

    public Collection<Produto> recuperarProdutos() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(nomeArquivo));
            Collection<Produto> produtosAchados = (Collection<Produto>) in.readObject();
            return produtosAchados;
        } catch (FileNotFoundException e) {
            throw new IOException("Não foi encontrado o arquivo " + nomeArquivo);
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe de objetos gravados no arquivo " + nomeArquivo);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}