module com.vpl2k.sasa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vpl2k.sasa to javafx.fxml;
    exports com.vpl2k.sasa;

    opens com.vpl2k.sasa.mainmenu to javafx.fxml;
    exports com.vpl2k.sasa.mainmenu;

    opens com.vpl2k.sasa.editor to javafx.fxml;
    exports com.vpl2k.sasa.editor;
}