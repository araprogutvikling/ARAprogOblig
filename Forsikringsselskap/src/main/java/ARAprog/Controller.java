package ARAprog;

import ARAprog.Controllers.NyKundeController;
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
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static ARAprog.SetSelectedCustomer.parseCustomerData;

public class Controller{
    Service<Void> dataLoaderThread;
    ArrayList<String> data = new ArrayList<>();

    @FXML
    public Button btnNyku;
    public Button btnReadFile;
    public ListView ListForClaimsHistory;
    public ListView ScrollList;
    public Label lblOCustomer, lblOAddress, lblOCustomerStart, lblOYN1, lblOYN2, lblOYN3, lblOYN4, lblHInsuranceNr1,
            lblHInsurancePrm1, lblHAddress1, lblHType1, lblHBuildingMaterial1, lblHStandard1, lblHSquaremeter1,
            lblHInsuranceVB1, lblHDateForInsurance1, lblHAmountInsurance1, lblBInsuranceNr1, lblBInsurancePrm1,
            lblBOwner1, lblHType11, lblBTypeModel1, lblBRegNr1, lblBYear1, lblBMotor1, lblBAmountInsurance1,
            lblBDateForInsurance2, lblTInsuranceNr1, lblTInsurancePrm1, lblTDateForInsurance1, lblTAmountInsurance1, lblTSumInsurance1,
            lblAreaInsurance1, lblCInsuranceNr1, lblCInsurancePrm1, lblCAddress1, lblCType1, lblCBuildingMaterial1, lblHInsuranceVC1,
            lblCStandard1, lblCSquaremeter1, lblCInsuranceVB1, lblCInsuranceVC1, lblCDateForInsurance1, lblCAmountInsurance1;

    @FXML
    public Parent nyKundeScene, NyHusScene;

    @FXML public void initialize(){
        //clearTextFields();
    }

    public void readFile(){
        FileChooser fileChooser = new FileChooser();
        ScrollList.getItems().clear();
        data.clear();
        clearTextFields();
        String fileType = null;
        ListForClaimsHistory.getItems().clear();

        /*
        TODO: Make the disable thing work
        btnReadFile.setDisable(true);
        */

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel csv-file"
                , "*.csv"), new FileChooser.ExtensionFilter("Java object", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(new PopupWindow() {
            @Override
            public void show(Window window) {
                super.show(window);
            }
        });

        try {
            fileType = fileChooser.getSelectedExtensionFilter().getDescription();
        } catch (Exception e) {
            e.getCause();
        }
        String finalFileType = fileType;
        dataLoaderThread = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        Thread.sleep(2000);

                        if (finalFileType == "Excel csv-file") {
                            ReadCSV read = new ReadCSV(selectedFile);
                            data.addAll(read.getFileData());

                        } else if (finalFileType == "Java object") {
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
        //TODO: Make sure all the textfields and labels are used
        //TODO: Make a test csv file and test jobj file, with all data
        //TODO: Make a better solution for the line below, and also add parsing of the data and sorting
        dataLoaderThread.setOnSucceeded(event -> {
            for(String text : data){
                String[] string = parseCustomerData(text);
                ScrollList.getItems().add("Kundenr: " + string[0] + " " + string[1] + " " + string[2]);
            }
        });

        dataLoaderThread.start();
    }

    //TODO: Sort methods into corresponding classes
    public void getSelectedCustomer(){
        SetSelectedCustomer selectedCustomer = new SetSelectedCustomer();
        selectedCustomer.setSelectedCustomer(ScrollList.getSelectionModel().getSelectedIndex(), data);
    }
    public void btnNykunde(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyKundeScene = FXMLLoader.load(getClass().getResource("/FXML/NyKunde.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        Scene scene = new Scene(nyKundeScene);
        modalBack(primaryStage, scene);
    }
    public void btnNyHus(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.NyHusScene = FXMLLoader.load(getClass().getResource("FXML/HusOgInnbo.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(NyHusScene);
        modalBack(primaryStage, scene);
    }

    public static void modalBack(Stage stage, Scene newScene){
        Stage modal = new Stage();
        modal.setScene(newScene);
        modal.initOwner(stage);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.show();
    }

    private void clearTextFields(){
        lblOAddress.setText("----------");
        lblOCustomerStart.setText("----------");
        lblHInsuranceNr1.setText("----------");
        lblHInsurancePrm1.setText("----------");
        lblHAddress1.setText("----------");
        lblHType1.setText("----------");
        lblHBuildingMaterial1.setText("----------");
        lblHStandard1.setText("----------");
        lblHSquaremeter1.setText("----------");
        lblHInsuranceVB1.setText("----------");
        lblHDateForInsurance1.setText("----------");
        lblHAmountInsurance1.setText("----------");
        lblBInsuranceNr1.setText("----------");
        lblBInsurancePrm1.setText("----------");
        lblBOwner1.setText("----------");
        lblHType11.setText("----------");
        lblBTypeModel1.setText("----------");
        lblBRegNr1.setText("----------");
        lblBYear1.setText("----------");
        lblBMotor1.setText("----------");
        lblBAmountInsurance1.setText("----------");
        lblBDateForInsurance2.setText("----------");
        lblTInsuranceNr1.setText("----------");
        lblTInsurancePrm1.setText("----------");
        lblTDateForInsurance1.setText("----------");
        lblTAmountInsurance1.setText("----------");
        lblAreaInsurance1.setText("----------");
        lblCInsuranceNr1.setText("----------");
        lblCInsurancePrm1.setText("----------");
        lblCAddress1.setText("----------");
        lblCType1.setText("----------");
        lblCBuildingMaterial1.setText("----------");
        lblCStandard1.setText("----------");
        lblCSquaremeter1.setText("----------");
        lblCInsuranceVB1.setText("----------");
        lblCInsuranceVC1.setText("----------");
        lblCDateForInsurance1.setText("----------");
        lblCAmountInsurance1.setText("----------");
        lblHInsuranceVC1.setText("----------");
        lblTSumInsurance1.setText("----------");
        ListForClaimsHistory.getItems().clear();
    }
}