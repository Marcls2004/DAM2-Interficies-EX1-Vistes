package com.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación que hereda de 'Application' de JavaFX.
 * Se encarga de inicializar la ventana, cargar las vistas y almacenar los datos globales.
 */
public class Main extends Application {

    // =========================================================================
    // === VARIABLES ESTÁTICAS PARA EL EJERCICIO ===
    // =========================================================================
    // Estas variables actúan como un canal de comunicación global.
    // Al ser 'public static', cualquier controlador (ControllerVistaA o B) puede 
    // leer o escribir en ellas directamente usando 'Main.nom' o 'Main.edat'.
    public static String nom = "";
    public static String edat = "";

    // =========================================================================
    // === CONFIGURACIÓN DE DIMENSIONES ===
    // =========================================================================
    // Constantes para definir el tamaño inicial predeterminado de la ventana.
    final int WIDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 600;

    /**
     * Método principal del sistema (punto de entrada tradicional de Java).
     * Llama internamente a 'launch(args)' para que JavaFX configure el entorno gráfico.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Ciclo de vida principal de JavaFX. Se ejecuta automáticamente tras el 'launch'.
     * Aquí se construye la interfaz y se configura el escenario ('Stage').
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Aplica una tipografía base común (Arial tamaño 14) a todo el contenedor principal.
        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");

        // =========================================================================
        // === REGISTRAMOS LAS VISTAS DEL EJERCICIO 01 ===
        // =========================================================================
        // 'UtilsViews.addView' lee los archivos FXML del disco, asocia sus controladores 
        // y los añade a la pila en memoria de 'parentContainer'.
        // Parámetro 1: Clase de referencia para buscar recursos (Main.class).
        // Parámetro 2: El ID o alias de texto único que tendrá la vista ("ViewA" / "ViewB").
        // Parámetro 3: La ruta física exacta dentro de 'src/main/resources'.
        UtilsViews.addView(Main.class, "ViewA", "/assets/viewA.fxml");
        UtilsViews.addView(Main.class, "ViewB", "/assets/viewB.fxml");

        // =========================================================================
        // === CONFIGURACIÓN DE LA ESCENA Y VENTANA ===
        // =========================================================================
        
        // Activamos "ViewA" (el formulario) para que sea la primera pantalla visible de la app.
        UtilsViews.setView("ViewA");

        // Creamos el lienzo ('Scene') asociándolo al contenedor raíz que almacena todas las vistas.
        Scene scene = new Scene(UtilsViews.parentContainer);

        // Vinculamos la escena a la ventana física ('Stage')
        stage.setScene(scene);
        
        // Configuramos propiedades estéticas y de control de tamaño para la ventana
        stage.setTitle("Programa Dues Vistes");
        stage.setMinWidth(WIDOW_WIDTH);   // Ancho mínimo permitido al arrastrar el borde
        stage.setMinHeight(WINDOW_HEIGHT); // Alto mínimo permitido al arrastrar el borde
        
        // Hace visible la interfaz gráfica en el monitor del ordenador
        stage.show();

        // =========================================================================
        // === ICONO DE LA APLICACIÓN ===
        // =========================================================================
        // Los sistemas macOS gestionan los iconos desde el empaquetado (.app). 
        // Este condicional añade el icono personalizado en la barra de tareas solo si usas Windows o Linux.
        if (!System.getProperty("os.name").contains("Mac")) {
            Image icon = new Image("file:/icons/icon.png");
            stage.getIcons().add(icon);
        }
    }
}
