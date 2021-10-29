package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    TextField navn;
    Label output;

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FlowPane root = new FlowPane();
        root.setHgap(10);
        Button ok = new Button(">>");
        ok.setOnAction(e -> behandleKlikk(e));
        Label ledetekst = new Label("Hva heter du?");
        navn = new TextField();
        navn.setPrefColumnCount(15);
        output = new Label();

        root.getChildren().addAll(ledetekst,navn,ok,output);
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Demo hendelse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void behandleKlikk(ActionEvent event) {
        String navn_inn=navn.getText();
        String hilsen="Hei på deg "+navn_inn;
        output.setText(hilsen);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
