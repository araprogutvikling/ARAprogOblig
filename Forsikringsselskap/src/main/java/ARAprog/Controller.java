package ARAprog;

import ARAprog.ReadFile.ReadCSV;
import ARAprog.ReadFile.ReadJOBJ;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    @FXML
    public Button btnReadFile;
    public ListView txtCstmrLst;
    Service<Void> dataLoaderThread;

    public void readFile(){
        //TODO: Make sure this works
        FileChooser fileChooser = new FileChooser();
        ArrayList<String> data = new ArrayList<>();
        txtCstmrLst.getItems().clear();

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel csv-file", "*.csv"), new FileChooser.ExtensionFilter("Java object", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });
        String fileType = fileChooser.getSelectedExtensionFilter().getDescription();
        dataLoaderThread = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        Thread.sleep(5000);

                        if (fileType == "Excel csv-file"){
                            ReadCSV read = new ReadCSV(selectedFile);
                            data.addAll(read.getFileData());
                            System.out.println(data);
                            for (String text : data){
                                Text string = new Text(text + "\n");
                                txtCstmrLst.getItems().add(string);
                            }
                        }
                        else if(fileType == "Java object"){
                            ReadJOBJ read = new ReadJOBJ(selectedFile);
                        }
                        else{
                            //TODO: Make a better error
                            System.err.println("Wrong filetype!");
                        }

                        return null;
                    }
                };
            }
        };
        dataLoaderThread.setOnSucceeded(event -> System.out.println("Done loading!"));
        dataLoaderThread.restart();

    }








}
