package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	//Klassen ToggleGroup "holder styr på" radioknappene:
	ToggleGroup gruppe = new ToggleGroup();
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			//Oppretter en radioknapp:
			RadioButton rb1 = new RadioButton("Hjemme");
			//Setter rb1 til å være default-knapp:
			rb1.setSelected(true);
			//Oppretter to knapper til:
			RadioButton rb2 = new RadioButton("Kalender");
			RadioButton rb3 = new RadioButton("Kontakter");	
			//Sier at rb2 og rb3 ikke skal være valgt:
			rb2.setSelected(false);
			rb3.setSelected(false);
			//Knytter knappene til ToggleGroup:
			rb1.setToggleGroup(gruppe);
			rb2.setToggleGroup(gruppe);
			rb3.setToggleGroup(gruppe);
			//Legger knappene inn i rotpanelet (VBox):
			root.getChildren().addAll(rb1, rb2, rb3);
			//En annen måte å håndtere hendelser på:
			rb1.setOnAction(e -> {if(rb1.isSelected()) System.out.println("Hjemme er valgt");});
			rb2.setOnAction(e -> {if(rb2.isSelected()) System.out.println("Kalender er valgt");});
			rb3.setOnAction(e -> {if(rb3.isSelected()) System.out.println("Kontakter er valgt");});
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
