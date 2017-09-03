package softeng206.a02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Raymond Wang on 2/09/17.
 */
public class creationController {
    @FXML
    private Button creationButton;

    @FXML
    private TextField creationTextField;

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
                audioCreationWorker audioCreator = new audioCreationWorker(creationName);
                audioCreator.call();
            }

        }



    }


}
