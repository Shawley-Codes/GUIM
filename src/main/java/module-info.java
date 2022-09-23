module creatingdesignforguim {
    requires javafx.controls;
    requires javafx.fxml;


    opens GUIM_GUI to javafx.fxml;
    exports GUIM_GUI;
}