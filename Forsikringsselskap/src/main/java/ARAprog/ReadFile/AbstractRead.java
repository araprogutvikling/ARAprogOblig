package ARAprog.ReadFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract class AbstractRead {

    protected static ArrayList<String> readCSV(File file){
        ArrayList<String> dataFromFile = new ArrayList<>();
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileScanner.hasNextLine()){
            dataFromFile.add(fileScanner.nextLine().replace(",", ";"));
        }

        return dataFromFile;
    }

    protected static Object readJOBJ(File file){
        FileInputStream filInn;
        ObjectInputStream objInn;
        Object data = null;

        try {
            filInn = new FileInputStream(file.getAbsoluteFile());
            objInn = new ObjectInputStream(filInn);
            data = objInn.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return data;
    }


   /* public void chooseFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel", "*.csv"), new FileChooser.ExtensionFilter("Java object", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });
        String fileType = fileChooser.getSelectedExtensionFilter().getDescription();
        if (fileType == "Excel"){
            ReadCSV read = new ReadCSV(selectedFile);
        }
        else if(fileType == "Java object"){
           ReadJOBJ read = new ReadJOBJ(selectedFile);
        }
    }*/


}
