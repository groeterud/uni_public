package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane root = new BorderPane();

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);

       // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Label hilsen = new Label();
        hilsen.setText("Hallo Der!");

        root.setCenter(hilsen);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
