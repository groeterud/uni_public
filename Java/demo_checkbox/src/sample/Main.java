package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private CheckBox box1,box2,box3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        VBox box = new VBox();
        Scene scene = new Scene(root,400,400);
        root.setLeft(box);
        box1 = new CheckBox("OBJ2000");
        box2 = new CheckBox("OBJ2100");
        box3 = new CheckBox("OAD2000");
        box1.setOnAction(e -> behandleBoks1());
        box2.setOnAction(e -> behandleBoks2());
        box3.setOnAction(e -> behandleBoks3());
        primaryStage.setScene(scene);
        box.getChildren().addAll(box1,box2,box3);
        

        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    //lyttere
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
