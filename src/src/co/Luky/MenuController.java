package co.Luky;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MenuController {
	
	@FXML
	private Text Welcome;
	@FXML
	private void initialize() {
		if(Sesion.getUsuario() != null) {
			Welcome.setText("!Welcome " + Sesion.getUsuario().getUsername() + "!");
		}
	}
}
