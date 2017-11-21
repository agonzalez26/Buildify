/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import java.util.Vector;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class SingleChoiceQuestionWidget extends VBox {
    public SingleChoiceQuestionWidget(String question, String[] answers){
        Label q = new Label(question);
        ToggleGroup group = new ToggleGroup();
        this.getChildren().addAll(q);
        for (String a : answers){
           RadioButton rb = new RadioButton(a);
           rb.setToggleGroup(group);
           this.getChildren().add(rb);
        }
    }
    
}
