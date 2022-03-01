package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView tabell = new TableView();
    //Oppretter et objekt av klassen ObservableList, legger inn et par person-objekter samtidig.
    private ObservableList<Person> data = FXCollections.observableArrayList(new Person("Ole Brum","Hundremetrskogen","81549300"), new Person("Nasse Nøff","Hundreterskogen","123"),new Person("Tussi","Hundremeterskogen","321"));

    private TextField navn,adresse,telefon;
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Enkel Tabell");
        // setter størrelsen på vinduet:
        primaryStage.setWidth(300);
        primaryStage.setHeight(400);

        TableColumn colNavn = new TableColumn("Navn:");
        colNavn.setMinWidth(100);
        colNavn.setCellValueFactory(new PropertyValueFactory<Person,String>("navn"));

        TableColumn colAdresse = new TableColumn("Adresse:");
        colAdresse.setMinWidth(100);
        colAdresse.setCellValueFactory(new PropertyValueFactory<Person,String>("adresse"));

        TableColumn colTlf = new TableColumn("Telefon:");
        colTlf.setMinWidth(100);
        colTlf.setCellValueFactory(new PropertyValueFactory<Person,String>("telefon"));

        TableView tabell = new TableView();

        tabell.getColumns().addAll(colNavn,colAdresse,colTlf);
        tabell.setItems(data);

        root.setCenter(tabell);

        FlowPane registreringPanel = new FlowPane();

        navn = new TextField();
        navn.setPromptText("Navn:");
        navn.setMaxWidth(colNavn.getPrefWidth());

        adresse = new TextField();
        adresse.setPromptText("Adresse:");
        adresse.setMaxWidth(colAdresse.getPrefWidth());

        telefon = new TextField();
        telefon.setPromptText("Telefon:");
        telefon.setMaxWidth(colTlf.getPrefWidth());


        Button leggTil = new Button("Legg til");
        leggTil.setOnAction(e -> leggTil());

        registreringPanel.getChildren().addAll(navn,adresse,telefon,leggTil);

        root.setBottom(registreringPanel);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void leggTil() {
        data.add(new Person(navn.getText(),adresse.getText(),telefon.getText()));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
