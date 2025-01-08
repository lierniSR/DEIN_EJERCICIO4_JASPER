module es.liernisarraoa.ejercicio4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.ejercicio4 to javafx.fxml;
    exports es.liernisarraoa.ejercicio4;
}