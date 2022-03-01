package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Application {
    private ListView liste;
    private ArrayList<String> ukedager = new ArrayList<>();

    @Override
    public void start(Stage vindu) throws Exception{
        //lager listen
        liste = new ListView();
        ukedager.add("Mandag");
        ukedager.add("Tirsdag");
        ukedager.add("Onsdag");
        ukedager.add("Torsdag");
        ukedager.add("Fredag");
        ukedager.add("Lørdag");
        ukedager.add("Søndag");

        //lager kontrollobjektet
        ObservableList<String> innhold = FXCollections.observableArrayList();
        innhold.addAll(ukedager);

        //Knytter kontrollobjektet til listeboksen
        liste.setItems(innhold);

        //lager en knapp
        Button knapp = new Button("Les valg");
        knapp.setOnAction(e -> behandleValg());

        //Layout-panel
        BorderPane root = new BorderPane();
        root.setCenter(liste);
        root.setBottom(knapp);

        Scene scene = new Scene(root,400,400);
        vindu.setTitle("Demo av listeboks");
        vindu.setScene(scene);
        vindu.show();
    }

    //Lytteren for knappen
    public void behandleValg() {
        //Hente ut det som er valgt i listeboksen. Default er single selection, men vi kan også sette multiple-selection
        //Leser valget til en ny observablelist
        ObservableList valgteElementer = liste.getSelectionModel().getSelectedIndices();
        //Siden vi har single selection, ligger valgt element på index 0 i valgteElementer.
        //Vi henter ikke ut verdien, men indexen til verdien den har i ArrayListen vår.
        int indeks = (int)valgteElementer.get(0);
        JOptionPane.showMessageDialog(null,"Du har valgt"+ukedager.get(indeks));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
