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
import javafx.scene.control.*;
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
    public Button btnClosePopup;
    public Button btnTInsuranceConditions1;
    public Button btnHInsuranceConditions;
    public Label lblPopup;
    public Button showTerms;
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
    public ListView ListForClaimsHistory;
    public ListView ScrollList;
    public Label lblOCustomer, lblOAddress, lblOCustomerStart, lblOYN1, lblOYN2, lblOYN3, lblOYN4, lblHInsuranceNr1,
            lblHInsurancePrm1, lblHAddress1, lblHType1, lblHBuildingMaterial1, lblHStandard1, lblHSquaremeter1,
            lblHInsuranceVB1, lblHDateForInsurance1, lblHAmountInsurance1, lblHInsuranceVC11, lblBInsuranceNr1, lblBInsurancePrm1,
            lblBOwner1, lblHType11, lblBTypeModel1, lblBRegNr1, lblBYear1, lblBMotor1, lblBAmountInsurance1,
            lblBDateForInsurance2, lblTInsuranceNr1, lblTInsurancePrm1, lblTDateForInsurance1, lblTAmountInsurance1, lblTSumInsurance1,
            lblAreaInsurance1, lblCInsuranceNr1, lblCInsurancePrm1, lblCAddress1, lblCType1, lblCBuildingMaterial1, lblHInsuranceVC1,
            lblCStandard1, lblCSquaremeter1, lblCInsuranceVB1, lblCInsuranceVC1, lblCDateForInsurance1, lblCAmountInsurance1;

    public Parent nyKundeScene, loadingScene, termsAppear;


    @FXML public void initialize(){

    }

    public void readFile(){
        FileChooser fileChooser = new FileChooser();
        ScrollList.getItems().clear();
        data.clear();
        clearTextFields();
        String fileType = null;

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

    private void clearTextFields(){
        lblOCustomer.setText("----------");
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
        lblHInsuranceVC11.setText("----------");
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
    }

    public void getSelectedCustomer(){
        int selectedCustomer = ScrollList.getSelectionModel().getSelectedIndex();
        String[] selectedCustomerData = parseCustomerData(data.get(selectedCustomer));

        lblOCustomer.setText("Kundenr: " + selectedCustomerData[0] + " | Navn: " + selectedCustomerData[1] + " " + selectedCustomerData[2] + " | Personnr: " + selectedCustomerData[3]);
        lblOAddress.setText("Faktureringsadresse: " + selectedCustomerData[4] + ", " + selectedCustomerData[5] + " " + selectedCustomerData[6]);
        lblOCustomerStart.setText("Kundeforhold opprettet: " + selectedCustomerData[7]);
        lblOYN1.setText(selectedCustomerData[8]);
        lblOYN2.setText(selectedCustomerData[9]);
        lblOYN3.setText(selectedCustomerData[10]);
        lblOYN4.setText(selectedCustomerData[11]);
    }

    private String[] parseCustomerData(String data){
        String[] customerDataList = data.split(";");
        //TODO: Add exception checks with error messages
        return customerDataList;
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


    public void showTerms (ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(btnHInsuranceConditions)){

            String text = PopupTermsData.popupTermsData("btnHInsuranceConditions");
            lblPopup.setText(text);
        }
        Node node = (Node) actionEvent.getSource();
        Stage stage  = (Stage) node.getScene().getWindow();
        try {
            this.termsAppear = FXMLLoader.load(getClass().getResource("/FXML/PopupTerms.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }



        Scene scene = new Scene(termsAppear);
        Stage modal= new Stage();
        modal.setScene(scene);
        modal.initOwner(stage);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }



    public void btnClosePopup (ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }


}