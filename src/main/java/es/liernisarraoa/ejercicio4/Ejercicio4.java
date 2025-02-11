package es.liernisarraoa.ejercicio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio4 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ejercicio4.class.getResource("formularioMedico.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 642, 441);
        stage.setTitle("Formulario del medico!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}