package ARAprog.ReadFile;

import java.io.File;
import java.io.Serializable;

public class ReadJOBJ extends AbstractRead implements Serializable {
    public ReadJOBJ(File file){
        readJOBJ(file);
    }
}
