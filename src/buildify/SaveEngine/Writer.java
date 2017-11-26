/*
    Works cited for my solutions so far:

    http://www.mkyong.com/java/jaxb-hello-world-example/
    https://stackoverflow.com/questions/16240734/how-to-marshal-unmarshal-java-objects-with-private-fields-using-jaxb
 */
package buildify.SaveEngine;

import buildify.SaveEngine.SaveableWidget.SaveableLabel;
import buildify.SaveEngine.SaveableWidget.SaveableWidget;
import java.io.File;
import java.util.Vector;
import javafx.scene.control.Label;

/**
 *
 * @author Maia
 */
public class Writer {
    File target;
    
    Vector<SaveableWidget> saveables = new Vector<>();
    
    public Writer(File f){
        target = f;
    }
    
    public void addLabel(Label l){
        saveables.add(new SaveableLabel(l));
    }
    
    public void saveAll(){
        for (SaveableWidget sw : saveables){
            System.out.println(sw.type);
            if (sw instanceof SaveableLabel){
                SaveableLabel l = (SaveableLabel) sw;
                System.out.println(l.labelText);
            }
        }
    }
    
}
