package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	//Deklarerer globalt, slik at lytteren vet om den:
	ComboBox<String> liste;
	//Definerer innholdet i boksen:}
	String[] alternativer = {"Mandag", "Tirsdag", "Onsdag"};
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//Lager ComboBox-objektet:
			liste = new ComboBox<String>();
			//Setter inn ukedagene:
			liste.getItems().addAll(alternativer);
			//Setter "overskrift" på boksen:
			liste.setValue("Ukedag");
			//Knytter komboboksen til lytteren:
			liste.setOnAction(e -> behandleValg());
			//Legger komboboksen inn i rotpanelet:
			root.setCenter(liste);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//En lytter som skriver ut valgt ukedag:
	public void behandleValg() {
		//Leser hvilken dag som det er klikket på:
		String valg = liste.getValue();
		//Skriver ut i konsollet:
		System.out.println(valg);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
