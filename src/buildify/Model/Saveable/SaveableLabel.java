/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Model.Saveable;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author Maia
 */
public class SaveableLabel extends SaveableWidget {
    public Label label;
    public String labelText;

    public SaveableLabel(Node node) {
        super(node);
        try{
            label = (Label) node;
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        CaptureImportantProperties();
        PassUpInfoToSuper();
    }
    
    //need this to get a label's private properties so that we can capture them in the xml document
    private void CaptureImportantProperties(){
        labelText = label.getText();
    }
    
    private void PassUpInfoToSuper(){
        passUpType();
    }

    private void passUpType(){
        super.type = label.getClass().getTypeName();
    }
    
}
