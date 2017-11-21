/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify.Controller.Template3;

import java.util.Vector;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Maia
 */
public class ChoiceQuestion extends VBox{
    TextField Question;
    TextArea Answers;
    
    public ChoiceQuestion(){
        Label QLabel = new Label("Enter question here");
        Question = new TextField();
        
        Label ALabel = new Label("Enter answers here, separate by new lines.");
        Answers = new TextArea();
        
        this.getChildren().addAll(QLabel,Question,ALabel,Answers);
    }
    
    public String getQuestion(){
        return Question.getText();
    }
    
    public String[] getAnswers(){
        String answersString = Answers.getText();
        String[] answers = answersString.split("\n");
        System.out.print(answers.toString());
        return answers;
    }
    
}
