package softeng206.a02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BashCommandProcessor processor = new BashCommandProcessor();
        processor.createFolders();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Maths Aid");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
