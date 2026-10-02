package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controlador asociado a la vista de resultados ('viewB.fxml').
 * Su función principal es mostrar el mensaje de bienvenida dinámico leyendo
 * las variables estáticas de 'Main' y permitir el regreso al formulario.
 */
public class ControllerVistaB {

    // =========================================================================
    // === COMPONENTES DE LA INTERFAZ (VINCULADOS CON EL FXML) ===
    // =========================================================================
    // La anotación @FXML vincula esta variable con la etiqueta de texto del archivo FXML.
    // Es obligatorio que el nombre coincida exactamente con el 'fx:id="lblMissatge"' del FXML.
    @FXML private Label lblMissatge;

    /**
     * Método del ciclo de vida de JavaFX. Se ejecuta automáticamente una sola vez
     * cuando 'UtilsViews' carga el FXML en memoria al arrancar la aplicación.
     */
    @FXML
    public void initialize() {
        // En este momento inicial no hacemos nada porque las variables del 'Main'
        // todavía están vacías. El texto se mantiene como venga por defecto en el FXML.
    }

    /**
     * MÈTODE PERSONALIZADO: Es invocado externamente por 'ControllerVistaA'
     * justo antes de cambiar de pantalla para inyectar los datos en la interfaz.
     */
    public void actualitzarDades() {
        // PROTECCIÓN: Verificamos que la etiqueta gráfica esté correctamente vinculada en memoria
        // para evitar un fallo crítico (NullPointerException).
        if (lblMissatge != null) {
            
            // Reemplazamos el texto de la etiqueta en pantalla.
            // Concatenamos las cadenas de texto accediendo de forma directa
            // a las variables globales y estáticas 'Main.nom' y 'Main.edat'.
            lblMissatge.setText("Hola " + Main.nom + ", tens " + Main.edat + " anys!");
        }
    }

    /**
     * Método que se ejecuta automáticamente cuando el usuario hace clic en el botón "Tornar"
     * (configurado en el FXML mediante la propiedad onAction="#tornarEnrere").
     */
    @FXML
    public void tornarEnrere() {
        // Llama al gestor de pantallas para ocultar la vista actual ("ViewB")
        // y volver a hacer visible el formulario inicial ("ViewA").
        UtilsViews.setView("ViewA");
    }
}
