package ARAprog.ReadFile;

import ARAprog.Exceptions.ReadExceptions.ReadCSVException;
import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.File;

public class ReadCSV extends AbstractRead {

    public ReadCSV(File file){

        //try {
            readCSV(file);
        /*} catch (ReadCSVException e) {
            e.printStackTrace();
        }*/

    }

    private static String readCSV(File file){
        File selectedFile = file;
        String parsedFile =  "" + selectedFile + "";
        return parsedFile;
    }
}
