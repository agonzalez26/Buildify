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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class TemplateController implements Initializable {

    @FXML
    private Button temp1Button;
    @FXML
    private Button temp2Button;
    @FXML
    private Button temp3Button;
    @FXML
    private Button temp4Button;
    private Stage stage = null;
    private Parent root = null;

    @FXML
    private MenuBar menuBar;
    @FXML
    private Button backButton;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // checks which button does what
        if (event.getSource() == temp1Button) {

            // get reference to the button's stage
            stage = (Stage) temp1Button.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/Template1View.fxml"));

        } else if (event.getSource() == temp2Button) {
            // get reference to the button's stage
            stage = (Stage) temp2Button.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/Template2View.fxml"));

        } else if (event.getSource() == temp3Button) {
            // get reference to the button's stage
            stage = (Stage) temp3Button.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/Template3View.fxml"));

        } else if (event.getSource() == temp4Button) {
            // get reference to the button's stage
            stage = (Stage) temp4Button.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/Template4View.fxml"));

        } else if(event.getSource() == backButton){
            // get reference to the button's stage
            stage = (Stage) backButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(Buildify.class.getResource("View/HomeView.fxml"));
        }else {
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
