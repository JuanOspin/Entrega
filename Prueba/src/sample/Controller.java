package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    String User = "Prueba";
    String Pass = "12";

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void pressExit (ActionEvent event) {
        System.exit(0);
    }
    public void Menu (ActionEvent event) throws Exception{
        Parent blah = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    public void validate(ActionEvent event) throws Exception {
        String name = username.getText();
        String pass = password.getText();

        if(name.isEmpty() || pass.isEmpty()){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Porfavor rellene los requerimientos");
            alert.showAndWait();
        }
        else if(name.equals(User) && pass.equals(Pass)){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Login Success");
            alert.showAndWait();

            Menu(event);
        }else{
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Su usuario y/o contraseña son erradas");
            alert.showAndWait();
        }

    }
    public void añadirProducto(ActionEvent event)throws Exception{
        Parent blah = FXMLLoader.load(getClass().getResource("AñadirProductos.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    public void eliminar (ActionEvent event)throws Exception{
        Parent blah = FXMLLoader.load(getClass().getResource("Eliminar.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
