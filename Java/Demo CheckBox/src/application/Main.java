package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	//Deklarerer boksene globalt:
	CheckBox boks1, boks2, boks3;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			//Lager en VBox til avkrysningsboksene:
			VBox knappepanel = new VBox();
			//Legger VBox'en inn til venstre i rotpanelet:
			root.setLeft(knappepanel);
			//Oppretter boksene:
			boks1 = new CheckBox("OBJ2000");
			boks2 = new CheckBox("OBJ2100");
			boks3 = new CheckBox("OAD2000");
			//Knytter boksene til lytterne:
			boks1.setOnAction(e -> behandleBoks1());
			boks2.setOnAction(e -> behandleBoks2());
			boks3.setOnAction(e -> behandleBoks3());
			//Legger boksene til knappepanelet:
			knappepanel.getChildren().addAll(boks1, boks2, boks3);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Lyttere:
	public void behandleBoks1() {
		System.out.println("Du valgte OBJ2000");
	}
	
	public void behandleBoks2() {
		System.out.println("Du valgte OBJ2100");
	}
	
	public void behandleBoks3() {
		System.out.println("Du valgte OAD2000");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
