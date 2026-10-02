package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controlador asociado a la vista del formulario ('viewA.fxml').
 * Se encarga de capturar el texto introducido por el usuario, validarlo,
 * guardarlo de forma global y dar la orden de cambiar de pantalla.
 */
public class ControllerVistaA {

    // =========================================================================
    // === COMPONENTES DE LA INTERFAZ (VINCULADOS CON EL FXML) ===
    // =========================================================================
    // La anotación @FXML conecta estas variables con los elementos visuales del archivo FXML.
    // Es obligatorio que el nombre de la variable coincida exactamente con el 'fx:id' asignado en el FXML.
    @FXML private TextField txtNom;   // Cuadro de texto donde el usuario escribe su nombre
    @FXML private TextField txtEdat;  // Cuadro de texto donde el usuario escribe su edad

    /**
     * Método que se ejecuta automáticamente cuando el usuario hace clic en el botón "Enviar"
     * (configurado en el FXML mediante la propiedad onAction="#enviarDades").
     */
    @FXML
    public void enviarDades() {
        // Capturamos el texto de los cuadros de entrada.
        // '.trim()' elimina de forma automática los espacios en blanco innecesarios al principio y al final.
        String nomIntroduit = txtNom.getText().trim();
        String edatIntroduida = txtEdat.getText().trim();

        // VALIDACIÓN: El bloque condicional solo se ejecuta si AMBOS campos contienen texto.
        // '!nomIntroduit.isEmpty()' significa "si el nombre NO está vacío".
        if (!nomIntroduit.isEmpty() && !edatIntroduida.isEmpty()) {
            
            // -----------------------------------------------------------------
            // 1. Guardamos los datos en las variables estáticas del Main
            // -----------------------------------------------------------------
            // Almacenamos los strings en la clase Main para cumplir con el requisito
            // del ejercicio de centralizar y compartir la información de forma estática.
            Main.nom = nomIntroduit;
            Main.edat = edatIntroduida;

            // -----------------------------------------------------------------
            // 2. Buscamos de forma segura el controlador de la segunda vista
            // -----------------------------------------------------------------
            // Usamos la utilidad 'getController' pasándole el ID "ViewB".
            // Como devuelve un objeto genérico ('Object'), le aplicamos un moldeado o casting 
            // '(ControllerVistaB)' para poder tratarlo específicamente como el controlador de la Vista B.
            ControllerVistaB ctrlB = (ControllerVistaB) UtilsViews.getController("ViewB");
            
            // PROTECCIÓN: Verificamos que se haya encontrado el controlador para evitar fallos (NullPointerException).
            if (ctrlB != null) {
                // -------------------------------------------------------------
                // 3. Forzamos a que pinte el mensaje con los nuevos datos
                // -------------------------------------------------------------
                // Como las vistas se cargan en memoria al iniciar la app, llamamos manualmente 
                // a este método para que la Vista B refresque el texto de su etiqueta ('Label')
                // leyendo los nuevos valores que acabamos de guardar en el 'Main'.
                ctrlB.actualitzarDades();
            }

            // -----------------------------------------------------------------
            // 4. Cambiamos de pantalla
            // -----------------------------------------------------------------
            // Le indicamos al gestor de pantallas que oculte el formulario ("ViewA")
            // y haga visible la pantalla del resultado ("ViewB").
            UtilsViews.setView("ViewB");
        }
    }
}
