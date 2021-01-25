package sample;

import com.sun.imageio.stream.StreamCloser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.URL;
import java.nio.channels.ClosedSelectorException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private TextField CodigoProducto;
    @FXML private TextField Objeto;
    @FXML private TextField Precio;
    @FXML private TextField Cantidad;

    @FXML private TableView<Producto> tableView;
    @FXML private TableColumn<Producto, String> CodigoProductoColumn;
    @FXML private TableColumn<Producto, String> ObjetoColumn;
    @FXML private TableColumn<Producto, String> PrecioColumn;
    @FXML private TableColumn<Producto, String> CantidadColumn;
    @FXML private TableColumn<Producto, LocalDate> UltIngresoColumn;

    public MenuController() throws IOException {

    }

    public void pressExit (ActionEvent event) throws IOException {
        System.exit(0);
    }

    public void añadirProducto(ActionEvent event)throws Exception {

        BufferedReader Entrada = new BufferedReader(new FileReader("DatosProducto.txt"));
        PrintWriter Salida = new PrintWriter(new FileWriter("DatosProducto.txt",true));

        if(CodigoProducto.getText().isEmpty() || Objeto.getText().isEmpty() || Precio.getText().isEmpty() || Cantidad.getText().isEmpty()) {
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Porfavor rellene los requerimientos");
            alert.showAndWait();
        } else{
            Producto newproducto = new Producto(CodigoProducto.getText(), Objeto.getText(), Precio.getText(), Cantidad.getText(), LocalDate.now());

            Salida.println(CodigoProducto.getText() + ":" + Objeto.getText() + ":" + Precio.getText() + ":" + Cantidad.getText() + ":" + LocalDate.now());
            Entrada.close();
            Salida.close();

            tableView.getItems().add(newproducto);
        }
    }
    public void eliminar (ActionEvent  event)throws Exception{
        ObservableList<Producto> selectedRows, allProductos;
        allProductos = tableView.getItems();

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (Producto producto: selectedRows)
        {
            allProductos.remove(producto);
        }
        RefrescarTabla(allProductos);
    }
    public void RefrescarTabla (ObservableList<Producto> P) throws IOException {
        PrintWriter nuevo = new PrintWriter(new FileWriter("DatosProducto.txt",false));

        for (Producto producto: P)
        {
            String datosProducto = producto.getCodigoProducto()+ ":" + producto.getObjeto() + ":" + producto.getPrecio() + ":" +producto.getCantidad() + ":" + producto.getUltIngreso();
            nuevo.println(datosProducto);

        }
        nuevo.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CodigoProductoColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("codigoProducto"));
        PrecioColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));
        PrecioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PrecioColumn.setOnEditCommit(data-> {
            System.out.println("Nuevo Precio: " +  data.getNewValue());
            System.out.println("Antiguo Precio: " + data.getOldValue());

            Producto p = data.getRowValue();
            p.setPrecio(data.getNewValue());


            try {
                RefrescarTabla(tableView.getItems());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(p);

        });
        ObjetoColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("objeto"));
        ObjetoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ObjetoColumn.setOnEditCommit(data-> {
            System.out.println("Nuevo Objeto: " +  data.getNewValue());
            System.out.println("Antiguo Objeto: " + data.getOldValue());

            Producto p = data.getRowValue();
            p.setObjeto(data.getNewValue());

            try {
                RefrescarTabla(tableView.getItems());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(p);
        });
        CantidadColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("cantidad"));
        CantidadColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CantidadColumn.setOnEditCommit(data-> {
            System.out.println("Nueva Cantidad: " +  data.getNewValue());
            System.out.println("Antigua Cantidad: " + data.getOldValue());

            Producto p = data.getRowValue();
            p.setCantidad(data.getNewValue());

            try {
                RefrescarTabla(tableView.getItems());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(p);
        });
        UltIngresoColumn.setCellValueFactory(new PropertyValueFactory<Producto, LocalDate>("ultIngreso"));

        tableView.setEditable(true);
        try {
            tableView.setItems(getInventario());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Producto> getInventario() throws IOException {
        ObservableList<Producto> Inventario =  FXCollections.observableArrayList();

        BufferedReader Entrada = new BufferedReader(new FileReader("DatosProducto.txt"));

        String itinerador;

        while((itinerador = Entrada.readLine()) != null){
          String[]info = itinerador.split(":");

          Inventario.add(new Producto(info[0], info[1], info[2], info[3], LocalDate.parse(info[4])));
        }

        return Inventario;

    }
}
