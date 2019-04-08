package ARAprog.ReadFile;

import java.io.*;
import java.util.ArrayList;

abstract class AbstractRead {

    protected static ArrayList<String> readCSV(File file){
        BufferedReader bufferedReader = null;
        ArrayList<String> dataFromFile = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dataFromFile.add(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataFromFile;
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

        }
    }*/


}
