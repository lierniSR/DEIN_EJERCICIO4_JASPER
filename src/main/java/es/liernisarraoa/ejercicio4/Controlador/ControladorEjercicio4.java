package es.liernisarraoa.ejercicio4.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ControladorEjercicio4 {
    @FXML
    public TextField txtfNumeroPaciente;
    @FXML
    public TextField txtfNombrePaciente;
    @FXML
    public TextField txtfDireccionPaciente;
    @FXML
    public TextField txtfCodigoMedico;
    @FXML
    public TextField txtfNombreMedico;
    @FXML
    public TextField txtfEspecialidadMedico;
    @FXML
    public TextArea txtaTratamientos;
    @FXML
    public Button btnGenerarInforme;
    @FXML
    public Button btnLImpiar;
    @FXML
    public Button btnSalir;

    public void salirPrograma(ActionEvent actionEvent) {
        // Obtener el Stage actual y cerrarlo
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    public void limpiarFormulario(ActionEvent actionEvent) {
        txtfNumeroPaciente.setText("");
        txtfNombrePaciente.setText("");
        txtfDireccionPaciente.setText("");
        txtfCodigoMedico.setText("");
        txtfNombreMedico.setText("");
        txtfEspecialidadMedico.setText("");
        txtaTratamientos.setText("");
    }

    public void generarInforme(ActionEvent actionEvent) {
        LocalDate fechaActual = LocalDate.now();
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio4\\src\\main\\resources\\es\\liernisarraoa\\ejercicio4\\Jasper\\FormularioMedico.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("NumeroPaciente", txtfNumeroPaciente.getText());
            parametros.put("NombrePaciente", txtfNombrePaciente.getText());
            parametros.put("DireccionPaciente", txtfDireccionPaciente.getText());
            parametros.put("NumeroMedico", txtfCodigoMedico.getText());
            parametros.put("NombreMedico", txtfNombreMedico.getText());
            parametros.put("EspecialidadMedico", txtfEspecialidadMedico.getText());
            parametros.put("Tratamientos", txtaTratamientos.getText());
            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);
            Log.info("Se ha generado el informe sobre el prestamo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}