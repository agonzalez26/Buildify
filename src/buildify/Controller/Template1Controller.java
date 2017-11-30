package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import buildify.Buildify;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
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
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Template1Controller implements Initializable {

    @FXML
    private AnchorPane createPane; //contains the editor
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
    private MenuItem help;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Menu helpMenu;
    private Group groupPane; //nested inside anchorpane
    //works for the onDrag methods inside the fxml
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    private Image newImage;
    private ImageView imgView;
    private ImageView logoView;
    @FXML
    private MenuItem saveScreenshot;
    private FileChooser chooser;
    private File fr;
    @FXML
    private Button imageChooser;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
    @FXML
    private TextField TitleText;
    @FXML
    private Label titleLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Pane contentPane1;
    @FXML
    private Pane contentPane2;
    @FXML
    private Pane imagePane;
    @FXML
    private Pane logoPane;
    @FXML
    private Pane titlePane;
    @FXML
    private Button logoChooser;
    @FXML
    private Label contentPane1Label;
    @FXML
    private Label contentPane2Label;
    @FXML
    private TextArea contentArea1;
    @FXML
    private TextArea contentArea2;
    @FXML
    private SplitPane splitPane;
    @FXML
    private ColorPicker backColorPicker;
    @FXML
    private ColorPicker textColorPicker;
    String currentDate;
    @FXML
    private MenuItem aboutA;
    @FXML
    private MenuItem aboutM;

    private Paint fill;
    private BackgroundFill backgroundFill;
    private Background background;
    @FXML
    private ComboBox paletteBox;
    ObservableList<String> paletteItemsList = FXCollections.observableArrayList(
            "Soft Ashes", "Rainy Day", "Bubbly Glow");
    @FXML
    private BorderPane borderPane;
    private Alert a;
    private Optional<ButtonType> result;
    @FXML
    private ScrollPane templat12View;
    @FXML
    private MenuItem save;
    @FXML
    private GridPane editTable;
    @FXML
    private Label logoLabel;
    @FXML
    private Label imageLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paletteBox.setItems(paletteItemsList);
        dateInitialize();
        textBinding();
        handlePaletteBoxAction(paletteBox);
        handleTextColorChangeAction(textColorPicker);
        handleBackColorChangeAction(backColorPicker);

    }
    

    private void textBinding() {
        titleLabel.setFont(new Font(30.0));
        titleLabel.textProperty().bind(TitleText.textProperty());
        contentPane1Label.textProperty().bind(contentArea1.textProperty());
        contentPane2Label.textProperty().bind(contentArea2.textProperty());
        contentArea1.prefWidthProperty().bind(contentPane1.prefWidthProperty());
        contentArea2.prefWidthProperty().bind(contentPane2.prefWidthProperty());
    }

    private void dateInitialize() {
        currentDate = dateFormat.format(date);
        dateLabel.setText(currentDate);
    }

    private void handlePaletteBoxAction(ComboBox paletteBox) {
        paletteBox.getSelectionModel().selectedItemProperty().addListener(
                (ob, old_val, new_val) -> {
                    if (paletteBox.getValue() == "Soft Ashes") {
                        titlePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#eeeeee"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane1.setBackground(new Background(
                                new BackgroundFill(Color.web("#bbbbbb"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane2.setBackground(new Background(
                                new BackgroundFill(Color.web("#5fa2c0"), CornerRadii.EMPTY, Insets.EMPTY)));
                        logoPane.setBackground(new Background(
                                new BackgroundFill(Color.web("#396173"), CornerRadii.EMPTY, Insets.EMPTY)));
                        imagePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#396173"), CornerRadii.EMPTY, Insets.EMPTY)));
                    } else if (paletteBox.getValue() == "Rainy Day") {
                        titlePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#eeeeee"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane1.setBackground(new Background(
                                new BackgroundFill(Color.web("#d1efe4"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane2.setBackground(new Background(
                                new BackgroundFill(Color.web("#f8ab99"), CornerRadii.EMPTY, Insets.EMPTY)));
                        logoPane.setBackground(new Background(
                                new BackgroundFill(Color.web("#bbbbbb"), CornerRadii.EMPTY, Insets.EMPTY)));
                        imagePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#bbbbbb"), CornerRadii.EMPTY, Insets.EMPTY)));

                    } else if (paletteBox.getValue() == "Bubbly Glow") {
                        titlePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#fff2ec"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane1.setBackground(new Background(
                                new BackgroundFill(Color.web("#ffe8de"), CornerRadii.EMPTY, Insets.EMPTY)));
                        contentPane2.setBackground(new Background(
                                new BackgroundFill(Color.web("#ffcbcb"), CornerRadii.EMPTY, Insets.EMPTY)));
                        logoPane.setBackground(new Background(
                                new BackgroundFill(Color.web("#f984ad"), CornerRadii.EMPTY, Insets.EMPTY)));
                        imagePane.setBackground(new Background(
                                new BackgroundFill(Color.web("#f984ad"), CornerRadii.EMPTY, Insets.EMPTY)));
                    }
                }
        );
    }

    private void handleTextColorChangeAction(ColorPicker textColorPicker) {
        textColorPicker.setOnAction(
                e -> {
                    contentPane1Label.setTextFill(textColorPicker.getValue());
                    contentPane2Label.setTextFill(textColorPicker.getValue());
                    titleLabel.setTextFill(textColorPicker.getValue());
                    dateLabel.setTextFill(textColorPicker.getValue());
                }
        );

    }

    private void handleBackColorChangeAction(ColorPicker backColorPicker) {
        backColorPicker.setOnAction(
                e -> {
                    fill = backColorPicker.getValue();
                    backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
                    background = new Background(backgroundFill);
                    splitPane.setBackground(background);
                }
        );

    }

    @FXML
    private void handleImageChooser(ActionEvent event) throws IOException {
        if (event.getSource() == imageChooser) {
            chooser = new FileChooser();
            chooser.setTitle("Choose an Image");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
            fr = chooser.showOpenDialog(stage);

            if (fr != null) {
                imageChooser.setText(fr.getName());
                String imagePath = fr.toURI().toURL().toString();
                System.out.println(fr.toURI().toString());
                newImage = new Image(imagePath);
                imgView = new ImageView(newImage);
                imgView.setFitWidth(235);
                imgView.setFitHeight(275);
                imgView.fitWidthProperty().bind(imagePane.widthProperty());
                imgView.fitHeightProperty().bind(imagePane.heightProperty());

                imagePane.getChildren().add(imgView);

            } else {
                displayFileError();
            }
        } else if (event.getSource() == logoChooser) {
            chooser = new FileChooser();
            chooser.setTitle("Choose a Logo");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
            fr = chooser.showOpenDialog(stage);

            if (fr != null) {
                logoChooser.setText(fr.getName());
                String imagePath = fr.toURI().toURL().toString();
                System.out.println(fr.toURI().toString());
                newImage = new Image(imagePath);
                logoView = new ImageView(newImage);
                logoView.fitWidthProperty().bind(logoPane.widthProperty());
                logoView.fitHeightProperty().bind(logoPane.heightProperty());
                logoPane.getChildren().add(logoView);

            } else {
                displayFileError();
            }
        }
    }

    private void displayFileError() {
        a = new Alert(Alert.AlertType.ERROR, "No File Selected.", ButtonType.OK);
        a.showAndWait();
    }

    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        if (event.getSource() == back) {
            if (checkSaved() == true) {

                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
            } else {
                stage = (Stage) menuBar.getScene().getWindow();
                root = FXMLLoader.load(Buildify.class.getResource("View/Template1View.fxml"));
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
                root = FXMLLoader.load(Buildify.class.getResource("View/Template1View.fxml"));
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
                root = FXMLLoader.load(Buildify.class.getResource("View/Template1View.fxml"));
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
            a = new Alert(Alert.AlertType.INFORMATION, "Developed by Maia Ross", ButtonType.OK);
            a.showAndWait();
        } else {
            System.out.println("Apples");
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
        WritableImage screenshot = borderPane.snapshot(new SnapshotParameters(), null);
        fr = new File("Template1Screenshot.jpg");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "jpg", fr);
            a = new Alert(Alert.AlertType.CONFIRMATION, "Screenshot saved: " + fr.getAbsolutePath(), ButtonType.OK);
            a.showAndWait();
        } catch (IOException e) {
            a = new Alert(Alert.AlertType.ERROR, "Screenshot Not Saved", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void displayError() {
        a = new Alert(Alert.AlertType.ERROR, "No Choice Selected", ButtonType.OK);
        a.showAndWait();

    }

}
