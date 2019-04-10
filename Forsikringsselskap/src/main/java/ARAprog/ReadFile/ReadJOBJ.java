package ARAprog.ReadFile;

import java.io.File;
import java.io.Serializable;

public class ReadJOBJ extends AbstractRead implements Serializable {
    private Object fileData;

    public ReadJOBJ(File file){
        fileData = readJOBJfile(file);
    }

    public Object getFileData() {
        return fileData;
    }
}
