package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import buildify.Buildify;
import buildify.Controller.Template3.*;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    @FXML
    Button addWidget;
    ChoiceQuestionCreator cq;
    TextQuestionCreator tq;
    //works for the onDrag methods inside the fxml
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().addAll("Single-Choice Question",
                "Multi-Choice Question",
                "Text Question");
        handleComboBoxAction(combo);
    }

    private void handleComboBoxAction(ComboBox comboList) {
        comboList.valueProperty().addListener((ob, old_val, new_val) -> {
            String chosen = (String) comboList.getValue();
            pane.getChildren().clear();
            switch (chosen) {
                case "Single-Choice Question":
                case "Multi-Choice Question":
                    cq = new ChoiceQuestionCreator();
                    cq.setMaxWidth(pane.getWidth());
                    pane.getChildren().add(cq);
                    break;
                case "Text Question":
                    tq = new TextQuestionCreator();
                    tq.setMaxWidth(pane.getWidth());
                    pane.getChildren().add(tq);
                    break;
                default:
                    break;
            }

        }
        );
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Pane p = new Pane();
        if (event.getSource() == addWidget) {
            switch ((String) combo.getValue()) {
                case "Single-Choice Question":
                    SingleChoiceQuestionWidget single = new SingleChoiceQuestionWidget(cq.getQuestion(), cq.getAnswers());
                    //single.setMaxWidth(p.getWidth());
                    p.getChildren().add(single);
                case "Multi-Choice Question":
                    MultiChoiceQuestionWidget multi = new MultiChoiceQuestionWidget(cq.getQuestion(), cq.getAnswers());
                    //multi.setMaxWidth(p.getWidth());
                    p.getChildren().add(multi);
                    break;
                case "Text Question":
                    TextQuestionWidget text = new TextQuestionWidget(tq.getQuestion());
                    //text.setMaxWidth(300.0);
                    text.setMaxHeight(90.0);
                    p.getChildren().add(text);
                    break;
                default:
                    break;
            }
            p.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    try {
                        nodeDrag(t);
                    } catch (IOException e) {

                    }

                }
            });
            p.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    try {
                        nodePress(t);
                    } catch (IOException e) {

                    }

                }
            });
            p.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    try {
                        nodeRemove(t);
                    } catch (IOException ex) {
                    }
                }

            });
        }
        if (!p.getChildren().isEmpty()) {
            previewPane.getChildren().add(p);
        }
    }

    private void nodeRemove(MouseEvent event) throws IOException {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                System.out.println("double clicked");
                previewPane.getChildren().remove(((Node) (event.getSource())));
            }
        }

    }

    private void nodeDrag(MouseEvent event) throws IOException {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((Node) (event.getSource())).setTranslateX(newTranslateX);
        ((Node) (event.getSource())).setTranslateY(newTranslateY);
    }

    private void nodePress(MouseEvent t) throws IOException {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        orgTranslateX = ((Node) (t.getSource())).getTranslateX();
        orgTranslateY = ((Node) (t.getSource())).getTranslateY();
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
        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("Please enter screenshot name:");
        Optional<String> r= dialog.showAndWait();
        if(r.isPresent()){
            WritableImage screenshot = previewPane.snapshot(new SnapshotParameters(), null);
            fr = new File(r.get() + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "png", fr);
                a = new Alert(Alert.AlertType.CONFIRMATION, "Screenshot saved: " + fr.getAbsolutePath(), ButtonType.OK);
                a.showAndWait();
            } catch (IOException e) {
                a = new Alert(Alert.AlertType.ERROR, "Screenshot Not Saved", ButtonType.OK);
                a.showAndWait();
            }
        }

    }

    private void displayError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "No Choice Selected", ButtonType.OK);
        a.showAndWait();

    }
}
