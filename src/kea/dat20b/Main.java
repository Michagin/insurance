package kea.dat20b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));

        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);


        /* No top bar */
        // primaryStage.initStyle(StageStyle.TRANSPARENT);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
