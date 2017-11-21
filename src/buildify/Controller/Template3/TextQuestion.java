/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class TextQuestion extends VBox {
   private TextField Question;
   public TextQuestion(){
       Label qLabel = new Label("Enter the question:");
       Question = new TextField();
       this.getChildren().addAll(qLabel,Question);
}
   
   public String getQuestion(){
       return Question.getText();
   }
}
