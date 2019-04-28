package ARAprog;

import ARAprog.ReadFile.ReadCSV;
import ARAprog.ReadFile.ReadJOBJ;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller{
    Service<Void> dataLoaderThread;
    ArrayList<String> data = new ArrayList<>();

    @FXML
    public Button btnNyKundeLukk;
    public Button btnNyku;
    public TextField InputPnr;
    public TextField inputAge;
    public TextField inputFirstName;
    public TextField inputLastName;
    public TextField inputAdress;
    public TextField inputZipCode;
    public TextField InputArea;
    public TextField inputPhone;
    public TextField inputEmail;
    public Button btnReadFile;
    public ListView ScrollList;
    public Label lblOCustomer;

    public Parent nyKundeScene, loadingScene;

    @FXML public void initialize(){

    }

    public void readFile() {
        FileChooser fileChooser = new FileChooser();
        ScrollList.getItems().clear();
        data.clear();
        /*
        TODO: Make the disable thing work
        btnReadFile.setDisable(true);
        */

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

                        if (fileType == "Excel csv-file") {
                            ReadCSV read = new ReadCSV(selectedFile);
                            data.addAll(read.getFileData());
                            System.out.println(data);

                        } else if (fileType == "Java object") {
                            ReadJOBJ read = new ReadJOBJ(selectedFile);

                        } else {
                            //TODO: Make a better error
                            System.err.println("Wrong filetype!");

                        }

                        return null;
                    }
                };
            }
        };
        //TODO: Make a better solution for the line below, and also add parsing of the data and sorting
        dataLoaderThread.setOnSucceeded(event -> {
            for(String text : data){
                Text string = new Text(text + "\n");
                ScrollList.getItems().add(string);}
        });

        dataLoaderThread.start();
    }

    public void getSelectedCustomer() throws IllegalStateException{
        int selectedCustomer = ScrollList.getSelectionModel().getSelectedIndex();
        lblOCustomer.setText(data.get(selectedCustomer));

        System.out.println(selectedCustomer);
    }

    public void btnNykunde(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyKundeScene = FXMLLoader.load(getClass().getResource("/FXML/NyKunde.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyKundeScene);
        Stage modal= new Stage();
        modal.setScene(scene);
        modal.initOwner(primaryStage);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    public void LagNyKundeOnClick(ActionEvent actionEvent){

        try{
            Node node = (Node) actionEvent.getSource();
            Stage loadingStage = (Stage) node.getScene().getWindow();
            this.loadingScene = FXMLLoader.load(getClass().getResource("/FXML/Loading.fxml"));
            Scene scene = new Scene(loadingScene);
            loadingStage.setScene(scene);
            /*Customer newCustomer;
            newCustomer = new Customer(Integer.parseInt(InputPnr.getText()), inputAge.getText(), inputFirstName.getText(),
                    inputLastName.getText(), inputAdress.getText(), inputZipCode.getText(), InputArea.getText(),
                    inputPhone.getText(), inputEmail.getText());
            loadingStage.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnNyKundeLukk(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }
}