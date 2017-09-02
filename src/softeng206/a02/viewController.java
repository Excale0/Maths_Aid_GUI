package softeng206.a02;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

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
    private void createAction(ActionEvent E) throws Exception{
        String creationName = creationTextField.getCharacters().toString().trim();
        if (creationName.isEmpty()) {
            String errorMsg = "Please enter a name in the field before pressing create.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION,errorMsg);
            alert.getDialogPane().setMinWidth(500);
            alert.getDialogPane().setHeaderText("Error");
            alert.setTitle("Error");
            alert.showAndWait();
        } else {
            BashCommandProcessor processor = new BashCommandProcessor();
            String alertMsg;
            if (processor.creationExists(creationName)){
                alertMsg = "A creation with the file name you have specified already exists. \n Would" +
                        "you like to overwrite?";
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,alertMsg);
                alert.getDialogPane().setMinWidth(500);
                alert.getDialogPane().setHeaderText("Error");
                alert.setTitle("Error");
                alert.showAndWait();
            } else {
                videoWorker videoCreator = new videoWorker(creationName);
                videoCreator.call();
            }

        }



    }



}
