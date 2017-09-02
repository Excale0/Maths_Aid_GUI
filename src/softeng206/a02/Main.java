package softeng206.a02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CreateFolders();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Maths Aid");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }

    public static void CreateFolders(){
        ProcessBuilder folderCreatorBuilder = new ProcessBuilder("/bin/bash","-c","mkdir Creations " +
                "Temporary_files");
        try {
            Process folderCreator = folderCreatorBuilder.start();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
