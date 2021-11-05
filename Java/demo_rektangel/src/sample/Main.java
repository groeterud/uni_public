package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    Rectangle rektangel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        //Lager rektangel-objektet
        rektangel = new Rectangle();
        //Angir posisjonen til øvre venstre hjørne i X/Y koordinator
        rektangel.setX(150.00);
        rektangel.setY(75.00);
        rektangel.setWidth(200.0);
        rektangel.setHeight(100.0);
        //Setter fargen til rektangelet
        rektangel.setFill(Color.RED);
        //Legger rektangelet inn i panelet.
        root.setCenter(rektangel);
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
