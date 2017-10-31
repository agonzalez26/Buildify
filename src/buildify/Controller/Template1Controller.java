package buildify.Controller;
import javafx.scene.image.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import buildify.Buildify;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Template1Controller implements Initializable {
    // variables

    ObservableList<String> comboItemsList = FXCollections.observableArrayList(
            "Label", "Button", "TextField", "TextArea");
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
    @FXML
    private MenuItem help;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Menu helpMenu;
    @FXML
    private GridPane designPane;
    @FXML
    private GridPane editPane;
    @FXML
    private Button imageChooser;
    private ImageView  myImageView;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // checks which button does what
        if (event.getSource() == addButton) {
            String nameText = NameText.getText();
            System.out.println(nameText);
//			System.out.println(comboList.getValue());

            designPane.add(new Label(nameText), 1, 0);

//		} else if(event.getSource() == backButton) {
//			 stage = (Stage) backButton.getScene().getWindow();
//			 //load up OTHER FXML document
//			 root = FXMLLoader.load(HRMS.class.getResource("View/TemplateView.fxml"));
//			 // create a new scene with root and set the stage
//			 Scene scene = new Scene(root);
//			 stage.setScene(scene);
//			 stage.show();
        } else {
            System.exit(0);
        }
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
            System.out.println("open");
        } else if (event.getSource() == newT) {
            System.out.println("new");
        } else if (event.getSource() == save) {
            System.out.println("Saving...");
        } else if (event.getSource() == saveExit) {
            System.out.println("Saving and exit.");
        } else if (event.getSource() == help) {
            Alert a = new Alert(Alert.AlertType.ERROR, "First Name Empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
        }else {

            System.out.println("asdas");
        }
//		Scene scene = new Scene(root);
//		 stage.setScene(scene);
//		 stage.show();
    }

    @FXML
    private void handleImageChooser(ActionEvent event) throws IOException {
        if(event.getSource() == imageChooser){
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose a file");
            File fr = chooser.showOpenDialog(stage); 
            chooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "jpg", "png", "gif"));
            if(fr != null){//if nothing is selected, then it is null and will not print anything
                imageChooser.setText(fr.getName());
//                BufferedImage bufferedImage = ImageIO.read(fr);
//                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
//                myImageView.setImage(image);
//               Image img = new Image("https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?201703170823");
//        ImageView iview = new ImageView(img);
//        ImageView iview = new ImageView(new Image("htt"));
//                designPane.add(myImageView, 2,2 );
                
            }else{
                System.out.println("Nothing was selected");
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setting the values into the choice box
        comboList.setItems(comboItemsList);
    }

   
}
