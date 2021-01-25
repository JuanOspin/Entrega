package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ArrayList<Trabajador> listaUsuarios;
    Trabajador trActual;
    Trabajador nuevoUsu;
    boolean ingCorrecto = false;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void pressExit(ActionEvent event) {
        System.exit(0);
    }

    public void Menu(ActionEvent event) throws Exception {

        Parent blah = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }

    public void validate(ActionEvent event) throws Exception {
        String name = username.getText();
        String pass = password.getText();

        if (name.isEmpty() || pass.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Porfavor rellene los requerimientos");
            alert.showAndWait();
        } else {
            for (Trabajador tr : listaUsuarios) {
                if (tr.getUsuario().equals(name) && tr.getContrasena().equals(pass)) {
                    trActual = tr;
                    ingCorrecto = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Login Success");
                    alert.showAndWait();

                    desicion(event);
                    Menu(event);
                }
            }
            if (!ingCorrecto) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Su usuario y/o contraseña son erradas");
                alert.showAndWait();
            }
        }

    }

    public void desicion(ActionEvent event) throws Exception {
        if (trActual.isGerente()) {
            boolean correcto = false;
            int opcion = 0;
            do {
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "**\nHola Gerente, desea crear un nuevo usuario?\n1.- Si" +

                            "\n2.- No" +

                            "\n**"));
                    if(opcion == 1 || opcion == 2){
                        correcto = true;
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Escriba un numero valido.");
                        alert.showAndWait();
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Escriba un numero valido.");
                    alert.showAndWait();
                }
            } while (!correcto);
            if(opcion == 1){
                boolean corr = false;
                do {
                    String usua = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario:");
                    String contra = JOptionPane.showInputDialog(null, "Ingrese la contraseña:");
                    if (usua.isEmpty() || contra.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Rellene todos los campos.");
                        alert.showAndWait();
                    }else {
                        boolean exis = false;
                        for (Trabajador tra : listaUsuarios) {
                            if(tra.getUsuario().equals(usua) || tra.getContrasena().equals(contra)){
                                exis = true;
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("El usuario o contraseña ya existen.");
                                alert.showAndWait();
                            }
                        }
                        if(!exis){
                            corr = true;
                            nuevoUsu = new Trabajador(false, usua, contra);
                            listaUsuarios.add(nuevoUsu);
                            guardarUsuario(event);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText("Usuario creado.");
                            alert.showAndWait();
                        }
                    }
                }while (!corr);
            }
        }
    }

    public void guardarUsuario(ActionEvent event)throws Exception{
        PrintWriter Salida = new PrintWriter(new FileWriter("Usuarios.txt",true));
        Salida.println(nuevoUsu.isGerente() + ":" + nuevoUsu.getUsuario() + ":" + nuevoUsu.getContrasena());
        Salida.close();
    }

    public void instanciarUsuarios() throws Exception{
        listaUsuarios = new ArrayList<Trabajador>();
        BufferedReader Entrada = new BufferedReader(new FileReader("Usuarios.txt"));
        String txtActual;
        boolean gerente = true;
        txtActual = Entrada.readLine();
        do {
            String[]info = txtActual.split(":");
            listaUsuarios.add(new Trabajador(gerente, info[1], info[2]));
            txtActual = Entrada.readLine();
            gerente = false;
        }while (txtActual != null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            instanciarUsuarios();
        }catch (Exception e){

        }
    }
}
