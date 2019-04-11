package ARAprog.WriteFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class AbstractWrite {

    protected static void writeCSV(ArrayList<String> dataOut, File path) throws IOException {
        String newString;
        FileWriter fw = new FileWriter(path.getAbsoluteFile());

        for (String string : dataOut){
            if (string.contains(";")){
                newString = string + "\n";
                fw.write(newString);
            }
        }

        fw.flush();
        fw.close();

    }

}
