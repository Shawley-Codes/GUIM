package GUIM_GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PrimaryInterface extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrimaryFX.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
            stage.setTitle("General Use Inventory Manager");
            stage.setScene(scene);
            stage.show();
        }
}

