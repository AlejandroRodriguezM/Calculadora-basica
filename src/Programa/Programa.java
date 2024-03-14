package Programa;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Programa extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventana/CalculadoraV2.fxml"));

		// Cargo el padre
		Parent root = loader.load();

		primaryStage.getIcons().add(new Image("/Iconos/calculadora.png"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.setTitle("Calculadora");
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

}
