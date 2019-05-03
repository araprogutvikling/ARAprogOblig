package ARAprog.WriteFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WriteJOBJ extends AbstractWrite{

    public WriteJOBJ(ArrayList<Object> dataOut, File path){
        try {
            writeJOBJ(dataOut, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
