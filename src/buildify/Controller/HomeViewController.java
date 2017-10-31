package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import buildify.Buildify;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeViewController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == startButton) {
            // get reference to the button's stage
            stage = (Stage) startButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));

        } else {
            System.exit(0);
        }
        // create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
