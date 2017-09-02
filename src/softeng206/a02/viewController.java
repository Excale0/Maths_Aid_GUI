package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class viewController {

    @FXML
    private Button playButton;

    @FXML
    private Button deleteButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button createButton;

    @FXML
    private TableView creationsTable;

    @FXML
    private TextField creationTextField;

    @FXML
    private void playAction(ActionEvent E){

        File file = new File("123.mp4");
        String URI = file.toURI().toString();
        Media creation = new Media(URI);
        MediaPlayer player = new MediaPlayer(creation);
        mediaView.setMediaPlayer(player);
        player.play();

        playButton.setText("Playing");

    }

    @FXML
    private void deleteAction(ActionEvent E){
        deleteButton.setText("Pressed");
    }

    @FXML
    private void createAction(ActionEvent E) throws IOException{
        if (creationTextField.getCharacters().toString().trim().isEmpty()) {
            String errorMsg = "Please enter a name in the field before pressing create.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION,errorMsg);
            alert.getDialogPane().setMinWidth(500);
            alert.getDialogPane().setHeaderText("Error");
            alert.setTitle("Error");
            alert.showAndWait();
        } else {
            String creationCommand = "ffmpeg -f lavfi -i color=c=blue:s=1280x720:d=3 -vf " +
                    "drawtext=fontsize=60: \\ fontcolor=white:x=(w-text_w)/2:y=(h-text_h)/2:text=\"$creationName\"\" " +
                    "./Temporary_files/${creationName}.mp4 &> /dev/null";
            ProcessBuilder creationProcess = new ProcessBuilder("/bin/bash","-c",creationCommand);
        }



    }

}
