package br.ufpb.lojasouleco;

import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GravadorDeClientes {

    private String arquivoClientes;

    public GravadorDeClientes() {
        this.arquivoClientes = "clientes.txt";
    }

    public GravadorDeClientes(String arquivoClientes) {
        this.arquivoClientes = arquivoClientes;
    }

    public void gravarClientes(Collection<Cliente> clientes) throws IOException {
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(arquivoClientes));
            List<Cliente> clientesAGravar = new ArrayList<>();
            clientesAGravar.addAll(clientes);
            out.writeObject(clientesAGravar);
        }catch(FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo "+arquivoClientes);
        }catch(IOException e){
            throw e;
        }finally{
            if(out != null){
                out.close();
            }
        }
    }

    public Collection<Cliente> recuperarClientes() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(arquivoClientes));
            Collection<Cliente> clientesAchados = (Collection<Cliente>) in.readObject();
            return clientesAchados;
        } catch (FileNotFoundException e) {
            throw new IOException("Não foi encontrado o arquivo " + arquivoClientes);
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe de objetos gravados no arquivo " + arquivoClientes);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
