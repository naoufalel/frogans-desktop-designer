package tests;

import com.frogans.designer.model.FsdlParser;
import javafx.scene.control.TreeItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by naouf on 3/22/2016.
 */
public class FsdlParserTest {

    String filename ="C:\\Users\\naouf\\Downloads\\Frogans\\FrogansPlayer4Dev-noinstall-alpha0.7.1-win32\\test\\helloworld\\home.fsdl";
    FsdlParser fsdlParser = new FsdlParser(new File(filename));

    @org.junit.Test
    public void setFile() throws Exception {
        if (fsdlParser.getFile().getName().equals(filename)){
            assertTrue(fsdlParser.getFile().getName(),true);
            System.out.println(fsdlParser.getFile().getName());
        }
    }

    @org.junit.Test
    public void gaga() throws Exception {
        List<TreeItem<String>> finalArray= new ArrayList<>();


    }
}