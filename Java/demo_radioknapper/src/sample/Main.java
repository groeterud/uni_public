package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    //Klassen ToggleGroup "holder styr på" radioknappene
    ToggleGroup gruppe;


    @Override
    public void start(Stage primaryStage) throws Exception{
        RadioButton rb1 = new RadioButton("Hjemme");
        RadioButton rb2 = new RadioButton("Uavgjort");
        RadioButton rb3 = new RadioButton("Borte");
        rb1.setSelected(true);
        rb1.setToggleGroup(gruppe);
        rb2.setToggleGroup(gruppe);
        rb3.setToggleGroup(gruppe);
        VBox root = new VBox();
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        root.getChildren().addAll(rb1,rb2,rb3);
        rb1.setOnAction(e -> {if(rb1.isSelected())System.out.println("Hjemme er valgt");});
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
