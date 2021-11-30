package br.ufpb.lojasouleco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EcoController implements Initializable {
    @FXML
    private Button botaoCancelar;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView arvoreImageView;
    @FXML
    private ImageView iconImageView;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField senhaField;

    public void loginButtonOnAction (ActionEvent event){
        if(!usuarioTextField.getText().isBlank() && !senhaField.getText().isBlank()){
            validarLogin();
        }else{
            loginMessageLabel.setText("Por favor coloque um usuário e senha");
        }
    }
    public void cancelButtonOnAction(){
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceTree ) {
        File arvoreFile = new File("imgs/arvoreGrande.jpg");
        Image arvoreImage = new Image(arvoreFile.toURI().toString());
        arvoreImageView.setImage(arvoreImage);

        File iconFile = new File("imgs/arvoreIcon.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        iconImageView.setImage(iconImage);
    }

    public void validarLogin(){
        if(usuarioTextField.getText().equals("admin") && senhaField.getText().equals("admin")){
            ecoPainelPrincipal();
        }else{
            loginMessageLabel.setText("Usuario ou senha está errado. Por favo tente novamente");
        }

    }
    public void ecoPainelPrincipal(){

        try{
            Parent janela2 = FXMLLoader.load(getClass().getResource("ecoPainel.fxml"));
            Stage principalStage = new Stage();

            principalStage.initStyle(StageStyle.UNDECORATED);
            principalStage.setResizable(false);
            principalStage.setScene(new Scene(janela2, 1022, 741));
            principalStage.show();

            Stage stage = (Stage) botaoCancelar.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}