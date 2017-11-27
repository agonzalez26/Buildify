/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class MultiChoiceQuestionWidget extends VBox{
    public MultiChoiceQuestionWidget(String question, String[] answers){
        Label q = new Label(question);
        this.getChildren().add(q);
        for (String a : answers){
            this.getChildren().add(new RadioButton(a));
        }
    }
}
