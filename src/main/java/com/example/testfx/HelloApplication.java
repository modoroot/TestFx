package com.example.testfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TableView<Alumno> tablaAlumnos = new TableView<Alumno>();
        tablaAlumnos.setEditable(true);
        TableColumn<Alumno,String>columnaNombre = new TableColumn<Alumno, String>("Nombre");
        columnaNombre.setMinWidth(300);
        //Para que en cada celda aparezca el atributo nombre de la clase Alumno
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));

        TableColumn<Alumno,String>columnaApellidos = new TableColumn<Alumno, String>("Apellidos");
        columnaNombre.setMinWidth(300);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellidos"));

        TableColumn<Alumno,String>columnaEdad = new TableColumn<Alumno, String>("Edad");
        columnaNombre.setMinWidth(300);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("edad"));
        //Añade las columnas al TableView
        tablaAlumnos.getColumns().addAll(columnaNombre,columnaApellidos,columnaEdad);

        ObservableList<Alumno> lista = FXCollections.observableArrayList();
        lista.add(new Alumno());
        lista.add(new Alumno());
        lista.add(new Alumno());
        tablaAlumnos.setItems(lista);

        VBox panelPrincipal = new VBox();
        panelPrincipal.getChildren().addAll(tablaAlumnos);
        Scene scene = new Scene(panelPrincipal);
        stage.setScene(scene);
        stage.show();
//        Button bt1 = new Button("OK");
//        Label etiqueta1 = new Label("Nombre: ");
//        TextField tf1 = new TextField();
//
//        VBox paneVertical  =new VBox();
//        HBox h1 = new HBox();
//
//        h1.getChildren().addAll(etiqueta1,tf1);
//        paneVertical.getChildren().addAll(bt1,h1);
//
//        Scene scene = new Scene(paneVertical,400,400);
//        stage.setScene(scene);
//        stage.show();
////        bt1.setOnAction(e->printConsola(tf1.getText()));

    }
    public void printConsola(String cad){
        System.out.println("Hola "+cad);
    }

    public static void main(String[] args) {
        launch(args);

    }
}