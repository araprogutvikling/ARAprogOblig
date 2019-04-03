package ARAprog.ReadFile;

import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.File;

abstract class AbstractRead {
    String fileType;

    public AbstractRead(){
    }

    private void chooseFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel", "*.csv"), new FileChooser.ExtensionFilter("Java object", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });
        String fileType = String.valueOf(fileChooser.getSelectedExtensionFilter());
        if (fileType == "csv"){
            ReadCSV read = new ReadCSV(selectedFile);
        }
        else if(fileType == "jobj"){

        }
    }

    private void checkFiletype(String fType){
        if (fType == "csv"){

        }
        else if (fType == "jobj"){
            //do other stuff
        }
        else{
            //error
        }
    }

}
