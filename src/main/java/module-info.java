module br.ufpb.lojasouleco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens br.ufpb.lojasouleco to javafx.fxml;
    exports br.ufpb.lojasouleco;
}