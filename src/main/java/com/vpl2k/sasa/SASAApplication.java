package com.vpl2k.sasa;

import com.vpl2k.sasa.mainmenu.MainMenuSceneController;
import com.vpl2k.sasa.util.ResourceLoader;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class SASAApplication extends Application
{
    private static SASAApplication SASAAppInstance;

    @Override
    public void init()
    {
        SASAAppInstance = this;
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        URL iconUrl = SASAApplication.class.getResource("images/sasa-logo.png");
        Image icon = new Image(Objects.requireNonNull(iconUrl).openStream());
        stage.getIcons().add(icon);

        stage.setTitle("SASA - Simulating Algorithmic Self Assembly");

        ResourceLoader.loadScene(
                "views/main-menu-view.fxml", stage,
                MainMenuSceneController.PREF_WIDTH,
                MainMenuSceneController.PREF_HEIGHT
        );
    }

    public static void main(String[] args)
    {
        launch();
    }

    public static SASAApplication getApplicationInstance()
    {
        return SASAAppInstance;
    }

}