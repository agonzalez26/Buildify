package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import buildify.Buildify;
import buildify.Controller.Template3.ChoiceQuestion;
import buildify.Controller.Template3.TextQuestion;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

//https://stackoverflow.com/questions/32342864/applying-mvc-with-javafx
public class Template3Controller implements Initializable {

    @FXML
    private ScrollPane template3View;
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
    ComboBox combo;
    @FXML
    Pane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().addAll
                ("Single-Choice Question",
                "Multi-Choice Question",
                "Text Question");
        handleComboBoxAction(combo);
    }
    
    private void handleComboBoxAction(ComboBox comboList) {
        comboList.valueProperty().addListener(
                (ob, old_val, new_val) -> {
                    String chosen = (String) comboList.getValue();
                    pane.getChildren().clear();
                    switch (chosen){
                        case "Single-Choice Question":
                        case "Multi-Choice Question":
                            ChoiceQuestion cq = new ChoiceQuestion();
                            pane.getChildren().add(cq);
                            break;
                        case "Text Question":
                            TextQuestion tq = new TextQuestion();
                            pane.getChildren().add(tq);
                            break;
                        default:
                            break;
                    }
                    
                }
        );
    }


    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        if (event.getSource() == back) {
            if (checkSaved() == true) {

                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template3View.fxml"));
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
                root = FXMLLoader.load(Buildify.class.getResource("View/Template3View.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            //want to open an existing template JSON stuff that mias working on

        } else if (event.getSource() == newT) {
            System.out.println("new Template");
            if (checkSaved() == true) {

                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template3View.fxml"));
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
            a = new Alert(Alert.AlertType.INFORMATION, "Developed by Alma Gonzalez", ButtonType.OK);
            a.showAndWait();
        } else if (event.getSource() == aboutM) {
            a = new Alert(Alert.AlertType.INFORMATION, "Developed by Maia", ButtonType.OK);
            a.showAndWait();
        } else {
            System.out.println("asdas");
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
}
