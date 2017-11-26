/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildify;

import buildify.SaveEngine.Writer;
import java.io.File;
import javafx.scene.control.Label;

/**
 *
 * @author Maia
 */
public class WriterTest {
    
    public WriterTest(){
        Writer w = new Writer(new File("tempfile.txt"));
        w.addLabel(new Label("Blah"));
        w.saveAll();
    }

}
