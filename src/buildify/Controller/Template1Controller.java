package buildify.Controller;

import javafx.scene.image.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import buildify.Buildify;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Template1Controller implements Initializable {
    // variables

    ObservableList<String> comboItemsList = FXCollections.observableArrayList(
            "Text", "Button", "Image");
    @FXML
    private ScrollPane template1View;
    @FXML
    private ComboBox comboList;
    @FXML
    private Button addButton;
    @FXML
    private TextField NameText;
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
    private MenuItem saveExit;
    @FXML
    private MenuItem help;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Menu helpMenu;
    private Group groupPane; //nested inside anchorpane
    //works for the onDrag methods inside the fxml
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @FXML
    private ColorPicker colorPicker;
    private Node anynode;
    private Button newButton;
    private Label newLabel;
    private Image newImage;
    private ImageView imgView;
    @FXML
    private MenuItem saveScreenshot;
    private FileChooser chooser;
    private File fr;
    @FXML
    private GridPane editTable;
    private Label tableName;
    @FXML
    private Slider fontSizeSlider;
    @FXML
    private Button imageChooser;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setting the values into the choice box
        comboList.setItems(comboItemsList);
        NameText.setDisable(true);
        fontSizeSlider.setDisable(true);
        colorPicker.setDisable(true);
        imageChooser.setDisable(true);
        addButton.setDisable(true);
        try {
            handleComboBoxAction(comboList);
        } catch (IOException ex) {
    }

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == addButton) {
            if (comboList.getValue() == "Text") {

                System.out.println("Text");

                newLabel = new Label();
                newLabel.setText(NameText.getText());
                newLabel.setFont(Font.font(fontSizeSlider.getValue()));
                newLabel.setTextFill(colorPicker.getValue());
                newLabel.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeDrag(t);
                        } catch (IOException e) {

                        }

                    }
                });
                newLabel.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodePress(t);
                        } catch (IOException e) {

                        }

                    }
                });
                newLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeRemove(t);
                        } catch (IOException ex) {
                        }
                    }

                });
               
                previewPane.getChildren().add(newLabel);

            } else if (comboList.getValue() == "Button") {
                System.out.println("Button");
                newButton = new Button();
                newButton.setText(NameText.getText());
                newButton.setFont(Font.font(fontSizeSlider.getValue()));
                newButton.setTextFill(colorPicker.getValue());
                newButton.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeDrag(t);
                        } catch (IOException e) {

                        }

                    }
                });
                newButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodePress(t);
                        } catch (IOException e) {

                        }

                    }
                });
                newButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeRemove(t);
                        } catch (IOException ex) {
                        }
                    }

                });
                previewPane.getChildren().add(newButton);
            } else if (comboList.getValue() == "Image") {
                System.out.println("Image");
//                newImage = new Image("asdsa");
                imgView.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeDrag(t);
                        } catch (IOException e) {

                        }

                    }
                });
                imgView.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodePress(t);
                        } catch (IOException e) {

                        }

                    }
                });
                imgView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            nodeRemove(t);
                        } catch (IOException ex) {
                        }
                    }

                });
               
                
                previewPane.getChildren().add(imgView);

        } else {
                displayError();
            }
        } else {
            System.exit(0);
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

    private void handleComboBoxAction(ComboBox comboList) throws IOException {
        comboList.getSelectionModel().selectedItemProperty().addListener(
                (ob, old_val, new_val) -> {
                    if (comboList.getValue() == "Text") {
                        NameText.setDisable(false);
                        fontSizeSlider.setDisable(false);
                        colorPicker.setDisable(false);
                        imageChooser.setDisable(true);
                        addButton.setDisable(false);
                    } else if (comboList.getValue() == "Button") {
                        NameText.setDisable(false);
                        fontSizeSlider.setDisable(false);
                        colorPicker.setDisable(false);
                        imageChooser.setDisable(true);
                        addButton.setDisable(false);
                    } else {
                        NameText.setDisable(true);
                        fontSizeSlider.setDisable(true);
                        colorPicker.setDisable(true);
                        imageChooser.setDisable(false);
                        addButton.setDisable(true);
                    }
                }
        );
    }

    @FXML
    private void handleImageChooser(ActionEvent event) throws IOException {
        if (event.getSource() == imageChooser) {
            chooser = new FileChooser();
            chooser.setTitle("Choose a file");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
            fr = chooser.showOpenDialog(stage);

            if (fr != null) {
                addButton.setDisable(false);
                imageChooser.setText(fr.getName());
                String imagePath = fr.toURI().toURL().toString();
                System.out.println(fr.toURI().toString());
                newImage = new Image(imagePath);
                imgView = new ImageView(newImage);
//                designPane.add(myImageView, 2, 2);
//                
            } else {
                addButton.setDisable(true);
                displayFileError();
            }
        }
    }

    private void displayFileError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "No File Selected.", ButtonType.OK);
        a.showAndWait();
        }

    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        if (event.getSource() == back) {
            stage = (Stage) menuBar.getScene().getWindow();
            root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == openT) {
            //want to open an existing template JSON stuff that mias working on
            System.out.println("open");
        } else if (event.getSource() == newT) {
            System.out.println("new Template");
            stage = (Stage) menuBar.getScene().getWindow();
            root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (event.getSource() == saveScreenshot) {
            saveTemplate();
        } else if (event.getSource() == saveExit) {
            System.out.println("Saving and exit.");
        } else if (event.getSource() == help) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Developed by Alma Gonzalez", ButtonType.OK);
            a.showAndWait();
        } else {
            System.out.println("asdas");
    }
    }

    private void saveTemplate() throws IOException {
        WritableImage screenshot = previewPane.snapshot(new SnapshotParameters(), null);
        fr = new File("Template1Screenshot.jpg");
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "jpg", fr);
            Alert a = new Alert(Alert.AlertType.ERROR, "Screenshot saved: " + fr.getAbsolutePath(), ButtonType.OK);
            a.showAndWait();
//            System.out.println("screenshot saved at: " + fr.getAbsolutePath());
        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.ERROR, "Screenshot Not Saved", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void displayError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "No Choice Selected", ButtonType.OK);
        a.showAndWait();
}
}

///screenshot
//http://code.makery.ch/blog/javafx-2-snapshot-as-png-image/
//combobox stuff https://stackoverflow.com/questions/13032257/combo-box-javafx-with-fxml
//double clicking
//myNode.setOnMouseClicked(new EventHandler<MouseEvent>() {
//    @Override
//    public void handle(MouseEvent mouseEvent) {
//        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
//            if(mouseEvent.getClickCount() == 2){
//                System.out.println("Double clicked");
//            }
//        }
//    }
//});
