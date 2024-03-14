package Programa;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Calculadora implements Initializable {

	@FXML
	private Button bot_borrarPantalla;

	@FXML
	private Button bot_borrarTodo;

	@FXML
	private Button bot_borrarUltimoNumero;

	@FXML
	private Button bot_cero;

	@FXML
	private Button bot_cinco;

	@FXML
	private Button bot_cuadrado;

	@FXML
	private Button bot_cuatro;

	@FXML
	private Button bot_dividir;

	@FXML
	private Button bot_dos;

	@FXML
	private Button bot_grabar;

	@FXML
	private Button bot_igual;

	@FXML
	private Button bot_multiplicar;

	@FXML
	private Button bot_nueve;

	@FXML
	private Button bot_ocho;

	@FXML
	private Button bot_punto;

	@FXML
	private Button bot_raizCuadrada;

	@FXML
	private Button bot_restar;

	@FXML
	private Button bot_seis;

	@FXML
	private Button bot_siete;

	@FXML
	private Button bot_sumar;

	@FXML
	private Button bot_tres;

	@FXML
	private Button bot_uno;

	@FXML
	private Button bot_signo;

	@FXML
	private Label labPantalla;

	@FXML
	private Label labPantallaExtra;

	private boolean hayDigito = false;

	private boolean hayPunto = false;

	private boolean pulsadoIgual = false;

	private double operador1;

	private double operador2;

	private double operador3;

	private char signoMatematico = ' ';

	private int numOperandos = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(1);
		labPantalla.setText("0");
	}

	@FXML
	void click_cero(ActionEvent event) {
		mostrarPantalla("0");
	}

	@FXML
	void click_uno(ActionEvent event) {
		mostrarPantalla("1");
	}

	@FXML
	void click_dos(ActionEvent event) {
		mostrarPantalla("2");
	}

	@FXML
	void click_tres(ActionEvent event) {
		mostrarPantalla("3");
	}

	@FXML
	void click_cuatro(ActionEvent event) {
		mostrarPantalla("4");
	}

	@FXML
	void click_cinco(ActionEvent event) {
		mostrarPantalla("5");
	}

	@FXML
	void click_seis(ActionEvent event) {
		mostrarPantalla("6");
	}

	@FXML
	void click_siete(ActionEvent event) {
		mostrarPantalla("7");
	}

	@FXML
	void click_ocho(ActionEvent event) {
		mostrarPantalla("8");
	}

	@FXML
	void click_nueve(ActionEvent event) {
		mostrarPantalla("9");
	}

	@FXML
	void click_cambioSigno(ActionEvent event) {

		if (!labPantalla.getText().isEmpty() && labPantalla.getText() != null) {

			double numero = Double.parseDouble(labPantalla.getText());
			comprobarSimbolo();
			if (numero >= 1) {
				labPantalla.setText("-" + labPantalla.getText());
			} else if (numero <= -1) {
				labPantalla.setText("+" + labPantalla.getText());
			} else {
				if (labPantalla.getText().equals("0") || labPantalla.getText().equals("0.0")) {
					labPantalla.setText("0");
				}
			}
		}

	}

	private void comprobarSimbolo() {

		char primerNumero = labPantalla.getText().charAt(0);

		if (primerNumero == '+' || primerNumero == '-') {
			labPantalla.setText(labPantalla.getText().substring(1));
		}
	}

	@FXML
	void click_punto(ActionEvent event) {

		for (int i = 0; i < labPantalla.getText().length(); i++) {

			if (labPantalla.getText().charAt(i) == '.') {
				return;
			}
		}

		if (!hayDigito && !hayPunto) {
			labPantalla.setText("0.");
			hayDigito = true;
		} else if (!hayPunto) {
			labPantalla.setText(labPantalla.getText() + ".");
		}
		hayPunto = true;
	}

	@FXML
	void click_restar(ActionEvent event) {
		valorOperador1();
		signoMatematico = '-';
	}

	@FXML
	void click_sumar(ActionEvent event) {
		valorOperador1();
		signoMatematico = '+';
	}

	@FXML
	void click_dividir(ActionEvent event) {
		valorOperador1();
		signoMatematico = '/';
	}

	@FXML
	void click_multiplicar(ActionEvent event) {
		valorOperador1();
		signoMatematico = 'x';
	}

	@FXML
	void click_cuadrado(ActionEvent event) {

		if (!labPantalla.getText().isEmpty() && labPantalla.getText() != null) {
			double numCuadrado = Double.parseDouble(labPantalla.getText()) * Double.parseDouble(labPantalla.getText());
			labPantalla.setText(String.valueOf(numCuadrado));
			labPantallaExtra.setText("");
		}

	}

	@FXML
	void click_raiz(ActionEvent event) {
		if (!labPantalla.getText().isEmpty() && labPantalla.getText() != null) {
			double raizCuadrada = Math.sqrt(Double.parseDouble(labPantalla.getText()));
			labPantalla.setText(String.valueOf(raizCuadrada));
			labPantallaExtra.setText("");
		}
	}

	@FXML
	void click_delete(ActionEvent event) {
		labPantalla.setText("");
		this.operador2 = 0;
	}

	@FXML
	void click_borrarUltimoNumero(ActionEvent event) {
		// Obtener el índice del penúltimo carácter
		if (!labPantalla.getText().isEmpty() && labPantalla.getText() != null) {
			int indicePenultimo = labPantalla.getText().length() - 1;
			// Obtener la subcadena sin el último número
			String cadenaSinUltimoNumero = labPantalla.getText().substring(0, indicePenultimo);
			labPantalla.setText(cadenaSinUltimoNumero);

			if (labPantalla.getText().isEmpty()) {
				labPantalla.setText("0");
			}

		} else {
			labPantalla.setText("0");
		}
	}

	@FXML
	void click_borrarTodo(ActionEvent event) {
		pulsadoIgual = false;
		signoMatematico = ' ';
		this.operador1 = 0;
		this.operador2 = 0;
		labPantalla.setText("");
		labPantallaExtra.setText("");
	}

	@FXML
	void click_borrarPantalla(ActionEvent event) {
		labPantalla.setText("");
	}

	@FXML
	void click_igual(ActionEvent event) {

		if (!String.valueOf(signoMatematico).isEmpty()) {
			double calculoTotal = 0;
			switch (signoMatematico) {
			case '+': {
				calculoTotal = this.operador1 + Double.parseDouble(labPantalla.getText());
				labPantalla.setText(String.valueOf(calculoTotal));
				break;
			}
			case '-': {
				calculoTotal = this.operador1 - Double.parseDouble(labPantalla.getText());
				labPantalla.setText(String.valueOf(calculoTotal));
				break;
			}
			case 'x': {
				calculoTotal = this.operador1 * Double.parseDouble(labPantalla.getText());
				labPantalla.setText(String.valueOf(calculoTotal));
				break;
			}
			case '/': {
				if (labPantalla.getText().equals("0") || this.operador1 == 0) {
					labPantalla.setText("N/A");
					break;
				} else {
					calculoTotal = this.operador1 / Double.parseDouble(labPantalla.getText());
					labPantalla.setText(String.valueOf(calculoTotal));

					break;
				}
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + signoMatematico);
			}
			pulsadoIgual = true;
			labPantallaExtra.setText("");
			signoMatematico = ' ';
		}

	}

	@FXML
	void click_mostrar(ActionEvent event) {
		labPantalla.setText(String.valueOf(this.operador2));
	}

	private void mostrarPantalla(String numero) {

		if (pulsadoIgual) {
			labPantalla.setText("");
		}

		if (!hayDigito && !hayPunto) {
			labPantalla.setText(numero);
			hayDigito = true;

		}
		if (numOperandos > 0) {
			labPantalla.setText(labPantalla.getText() + numero);
		}
		pulsadoIgual = false;
		numOperandos++;
	}

	private void valorOperador1() {

		if (String.valueOf(signoMatematico).trim().isEmpty() && !labPantalla.getText().isEmpty()) {
			if (labPantalla.getText().equals("N/A")) {
				labPantalla.setText("0");
			}
			this.operador1 = Double.parseDouble(labPantalla.getText());
			labPantallaExtra.setText(String.valueOf(this.operador1));
			labPantalla.setText("");
		}

	}

}
