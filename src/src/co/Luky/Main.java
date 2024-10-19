package co.Luky;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	private double xOffset = 0;
    private double yOffset = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		StageManager.setPrimaryStage(primaryStage);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ewe.fxml"));
		Parent root = loader.load();
		root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
		root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
		primaryStage.setTitle("Task manager");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
