package ARAprog.WriteFile;

import java.io.*;
import java.util.ArrayList;

abstract class AbstractWrite{

    static void writeCSV(ArrayList<String> dataOut, File path) throws IOException {
        PrintWriter writer;
        writer = new PrintWriter(path);
        //writer.println(dataOut);
        for(String text : dataOut){
            writer.println(text);
        }
        writer.close();

    }

    static void writeJOBJ(ArrayList<Object> dataOut, File path) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for(Object object : dataOut){
            objectOutputStream.writeObject(object);
        }

        objectOutputStream.close();

    }

}
