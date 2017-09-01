package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button playButton;

    @FXML
    private Button deleteButton;

    @FXML
    private void playAction(ActionEvent E){
        playButton.setText("Playing");
    }

    @FXML
    private void deleteAction(ActionEvent E){
        deleteButton.setText("Pressed");
    }

}
