package com.vpl2k.sasa.mainmenu;

import com.vpl2k.sasa.SASAApplication;
import com.vpl2k.sasa.editor.EditorSceneController;
import com.vpl2k.sasa.util.ResourceLoader;
import com.vpl2k.sasa.util.TAMManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainMenuSceneController
{

    public static final int PREF_WIDTH = 800;
    public static final int PREF_HEIGHT = 600;

    @FXML
    private void newEditorScene(ActionEvent event)
    {
        SASAApplication sasaApplication = SASAApplication.getApplicationInstance();

        ResourceLoader.loadScene(
                "views/editor-view.fxml",
                (Stage) ((Node) event.getSource()).getScene().getWindow(),
                EditorSceneController.PREF_WIDTH,
                EditorSceneController.PREF_HEIGHT
        );
    }

    @FXML
    private void loadEditorScene(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = getTAMFile(stage);

        if (selectedFile == null) return;

        TAMManager tamManager = new TAMManager(selectedFile);
        tamManager.readFile();

        ResourceLoader.loadScene(
                "views/editor-view.fxml",
                (Stage) ((Node) event.getSource()).getScene().getWindow(),
                EditorSceneController.PREF_WIDTH,
                EditorSceneController.PREF_HEIGHT
        );
    }

    public File getTAMFile(Stage stage)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Simulation");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Tile Assembly Model Files", "*.tam")
        );
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        return fileChooser.showOpenDialog(stage);
    }

    @FXML
    private void exit(ActionEvent event)
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
