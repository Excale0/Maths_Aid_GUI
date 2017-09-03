package softeng206.a02;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class viewController {

    @FXML
    public void initialize(){
        File creationsFolder = new File("./Creations/");
        File[] files = creationsFolder.listFiles();
        List<creationObject> creationFiles = new ArrayList<>();
        for (File creation: files){
            creationObject temporary = new creationObject(creation);
            creationFiles.add(temporary);
        }
        ObservableList<creationObject> creationList = FXCollections.observableList(creationFiles);
        creationsView.setItems(creationList);
    }

    @FXML
    private Button playButton;

    @FXML
    private Button deleteButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button createButton;

    @FXML
    protected ListView<creationObject> creationsView;

    @FXML
    private Tab creationTab;


    @FXML
    private void playAction(ActionEvent E){

        creationObject creation = creationsView.getSelectionModel().getSelectedItem();
        if (creation != null) {
            File file = creation.getSourceFile();
            String URI = file.toURI().toString();
            Media creationMedia = new Media(URI);
            MediaPlayer player = new MediaPlayer(creationMedia);
            mediaView.setMediaPlayer(player);
            player.play();
        }

        playButton.setText("Playing");

    }

    @FXML
    private void deleteAction(ActionEvent E) throws Exception{
        creationObject creation = creationsView.getSelectionModel().getSelectedItem();
        if (creation != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you sure you want to delete creation "+creation.toString());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                BashCommandProcessor deleter = new BashCommandProcessor();
                deleter.deleteCreation(creation.toString());
                creationsView.getItems().remove(creationsView.getSelectionModel().getSelectedItem());
            }
        }
    }




}
