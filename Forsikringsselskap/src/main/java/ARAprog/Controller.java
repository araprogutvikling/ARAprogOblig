package ARAprog;

import ARAprog.ReadFile.ReadCSV;
import ARAprog.ReadFile.ReadJOBJ;
import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.File;

public class Controller {

    public void readFile(){
        FileChooser fileChooser = new FileChooser();
        Object read; //TODO: Make sure this works

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel csv-file", "*.csv"), new FileChooser.ExtensionFilter("Java object", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });
        String fileType = fileChooser.getSelectedExtensionFilter().getDescription();
        if (fileType == "Excel csv-file"){
            read = new ReadCSV(selectedFile);
        }
        else if(fileType == "Java object"){
           read = new ReadJOBJ(selectedFile);
        }
        else{
            //TODO: Make a better error
            System.err.println("Wrong filetype!");
        }
    }



}
