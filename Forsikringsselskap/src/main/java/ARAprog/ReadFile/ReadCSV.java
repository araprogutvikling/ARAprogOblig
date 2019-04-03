package ARAprog.ReadFile;

import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.File;

public class ReadCSV extends AbstractRead {

    public ReadCSV(File file) {
        try {
            readCSV(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readCSV(File file){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Excel file", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });
        String parsedFile =  "" + selectedFile + "";
        return parsedFile;
    }

    @Override
    void readFile(String Filetype) {

    }
}
