package br.ufpb.lojasouleco;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class PainelEco implements Initializable {

    private GravadorDeProdutos gravadorProduto = new GravadorDeProdutos();
    private GravadorDeClientes gravadorCliente = new GravadorDeClientes();
    private SistemaEco eco = new SoulEco();

    @FXML
    private Label menu;
    @FXML
    private Label menuClose;
    @FXML
    private Label cadProdutoMessageLabel;
    @FXML
    private Label salvarMessageLabel;
    @FXML
    private Label salvarClienteMessageLabel;
    @FXML
    private Label resultadoPesMessageLabel;
    @FXML
    private Label resulPesClienteMessageLabel;
    @FXML
    private Label removerMessageLabel;
    @FXML
    private Label removerUserMessageLabel;
    @FXML
    private Label cadClienteMessageLabel;
    @FXML
    private Label homeMessageLabel;
    @FXML
    private VBox slider;
    @FXML
    private TextField nomeCadProduto;
    @FXML
    private TextField precoCadProduto;
    @FXML
    private TextField quantidadeCadProduto;
    @FXML
    private TextField produtoPesField;
    @FXML
    private TextField clientePesTextField;
    @FXML
    private TextField removerUserField;
    @FXML
    private TextField removerProdutoField;
    @FXML
    private TextField nomeClienteTextField;
    @FXML
    private TextField cpfClienteTextField;
    @FXML
    private TextField cepClienteTextField;
    @FXML
    private ImageView addCadProdutoIcon;
    @FXML
    private ImageView addUserIcon;
    @FXML
    private ImageView pesUserIcon;
    @FXML
    private ImageView removerUserIcon;
    @FXML
    private ImageView salvarUserIcon;
    @FXML
    private ImageView salvarClienteIcon2;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView addIcon;
    @FXML
    private ImageView pesquisarIcon;
    @FXML
    private ImageView removerIcon;
    @FXML
    private ImageView salvarIcon;
    @FXML
    private ImageView arvoreIcon;
    @FXML
    private ImageView fecharIcon;
    @FXML
    private ImageView pesquisarIcon2;
    @FXML
    private ImageView pesquisarClienteIcon2;
    @FXML
    private ImageView removerIcon2;
    @FXML
    private ImageView removerUserIcon2;
    @FXML
    private ImageView addCadClienteIcon2;
    @FXML
    private Button btnFechar;
    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnPesUser;
    @FXML
    private Button btnRemoverUser;
    @FXML
    private Button btnSalvarUser;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnPesquisar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnHome;
    @FXML
    private Pane pnlSalvar;
    @FXML
    private GridPane pnlCadProduto;
    @FXML
    private AnchorPane pnlPesquisaProduto;
    @FXML
    private AnchorPane pnlPesquisaCliente;
    @FXML
    private AnchorPane pnlRemoverProduto;
    @FXML
    private AnchorPane pnlRemoverUser;
    @FXML
    private AnchorPane pnlSalvarCliente;
    @FXML
    private GridPane pnlCadCliente;
    @FXML
    private ScrollPane pnlHome;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("#####initialize#####");
        try{
            Collection<Produto> produtosRecuperados = gravadorProduto.recuperarProdutos();
            Collection<Cliente> clientesRecuperados = gravadorCliente.recuperarClientes();
            eco.setProdutos(produtosRecuperados);
            eco.setClientes(clientesRecuperados);
        }catch(IOException e){
            e.printStackTrace();
            e.getCause();
        }

        File arvoreFile = new File("imgs/arvoreIcon.png");
        Image arvoreImage = new Image(arvoreFile.toURI().toString());
        arvoreIcon.setImage(arvoreImage);

        File fecharFile = new File("imgs/cancelRe.png");
        Image fecharImage = new Image(fecharFile.toURI().toString());
        fecharIcon.setImage(fecharImage);

        File homeFile = new File("imgs/homeB2.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeIcon.setImage(homeImage);

        File addFile = new File("imgs/addBlack.png");
        Image addImage = new Image(addFile.toURI().toString());
        addIcon.setImage(addImage);

        File addCadProdutoFile = new File("imgs/add.png");
        Image addCadProdutoImage = new Image(addCadProdutoFile.toURI().toString());
        addCadProdutoIcon.setImage(addCadProdutoImage);

        File addUserFile = new File("imgs/addUserW.png");
        Image addUserImage = new Image(addUserFile.toURI().toString());
        addUserIcon.setImage(addUserImage);

        File addCadCliente2File = new File("imgs/addUserW.png");
        Image addCadCliente2Image = new Image(addCadCliente2File.toURI().toString());
        addCadClienteIcon2.setImage(addCadCliente2Image);

        File pesquisarFile = new File("imgs/searchB.png");
        Image pesquisarImage = new Image(pesquisarFile.toURI().toString());
        pesquisarIcon.setImage(pesquisarImage);

        File pesquisar2File = new File("imgs/searchW.png");
        Image pesquisar2Image = new Image(pesquisar2File.toURI().toString());
        pesquisarIcon2.setImage(pesquisar2Image);

        File pesUserFile = new File("imgs/searchUserW.png");
        Image pesUserImage = new Image(pesUserFile.toURI().toString());
        pesUserIcon.setImage(pesUserImage);

        File pesClienteFile = new File("imgs/searchUserW.png");
        Image pesClienteImage = new Image(pesClienteFile.toURI().toString());
        pesquisarClienteIcon2.setImage(pesClienteImage);

        File removerFile = new File("imgs/removeB.png");
        Image removerImage = new Image(removerFile.toURI().toString());
        removerIcon.setImage(removerImage);

        File remover2File = new File("imgs/removeW.png");
        Image remover2Image = new Image(remover2File.toURI().toString());
        removerIcon2.setImage(remover2Image);

        File removerUserFile = new File("imgs/removeW.png");
        Image removerUserImage = new Image(removerUserFile.toURI().toString());
        removerUserIcon.setImage(removerUserImage);

        File removerUser2File = new File("imgs/removeW.png");
        Image removerUser2Image = new Image(removerUser2File.toURI().toString());
        removerUserIcon2.setImage(removerUser2Image);

        File salvarFile = new File("imgs/databaseB-24.png");
        Image salvarImage = new Image(salvarFile.toURI().toString());
        salvarIcon.setImage(salvarImage);

        File salvarUserFile = new File("imgs/database-24.png");
        Image salvarUserImage = new Image(salvarUserFile.toURI().toString());
        salvarUserIcon.setImage(salvarUserImage);

        File salvarCliente2File = new File("imgs/database-24.png");
        Image salvarCliente2Image = new Image(salvarCliente2File.toURI().toString());
        salvarClienteIcon2.setImage(salvarCliente2Image);


        slider.setTranslateX(-209);
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-209);

            slide.setOnFinished((ActionEvent e)->{
                menu.setVisible(false);
                menuClose.setVisible(true);
            });
        });
        menuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider);

            slide.setToX(-209);
            slide.play();

            slider.setTranslateX(-209);

            slide.setOnFinished((ActionEvent e)->{
                menu.setVisible(true);
                menuClose.setVisible(false);
            });
        });

    }


    public void CadProdutoButtonOnAction (ActionEvent event){

        if (!nomeCadProduto.getText().isBlank() && !precoCadProduto.getText().isBlank() &&!quantidadeCadProduto.getText().isBlank() ) {
            String precoString = precoCadProduto.getText();
            float precoFloat = Float.parseFloat(precoString);
            String quantString = quantidadeCadProduto.getText();
            int quantInt = Integer.parseInt(quantString);

            Produto produto = new Produto(nomeCadProduto.getText(), precoFloat, quantInt, false);
            try {
                eco.cadastraProduto(produto);
                cadProdutoMessageLabel.setText("Produto cadastrado com sucesso");
            } catch (ProdutoJaExisteException e) {
                cadProdutoMessageLabel.setText("Não foi possível cadastrar produto");
            }
        } else {
            cadProdutoMessageLabel.setText("Por favor revise as informações do produto");
        }
    }
    public void CadClienteButtonOnAction (ActionEvent event){

        if (!nomeClienteTextField.getText().isBlank() && !cpfClienteTextField.getText().isBlank() && !cepClienteTextField.getText().isBlank()) {
            String cpfString = cpfClienteTextField.getText();
            int cpf = Integer.parseInt(cpfString);
            String cepString = cepClienteTextField.getText();
            int cep = Integer.parseInt(cepString);

            Cliente cliente = new Cliente(nomeCadProduto.getText(), cpf, cep);
            try {
                eco.cadastraCliente(cliente);
                cadClienteMessageLabel.setText("Cliente cadastrado com sucesso");
            } catch (ClienteJaExisteException e) {
                cadClienteMessageLabel.setText("Não foi possível cadastrar Cliente");
            }
        } else {
            cadClienteMessageLabel.setText("Por favor revise as informações do cliente");
        }
    }
    public void salvarButtonOnAction(ActionEvent event){
        pnlSalvar.toFront();

        try {
            gravadorProduto.gravarProdutos(eco.getProdutos());
            salvarMessageLabel.setText("Produtos salvos com sucesso");

        } catch (IOException e) {
            salvarMessageLabel.setText("Problema ao salvar produtos");
            e.printStackTrace();

        }
    }
    public void salvarClienteButtonOnAction(ActionEvent event){

        try {
            gravadorCliente.gravarClientes(eco.getClientes());
            salvarClienteMessageLabel.setText("Clientes salvos com sucesso");

        } catch (IOException e) {
            salvarClienteMessageLabel.setText("Problema ao salvar clientes");
            e.printStackTrace();

        }
    }
    public void PesquisarProdutoButtonOnAction(ActionEvent event){
        try {
            Produto produto = eco.pesquisarProduto(produtoPesField.getText());
            resultadoPesMessageLabel.setText(produto.toString());
        } catch (ProdutoNaoExisteException e) {
            resultadoPesMessageLabel.setText("Não existe produto com esse nome");
        }
    }
    public void PesquisarClienteButtonOnAction(ActionEvent event) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Collection<Cliente> clientesNomesIguais = eco.pesquisarClientes(clientePesTextField.getText());
            for(Cliente c : clientesNomesIguais){
                stringBuffer.append("Nome: ");
                stringBuffer.append(c.getNome());
                stringBuffer.append(", CPF: ");
                stringBuffer.append(c.getCpf());
                stringBuffer.append(", Cep: ");
                stringBuffer.append(c.getCep());
                stringBuffer.append("\n");

            }
            resulPesClienteMessageLabel.setText(stringBuffer.toString());

        } catch (ClienteNaoExisteException e) {
            resulPesClienteMessageLabel.setText("Não existe cliente com esse nome");
        }
    }
    public void RemoverProdutoButtonOnAction(ActionEvent event){
        try {
            eco.removerProduto(removerProdutoField.getText());
            removerMessageLabel.setText("SUCESSO!");
        } catch (ProdutoNaoExisteException e) {
            e.printStackTrace();
            removerMessageLabel.setText("Não existe produto com esse nome "+produtoPesField.getText());
        }
    }
    public void RemoverUserButtonOnAction(ActionEvent event){
        String cpfString = removerUserField.getText();
        int cpf = Integer.parseInt(cpfString);
        try {
            eco.removerCliente(cpf);
            removerUserMessageLabel.setText("SUCESSO!");
        } catch (ClienteNaoExisteException e) {
            removerUserMessageLabel.setText("Não existe cliente com esse cpf");
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        System.exit(0);
        Platform.exit();
    }
    @FXML
    private void handleClicks(ActionEvent event) {

        if (event.getSource() == btnAddUser) {
            pnlCadCliente.toFront();

        }else if (event.getSource() == btnPesUser) {
            pnlPesquisaCliente.toFront();

        }else if (event.getSource() == btnRemoverUser) {
            pnlRemoverUser.toFront();

        }else if (event.getSource() == btnSalvarUser) {
            pnlSalvarCliente.toFront();

        }else if (event.getSource() == btnAdd) {
            pnlCadProduto.toFront();

        }else if (event.getSource() == btnPesquisar) {
            pnlPesquisaProduto.toFront();

        }else if (event.getSource() == btnRemover) {
            pnlRemoverProduto.toFront();

        }else if (event.getSource() == btnHome) {
            pnlHome.toFront();
            StringBuffer stringBuffer = new StringBuffer();

            Collection<Produto> todosProdutos = eco.todosProdutos();
            for(Produto p : todosProdutos){
                stringBuffer.append("Nome: ");
                stringBuffer.append(p.getNome());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(p.getPreco());
                stringBuffer.append("\nQuantidade: ");
                stringBuffer.append(p.getQuantidadeEmEstoque());
                stringBuffer.append("\n");
                stringBuffer.append("-------------------------------------");
                stringBuffer.append("\n");
            }
            homeMessageLabel.setText(stringBuffer.toString());

        }
    }
}
