package ARAprog.ReadFile;

import java.io.File;
import java.util.ArrayList;

public class ReadCSV extends AbstractRead {
    private ArrayList<String> fileData = new ArrayList<>();

    public ReadCSV(File file){
        fileData.addAll(readCSVfile(file));
    }

    public ArrayList<String> getFileData() {
        return fileData;
    }
}
