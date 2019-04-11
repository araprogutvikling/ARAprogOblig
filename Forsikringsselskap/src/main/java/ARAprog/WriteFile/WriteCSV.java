package ARAprog.WriteFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WriteCSV extends AbstractWrite {

    public WriteCSV(ArrayList<String> dataOut, File path){

        try {
            writeCSV(dataOut, path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
