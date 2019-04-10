package ARAprog.ReadFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract class AbstractRead {

    protected static ArrayList<String> readCSVfile(File file){
        ArrayList<String> dataFromFile = new ArrayList<>();
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileReader.hasNextLine()){
            dataFromFile.add(fileReader.nextLine().replace(",", ";"));
        }

        return dataFromFile;
    }

    protected static Object readJOBJfile(File file){
        FileInputStream fileIn;
        ObjectInputStream objIn;
        Object data = null;

        try {
            fileIn = new FileInputStream(file.getAbsoluteFile());
            objIn = new ObjectInputStream(fileIn);
            data = objIn.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
