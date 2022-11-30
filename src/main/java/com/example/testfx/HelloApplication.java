package com.example.testfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        TableView<Alumno> tablaAlumnos = new TableView<>();
        tablaAlumnos.setEditable(true);
        TableColumn<Alumno, String> columnaNombre = new TableColumn<>("Nombre");
        columnaNombre.setMinWidth(300);
        //Para que en cada celda aparezca el atributo nombre de la clase Alumno
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Alumno, String> columnaApellidos = new TableColumn<>("Apellidos");
        columnaApellidos.setMinWidth(300);
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        TableColumn<Alumno, String> columnaEdad = new TableColumn<>("Edad");
        columnaEdad.setMinWidth(300);
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        //Añade las columnas al TableView
        tablaAlumnos.getColumns().addAll(columnaNombre,columnaApellidos,columnaEdad);

        ObservableList<Alumno> lista = FXCollections.observableArrayList();
        lista.add(new Alumno("Nombre 1", "Ape 1", 13));
        lista.add(new Alumno("Nombre 2", "Ape 2", 15));
        lista.add(new Alumno("Nombre 3", "Ape 3", 16));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tablaAlumnos.setItems(lista);

        VBox panelPrincipal = new VBox();
        panelPrincipal.getChildren().addAll(tablaAlumnos);
        Scene scene = new Scene(panelPrincipal);
        stage.setScene(scene);
        stage.show();

    }

    public void printConsola(String cad) {
        System.out.println("Hola " + cad);
    }

    public static void main(String[] args) {
        launch(args);

    }
}