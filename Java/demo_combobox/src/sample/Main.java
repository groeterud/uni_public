package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
    ComboBox<String> liste; // deklarerer globalt slik at lytteren vet om den
    //Innholdet til comboboxen
    String[] alternativer = {"Mandag","Tirsdag","Onsdag","Torsdag","Fredag","Lørdag","Søndag"};


    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        //Lager comboboxen
        liste = new ComboBox<String>();

        liste.getItems().addAll(alternativer);
        liste.setValue("Ukedag"); // Overskrift

        liste.setOnAction(e -> behandleValg());

        root.setCenter(liste);


        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //En lytter som skriver ut valgt ukedag
    public void behandleValg() {
        //Leser valgt ukedag fra comboboxen
        System.out.println(liste.getValue());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
