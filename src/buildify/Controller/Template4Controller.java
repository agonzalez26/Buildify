package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import buildify.Buildify;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem saveExit;
    private MenuItem help;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Menu helpMenu;
    private File fr;
    @FXML
    private MenuItem saveScreenshot;
    @FXML
    private MenuItem aboutA;
    @FXML
    private MenuItem aboutM;
    private Alert a;
    private Optional<ButtonType> result;

    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        if (event.getSource() == back) {
            if (checkSaved() == true) {

                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template4View.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == openT) {
            if (checkSaved() == true) {
                System.out.println("open");
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template4View.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == newT) {
            if (checkSaved() == true) {

                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template4View.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == save) {
            System.out.println("Saveing Template");
        } else if (event.getSource() == saveScreenshot) {
            saveTemplate();
        } else if (event.getSource() == saveExit) {
            System.out.println("Saving and exit.");
        } else if (event.getSource() == aboutA) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Developed by Alma Gonzalez", ButtonType.OK);
            a.showAndWait();
        } else if (event.getSource() == aboutM) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Developed by Maia Ross", ButtonType.OK);
            a.showAndWait();
        } else {
            System.exit(0);
        }

    }

    private boolean checkSaved() {
        a = new Alert(Alert.AlertType.INFORMATION, "Have you saved your template?", ButtonType.YES, ButtonType.NO);
        result = a.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            return true;
        } else {
            return false;
        }
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
