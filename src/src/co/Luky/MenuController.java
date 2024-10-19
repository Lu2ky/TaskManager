package co.Luky;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenuController {

	@FXML
	private Text Welcome;

	@FXML
	private Text Close;

	@FXML
	private Rectangle CreateTaskButton;

	@FXML
	private Text CreateTaskText;

	@FXML
	private Rectangle ViewTaskButton;

	@FXML
	private Text ViewTaskText;

	@FXML
	private Button HelpandFeedback;

	@FXML
	private void initialize() {
		Welcome.setText("!Welcome " + Sesion.getUsuario().getUsername() + "!");
		Close.setCursor(javafx.scene.Cursor.HAND);
		CreateTaskButton.setCursor(javafx.scene.Cursor.HAND);
		CreateTaskText.setCursor(javafx.scene.Cursor.HAND);
		ViewTaskButton.setCursor(javafx.scene.Cursor.HAND);
		ViewTaskText.setCursor(javafx.scene.Cursor.HAND);
		HelpandFeedback.setCursor(javafx.scene.Cursor.HAND);
		CreateTaskButton.setOnMouseClicked(event -> {

		});
		CreateTaskText.setOnMouseClicked(event -> {

		});
		ViewTaskButton.setOnMouseClicked(event -> {

		});
		ViewTaskText.setOnMouseClicked(event -> {

		});

		Close.setOnMouseClicked(event -> {
			Platform.exit();
		});
		HelpandFeedback.setOnAction(event -> {
			try {
				String email = "jaaa736504@gmail.com";
				String subject = "Help and Feedback";
				String body = "Your question or feedback would go here";
				URI mailto = new URI("https://mail.google.com/mail/?view=cm&fs=1&to=" + email + "&su="
						+ subject.replace(" ", "%20") + "&body=" + body.replace(" ", "%20"));
				try {
					Desktop.getDesktop().browse(mailto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		});

	}
}
