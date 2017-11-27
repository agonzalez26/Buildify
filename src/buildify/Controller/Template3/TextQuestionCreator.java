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
public class TextQuestionCreator extends VBox {
   private TextField Question;
   public TextQuestionCreator(){
       Label qLabel = new Label("Enter the question:");
       Question = new TextField();
       Question.setPrefWidth(100);
       this.getChildren().addAll(qLabel,Question);
}
   
   public String getQuestion(){
       return Question.getText();
   }
}
