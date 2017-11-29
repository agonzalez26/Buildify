/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buildify.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;
import java.util.Vector;
import javafx.scene.control.Alert;
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
public class ImagePicker {
    private Window ownerWindow;
    private String path;
    Vector<StringHandler> handlers = new Vector<>();

    public ImagePicker(Window ownerWindow){
        this.ownerWindow = ownerWindow;
    }
    
    public void pickImage() throws Exception {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Where would you like to pull an image from?",
                new ButtonType("My Computer", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("Online", ButtonBar.ButtonData.OK_DONE));
        Optional<ButtonType> result = a.showAndWait();
        if (result.get().getText().equals("My Computer")){
            path = pickFile();
            for (StringHandler h : handlers){
                h.handle(path);
            }
        } else if (result.get().getText().equals("Online")){
            path = pickURL();
            for (StringHandler h : handlers){
                h.handle(path);
            }
        } else {
            throw Exception("Valid path was not found!");
        }
    }
    
    public String pickFile(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose a file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
        File f = chooser.showOpenDialog(ownerWindow);
        if (f != null){
            return f.toURI().toString();
        } else {
            return null;
        }
    }
    
    public String pickURL(){
        TextInputDialog tid = new TextInputDialog("Enter Image URL");
        Optional<String> input = tid.showAndWait();
        if (input.get() != null){
            Boolean isImage = input.get().contains(".jpeg") ||
                    input.get().contains(".png") ||
                    input.get().contains(".gif");
            if (isImage){
                return input.get();
//                try{
//                    URL blah = new URL(input.get());
//                    return blah;
//                }catch(MalformedURLException e){
//                    return null;
//                }
            }else {
                return null;
            }
        }
        return null;
    }
    
    public String getPath(){
        return path;
    }
    
    public void addStringHandler(StringHandler h){
		handlers.add(h);
    }

    private Exception Exception(String s) {
        throw new UnsupportedOperationException(s); //To change body of generated methods, choose Tools | Templates.
    }
}