package co.Luky;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class viewController {

	private ArrayList<Usuario> users = new ArrayList<>();
	// EWE.FXML
	@FXML
	private TextField userField;

	@FXML
	private TextField passwordField;

	@FXML
	private Text feedbackText;

	@FXML
	private Button loginButton;

	@FXML
	private Button CreateAccount;

	@FXML
	private Text Close;
	// FIN

	// CREARCUENTA.FXML

	// FIN

	@FXML

	private void initialize() throws Exception {
		users = Archivos.cargarUsuarios();
		loginButton.setOnAction(event -> {
			String user = userField.getText();
			String password = passwordField.getText();
			if (user.isEmpty() || password.isEmpty()) {
				feedbackText.setText("Por favor, complete todos los campos.");
			} else {
				feedbackText.setText("Usuario o contraseña incorrectos.");
			}
			if (user.isEmpty() != true && password.isEmpty() != true) {
				for (Usuario user1 : users) {
					if (user1.getUsername().equals(user) && user1.getPassword().equals(password)) {
						Sesion.setUsuario(user1);
						feedbackText.setText("Inicio de sesión exitoso!");
						Stage primaryStage = StageManager.getPrimaryStage();
						try {
							FXMLLoader loader = new FXMLLoader(getClass().getResource("principal.fxml"));
							Parent root = loader.load();
							Scene scene = new Scene(root);
							primaryStage.setScene(scene);
							primaryStage.show();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		loginButton.setCursor(javafx.scene.Cursor.HAND);
		CreateAccount.setCursor(javafx.scene.Cursor.HAND);
		Close.setCursor(javafx.scene.Cursor.HAND);
		Close.setOnMouseClicked(event -> {
			Platform.exit();
		});

		crearCuentaVIEW();

	}

	private void crearCuentaVIEW() {
		Stage primaryStage = StageManager.getPrimaryStage();
		if (CreateAccount != null) {
			CreateAccount.setOnAction(event -> {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearCuenta.fxml"));
					Parent root = loader.load();
					Scene scene = new Scene(root);
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

}