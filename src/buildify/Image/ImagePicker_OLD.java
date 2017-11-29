/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Image;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Vector;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author Maia
 */
public class ImagePicker_OLD {
    
    Window ownerWindow;
    
    Vector<URLHandler> imageHandlers = new Vector<>();

    public ImagePicker_OLD(Window ownerWindow){
        this.ownerWindow = ownerWindow;
        Alert a = new Alert(AlertType.CONFIRMATION,"Where would you like to pull an image from?",
                new ButtonType("My Computer", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("Online", ButtonBar.ButtonData.OK_DONE));
        Optional<ButtonType> result = a.showAndWait();
        
        ImageView imageView;
        if (result.get().getText().equals("My Computer")){
            String path = pickFile();
            if (path != null){
                Image im = new Image("file:"+path);
                imageView = new ImageView(im);
                for (URLHandler ih: imageHandlers){
                //    ih.handle(imageView);
                }
            }
        } else if (result.get().getText().equals("Online")){
            String path = pickURL();
            if (path != null){
                imageView = ImageViewBuilder.create().image(new Image(path)).build();
                for (URLHandler ih: imageHandlers){
                 //   ih.handle(imageView);
                }
            }
        }
    }
    
    public String pickFile(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose a file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
        File f = chooser.showOpenDialog(ownerWindow);
        if (f != null){
            return f.getAbsolutePath();
        } else {
            return null;
        }
    }
    
    public String pickURL(){
        TextInputDialog tid = new TextInputDialog("Enter Image URL");
        Optional<String> input = tid.showAndWait();
        if (input.get() != null){
            Boolean isImage = input.get().contains(".jpg") ||
                    input.get().contains(".png") ||
                    input.get().contains(".gif");
            if (isImage){
                try{
                    URL blah = new URL(input.get());
                    return blah.toString();
                }catch(MalformedURLException e){
                    return null;
                }
            }else {
                return null;
            }
        }
        return null;
    }
    
    public void addImageHandler(URLHandler bh){
		imageHandlers.add(bh);
	}
    
}
