package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	Rectangle rektangel;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//Lager rektangel-objektet:
			rektangel = new Rectangle();
			//Setter posisjonen til øvre venstre hjørne:
			rektangel.setX(150.0f);
			rektangel.setY(75.0);
			//Setter bredde og høyde:
			rektangel.setWidth(200.0);
			rektangel.setHeight(100.0);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//Setter farge:
			rektangel.setFill(Color.RED);
			//Legger rektangelet inn i rotpanelet:
			root.setCenter(rektangel);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
