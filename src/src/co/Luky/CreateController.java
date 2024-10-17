package co.Luky;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateController {
	  @FXML
	    private TextField PasswordField1;
	    
	    @FXML
	    private TextField userField1;
	    
	    @FXML
	    private Button LoginButton1;
	    
	    @FXML
	    private Button CreateAccount1;
	    
	    @FXML 
	    private TextField rePasswordField;
	    
	    @FXML 
	    private Text feedbackText1;
	    
	    
	    @FXML
	    private void initialize() {
	    	CreateAccount1.setOnAction(event -> {
	    		String user = userField1.getText();
		    	String Password = PasswordField1.getText();
		    	String rPassword = rePasswordField.getText();
		    	ArrayList<Usuario> usertemp = new ArrayList<>();
		    	int temp = 0;
		    	try {
					usertemp = Archivos.cargarUsuarios();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    	for(Usuario user1: usertemp) {
		    		if(user.equals(user1.getUsername())) {
		    			feedbackText1.setText("Este usuario ya existe");
		    			temp = 1;
		    		}
		    	}
	    		if(Password.equals(rPassword) && Password.isEmpty() != true && rPassword.isEmpty() != true && user.isEmpty() != true && temp == 0) {
	    			Usuario usuario = new Usuario(user,Password);
	    			Archivos.guardarUsuarios(usuario);
	    			feedbackText1.setText("Cuenta Creada");
	    		}
	    		else if(Password.equals(rPassword) == false && Password.isEmpty() != false && rPassword.isEmpty() != false && user.isEmpty() != false && temp == 0) {
	    			feedbackText1.setText("Las contraseñas no coinciden o faltan rellenar espacios");
	    		}
	    	});
	    	mostrarLogin();
	    }
	    
	    private void mostrarLogin() {
	    	Stage primaryStage = StageManager.getPrimaryStage();
	    	LoginButton1.setOnAction(event -> {
	    		try {
    		        FXMLLoader loader = new FXMLLoader(getClass().getResource("ewe.fxml"));
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
