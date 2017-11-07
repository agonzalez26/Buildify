package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import buildify.Buildify;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Template4Controller implements Initializable {
    // variables
    @FXML
    private ScrollPane template4View;
    @FXML
    private AnchorPane createPane; //contains the editor
    @FXML
    private AnchorPane previewPane; //editable pane
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem back;
    @FXML
    private MenuItem openT;
    @FXML
    private MenuItem newT;
    private MenuItem save;
    @FXML
    private MenuItem saveExit;
    @FXML
    private MenuItem help;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Menu helpMenu;
    private File fr;
    @FXML
    private MenuItem saveScreenshot;

 

    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        if (event.getSource() == back) {
            stage = (Stage) menuBar.getScene().getWindow();
            root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == openT) {
            System.out.println("open");
        } else if (event.getSource() == newT) {
            System.out.println("new Template");
            stage = (Stage) menuBar.getScene().getWindow();
            root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == save) {
            System.out.println("Saving...");
        } else if (event.getSource() == saveScreenshot) {
            saveTemplate();
        } else if (event.getSource() == saveExit) {
            System.out.println("Saving and exit.");
        } else if (event.getSource() == help) {

            Alert a = new Alert(Alert.AlertType.INFORMATION, "Developed by Alma Gonzalez", ButtonType.OK);
            a.showAndWait();
        } else {
            System.exit(0);
        }
//		Scene scene = new Scene(root);
//		 stage.setScene(scene);
//		 stage.show();
    }

    private void saveTemplate() throws IOException {
        WritableImage screenshot = previewPane.snapshot(new SnapshotParameters(), null);
        fr = new File("Template3Screenshot.jpg");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "jpg", fr);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Screenshot saved: " + fr.getAbsolutePath(), ButtonType.OK);
            a.showAndWait();
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Screenshot Not Saved", ButtonType.OK);
            a.showAndWait();
    }

    }

    private void displayError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "No Choice Selected", ButtonType.OK);
        a.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
