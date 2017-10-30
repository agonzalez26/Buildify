package buildify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import buildify.Buildify;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	private TextField ColorText;
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
	@FXML
	private MenuItem help;
	@FXML
	private Menu editMenu;
	@FXML
	private Stage stage = null;
	@FXML
	private Parent root = null;

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		// checks which button does what
		if (event.getSource() == addButton) {
			String nameText = NameText.getText();
			System.out.println(nameText);
//			System.out.println(comboList.getValue());
			
			previewPane.getChildren().add(new Label(nameText));
		
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
		if(event.getSource() == back){
			stage = (Stage) menuBar.getScene().getWindow();
			root = FXMLLoader.load(Buildify.class.getResource("View/TemplateView.fxml"));
			Scene scene = new Scene(root);
			 stage.setScene(scene);
			 stage.show();
		} else if(event.getSource() == openT){
			System.out.println("open");
		}else if(event.getSource() == newT){
			System.out.println("new");
		}else if(event.getSource() == save){
			System.out.println("Saving...");
		}else if(event.getSource() == saveExit){
			System.out.println("Saving and exit.");
		}else if(event.getSource() == help){
			 Alert a = new Alert(Alert.AlertType.ERROR , "First Name Empty", ButtonType.OK);
             Optional<ButtonType> result =  a.showAndWait();
		}
		else{
		
			System.out.println("asdas");
		}
//		Scene scene = new Scene(root);
//		 stage.setScene(scene);
//		 stage.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// setting the values into the choice box
		comboList.setItems(comboItemsList);
	}
}
