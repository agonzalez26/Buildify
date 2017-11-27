/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class TextQuestionWidget extends VBox {
    public TextQuestionWidget(String question){
        Label q = new Label(question);
        TextArea a = new TextArea();
        //a.setEditable(false);
        a.setWrapText(true);
        this.getChildren().addAll(q,a);
    }
}
