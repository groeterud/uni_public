package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    /*
    JavaFX app that shows a rectangle the user can change color on.
    Can be changed from radio buttons
    OR
    Can be changed from comboboxes
     */
    Rectangle rectangle;

    ToggleGroup gruppe = new ToggleGroup();
    RadioButton rb_red;
    RadioButton rb_blue;
    RadioButton rb_yellow;

    ComboBox<String> list;
    String[] opts = {"RED","BLUE","YELLOW"};
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);

        //rektangel
        rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        rectangle.setFill(Color.RED);

        root.setCenter(rectangle);

        VBox left = new VBox();
        root.setLeft(left);
        VBox right = new VBox();
        root.setRight(right);

        rb_red = new RadioButton("RED");
        rb_blue = new RadioButton("BLUE");
        rb_yellow = new RadioButton("YELLOW");

        rb_red.setSelected(true);
        rb_blue.setSelected(false);
        rb_yellow.setSelected(false);

        rb_red.setToggleGroup(gruppe);
        rb_blue.setToggleGroup(gruppe);
        rb_yellow.setToggleGroup(gruppe);

        //set listeners
        rb_red.setOnAction(e -> setColorRed());
        rb_blue.setOnAction(e -> setColorBlue());
        rb_yellow.setOnAction(e -> setColorYellow());
        //add to VBox
        left.getChildren().addAll(rb_red,rb_blue,rb_yellow);

        list = new ComboBox<String>();
        list.getItems().addAll(opts);
        list.setValue("FARGE");
        list.setOnAction(e -> behandleValg());

        right.getChildren().addAll(list);

        primaryStage.show();
    }

    private void behandleValg() {
        String valg = list.getValue();
        switch (valg) {
            case "RED":
                setColorRed();
                break;
            case "BLUE":
                setColorBlue();
                break;
            case "YELLOW":
                setColorYellow();
                break;
        }
    }

    private void setColorYellow() {
        rectangle.setFill(Color.YELLOW);
        list.setValue("YELLOW");
        rb_red.setSelected(false);
        rb_blue.setSelected(false);
        rb_yellow.setSelected(true);

    }

    private void setColorBlue() {
        rectangle.setFill(Color.BLUE);
        list.setValue("BLUE");
        rb_red.setSelected(false);
        rb_blue.setSelected(true);
        rb_yellow.setSelected(false);

    }

    private void setColorRed() {
        rectangle.setFill(Color.RED);
        list.setValue("RED");
        rb_red.setSelected(true);
        rb_blue.setSelected(false);
        rb_yellow.setSelected(false);

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
