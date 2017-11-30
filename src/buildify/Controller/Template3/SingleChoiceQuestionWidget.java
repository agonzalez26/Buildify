/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import java.util.Vector;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class SingleChoiceQuestionWidget extends VBox {
    ToggleGroup group;
    public SingleChoiceQuestionWidget(String question, String[] answers){
        Label q = new Label(question);
        group = new ToggleGroup();
        this.getChildren().addAll(q);
        for (String a : answers){
           RadioButton rb = new RadioButton(a);
           rb.setToggleGroup(group);
           this.getChildren().add(rb);
        }
    }
    
    public Boolean hasGoodToggleGroup(){
        Boolean allGood = true;
        for (Node n : this.getChildren()){
            if (n instanceof RadioButton){
                RadioButton rb = (RadioButton) n;
                if (rb.getToggleGroup() != group){
                    allGood = false;
                }
            }
        }
        return allGood;
    }
    
    
    
}
