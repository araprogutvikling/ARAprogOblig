package ARAprog;

import ARAprog.ReadFile.ReadCSV;
import ARAprog.WriteFile.WriteCSV;
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
import java.util.Arrays;

public class Controller{
    Service<Void> dataLoaderThread;
    Service<Void> dataSaverThread;
    ArrayList<String> data = new ArrayList<>();

    @FXML
    public Button btnNyku, btnDelCustomer, btnReadFile, btnDelHis, btnHInsuranceConditions,
            btnDelH, btnDelBoat, btnDelT, btnDelC, btnNewH, btnNewBoat, btnNewT, btnNewC, btnNyHus,
            btnBInsuranceConditions, btnTInsuranceConditions1, btnCInsuranceConditions, btnNySkademelding, lukkPopup;
    @FXML
    public ListView ListForClaimsHistory, ScrollList;
    @FXML
    public Label lblOCustomer, lblOAddress, lblOCustomerStart, lblOYN1, lblOYN2, lblOYN3, lblOYN4, lblHInsuranceNr1,
            lblHInsurancePrm1, lblHAddress1, lblHType1, lblHBuildingMaterial1, lblHStandard1, lblHSquaremeter1,
            lblHInsuranceVB1, lblHDateForInsurance1, lblHAmountInsurance1, lblBInsuranceNr1, lblBInsurancePrm1,
            lblBOwner1, lblHType11, lblBTypeModel1, lblBRegNr1, lblBYear1, lblBMotor1, lblBAmountInsurance1,
            lblBDateForInsurance2, lblTInsuranceNr1, lblTInsurancePrm1, lblTDateForInsurance1, lblTAmountInsurance1, lblTSumInsurance1,
            lblAreaInsurance1, lblCInsuranceNr1, lblCInsurancePrm1, lblCAddress1, lblCType1, lblCBuildingMaterial1, lblHInsuranceVC1,
            lblCStandard1, lblCSquaremeter1, lblCInsuranceVB1, lblCInsuranceVC1, lblCDateForInsurance1, lblCAmountInsurance1, lblPopup;

    @FXML
    public Parent nyKundeScene, NyHusScene, nyBåtScene, nyReiseScene, nyFritidsboligScene, nySkadeScene, PopupTermsScene;

    @FXML public void initialize(){}

    public void refreshScrollList(){
        ScrollList.getItems().add("");
        ScrollList.getItems().clear();
        for(String text : data){
            String[] string = parseCustomerData(text);
            ScrollList.getItems().add("Kundenr: " + string[0] + " " + string[1] + " " + string[2]);
        }
    }

    public void saveFile(){
        FileChooser fileSave = new FileChooser();
        fileSave.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel csv-file", "*.csv"));
        String fileType = null;

        File savedFile = fileSave.showSaveDialog(new PopupWindow() {
            @Override
            public void show(Window owner) {
                super.show(owner);
            }
        });

        fileType = fileSave.getSelectedExtensionFilter().getDescription();

        String finalFileType = fileType;
        dataSaverThread = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        if (finalFileType.equals("Excel csv-file")) {
                            WriteCSV write = new WriteCSV(data, savedFile);

                        } /*else if (finalFileType.equals("Java object")) {
                            WriteJOBJ write = new WriteJOBJ(data ,savedFile);
                            //TODO: Make this writer work

                        }*/ else {
                            //TODO: Make a better error
                            System.err.println("No file selected, or save window exited");

                        }

                        return null;
                    }
                };
            }
        };

        dataSaverThread.setOnSucceeded(event -> {Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.setContentText("The file has been saved!");

            alert.showAndWait();
        });

        dataSaverThread.start();

    }

    public void readFile(){
        FileChooser fileChooser = new FileChooser();
        ScrollList.getItems().clear();
        data.clear();
        clearTextFields();
        String fileType = null;
        ListForClaimsHistory.getItems().clear();


        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel csv-file", "*.csv"));
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

                        if (finalFileType.equals("Excel csv-file")) {
                            ReadCSV read = new ReadCSV(selectedFile);
                            data.addAll(read.getFileData());

                        }/* else if (finalFileType.equals("Java object")) {
                            ReadJOBJ read = new ReadJOBJ(selectedFile);
                            //TODO: Make this reader work

                        }*/ else {
                            //TODO: Make a better error
                            System.err.println("Load window exited");

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
    public String unParseData(String[] string){
        String newText = "";

        for (int i = 0; i < string.length; i++){
            if(i == string.length - 1){
                newText += string[i];
            }
            else {
                newText += string[i] + ";";
            }
        }

        return newText;
    }

    public void getSelectedSkademelding(){
        btnDelHis.setDisable(false);
    }

    public void showTerms(ActionEvent actionEvent){
        if (actionEvent.getSource().equals(btnHInsuranceConditions)){
            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            try {
                this.PopupTermsScene = FXMLLoader.load(getClass().getResource("/FXML/PopupTermsH.fxml"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(PopupTermsScene);
            modalBack(primaryStage, scene);
        }
        if(actionEvent.getSource().equals(btnBInsuranceConditions)){
            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            try {
                this.PopupTermsScene = FXMLLoader.load(getClass().getResource("/FXML/PopupTermsB.fxml"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(PopupTermsScene);
            modalBack(primaryStage, scene);
        }
        if(actionEvent.getSource().equals(btnCInsuranceConditions)){
            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            try {
                this.PopupTermsScene = FXMLLoader.load(getClass().getResource("/FXML/PopupTermsF.fxml"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(PopupTermsScene);
            modalBack(primaryStage, scene);
        }
        if(actionEvent.getSource().equals(btnTInsuranceConditions1)){
            Node node = (Node) actionEvent.getSource();
            Stage primaryStage = (Stage) node.getScene().getWindow();
            try {
                this.PopupTermsScene = FXMLLoader.load(getClass().getResource("/FXML/PopupTermsR.fxml"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(PopupTermsScene);
            modalBack(primaryStage, scene);
        }
    }

    public void btnClosePopup(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }


    public void deleteData(ActionEvent actionEvent){
        //TODO: Make proper error checks
        int selectedCustomer = ScrollList.getSelectionModel().getSelectedIndex();
        String[] selectedCustomerData =  parseCustomerData(data.get(selectedCustomer));


        if(actionEvent.getSource().equals(btnDelH)){
            clearLabel(lblHInsuranceNr1);
            clearLabel(lblHInsurancePrm1);
            clearLabel(lblHDateForInsurance1);
            clearLabel(lblHAmountInsurance1);
            clearLabel(lblHAddress1);
            clearLabel(lblHType1);
            clearLabel(lblHBuildingMaterial1);
            clearLabel(lblHStandard1);
            clearLabel(lblHSquaremeter1);
            clearLabel(lblHInsuranceVB1);
            clearLabel(lblHInsuranceVC1);

            Arrays.fill(selectedCustomerData, 8, 9, "Nei");

            Arrays.fill(selectedCustomerData, 12, 25, "----------");

            btnDelH.setDisable(true);
            btnNewH.setDisable(false);
            btnHInsuranceConditions.setDisable(true);
            data.set(selectedCustomer, unParseData(selectedCustomerData));
        }
        else if(actionEvent.getSource().equals(btnDelBoat)){
            clearLabel(lblBInsuranceNr1);
            clearLabel(lblBInsurancePrm1);
            clearLabel(lblBDateForInsurance2);
            clearLabel(lblBAmountInsurance1);
            clearLabel(lblBOwner1);
            clearLabel(lblBRegNr1);
            clearLabel(lblBTypeModel1);
            clearLabel(lblHType11);
            clearLabel(lblBYear1);
            clearLabel(lblBMotor1);

            Arrays.fill(selectedCustomerData, 9, 10, "Nei");

            Arrays.fill(selectedCustomerData, 25, 36, "----------");

            btnDelBoat.setDisable(true);
            btnNewBoat.setDisable(false);
            btnBInsuranceConditions.setDisable(true);
            data.set(selectedCustomer, unParseData(selectedCustomerData));
        }
        else if(actionEvent.getSource().equals(btnDelT)){
            clearLabel(lblTInsuranceNr1);
            clearLabel(lblTInsurancePrm1);
            clearLabel(lblTDateForInsurance1);
            clearLabel(lblTAmountInsurance1);
            clearLabel(lblAreaInsurance1);
            clearLabel(lblTSumInsurance1);

            Arrays.fill(selectedCustomerData, 10, 11, "Nei");

            Arrays.fill(selectedCustomerData, 36, 46, "----------");

            btnDelT.setDisable(true);
            btnNewT.setDisable(false);
            btnTInsuranceConditions1.setDisable(true);
            data.set(selectedCustomer, unParseData(selectedCustomerData));
        }
        else if(actionEvent.getSource().equals(btnDelHis)){
            int selectedClaimsHistory = ListForClaimsHistory.getSelectionModel().getSelectedIndex();
            ListForClaimsHistory.getItems().clear();

            if(selectedClaimsHistory >= 0){
                selectedCustomerData = deleteListData(selectedCustomerData, selectedClaimsHistory);
            }
            data.set(selectedCustomer, unParseData(selectedCustomerData));
            for (int i = 57; i < selectedCustomerData.length; i++){
                ListForClaimsHistory.getItems().add(selectedCustomerData[i]);
            }
            btnDelHis.setDisable(true);
            btnCInsuranceConditions.setDisable(true);
        }

        if(actionEvent.getSource().equals(btnDelCustomer)){
            data.remove(selectedCustomer);
            ScrollList.getItems().clear();
            clearTextFields();
            if(!data.isEmpty()){
                for(String text : data){
                    String[] string = parseCustomerData(text);
                    ScrollList.getItems().add("Kundenr: " + string[0] + " " + string[1] + " " + string[2]);
                }
            }
            btnDelCustomer.setDisable(true);
        }
    }

    private String[] deleteListData(String[] oldArray, int selectedClaim){
        String[] newArray = new String[oldArray.length-1];
        int x = 0;

        for(int i = 0; i < newArray.length; i++){
            if(i == (57+selectedClaim)){
                x++;
            }

                newArray[i] = oldArray[x];
                x++;


        }
        return newArray;
    }

    private void clearLabel(Label label){
        label.setText("----------");
    }

    private static String[] parseCustomerData(String data){
        //TODO: Add exception checks with error messages
        return data.split(";");
    }

    public void getSelectedCustomer(){
        int selectedCustomer = ScrollList.getSelectionModel().getSelectedIndex();
        String[] selectedCustomerData = parseCustomerData(data.get(selectedCustomer));

        btnDelCustomer.setDisable(false);

        if (selectedCustomerData[8].equals("Ja")){
            btnDelH.setDisable(false);
            btnNewH.setDisable(true);
            btnHInsuranceConditions.setDisable(false);
        }
        else{
            btnDelH.setDisable(true);
            btnNewH.setDisable(false);
            btnHInsuranceConditions.setDisable(true);
        }
        if(selectedCustomerData[9].equals("Ja")){
            btnDelBoat.setDisable(false);
            btnNewBoat.setDisable(true);
            btnBInsuranceConditions.setDisable(false);
        }
        else{
            btnDelBoat.setDisable(true);
            btnNewBoat.setDisable(false);
            btnBInsuranceConditions.setDisable(true);
        }
        if(selectedCustomerData[10].equals("Ja")){
            btnDelT.setDisable(false);
            btnNewT.setDisable(true);
            btnTInsuranceConditions1.setDisable(false);
        }
        else{
            btnDelT.setDisable(true);
            btnNewT.setDisable(false);
            btnTInsuranceConditions1.setDisable(true);
        }
        if(selectedCustomerData[11].equals("Ja")){
            btnDelC.setDisable(false);
            btnNewC.setDisable(true);
            btnCInsuranceConditions.setDisable(false);
        }
        else{
            btnDelC.setDisable(true);
            btnNewC.setDisable(false);
            btnCInsuranceConditions.setDisable(true);
        }

        //"Oversikt" tab'en
        lblOCustomer.setText("Kundenr: " + selectedCustomerData[0] + " | Navn: " + selectedCustomerData[1] + " " + selectedCustomerData[2] + " | Personnr: " + selectedCustomerData[3]);
        lblOAddress.setText("Faktureringsadresse: " + selectedCustomerData[4] + ", " + selectedCustomerData[5] + " " + selectedCustomerData[6]);
        lblOCustomerStart.setText("Kundeforhold opprettet: " + selectedCustomerData[7]);
        lblOYN1.setText(selectedCustomerData[8]);
        lblOYN2.setText(selectedCustomerData[9]);
        lblOYN3.setText(selectedCustomerData[10]);
        lblOYN4.setText(selectedCustomerData[11]);

        //"Hus og innbo" tab'en
        lblHInsuranceNr1.setText(selectedCustomerData[12]);
        lblHInsurancePrm1.setText(selectedCustomerData[13]);
        lblHDateForInsurance1.setText(selectedCustomerData[14]);
        lblHAmountInsurance1.setText(selectedCustomerData[15]);
        lblHAddress1.setText(selectedCustomerData[16] + ", " + selectedCustomerData[17] + " " + selectedCustomerData[18]);
        lblHType1.setText(selectedCustomerData[19]);
        lblHBuildingMaterial1.setText(selectedCustomerData[20]);
        lblHStandard1.setText(selectedCustomerData[21]);
        lblHSquaremeter1.setText(selectedCustomerData[22]);
        lblHInsuranceVB1.setText(selectedCustomerData[23]);
        lblHInsuranceVC1.setText(selectedCustomerData[24]);

        //"Båtforsikring" tab'en
        lblBInsuranceNr1.setText(selectedCustomerData[25]);
        lblBInsurancePrm1.setText(selectedCustomerData[26]);
        lblBDateForInsurance2.setText(selectedCustomerData[27]);
        lblBAmountInsurance1.setText(selectedCustomerData[28]);
        lblBOwner1.setText(selectedCustomerData[29] + " " + selectedCustomerData[30]);
        lblBRegNr1.setText(selectedCustomerData[31]);
        lblBTypeModel1.setText(selectedCustomerData[32]);
        lblHType11.setText(selectedCustomerData[33]);
        lblBYear1.setText(selectedCustomerData[34]);
        lblBMotor1.setText(selectedCustomerData[35]);

        //"Reiseforsikring" tab'en
        lblTInsuranceNr1.setText(selectedCustomerData[36]);
        lblTInsurancePrm1.setText(selectedCustomerData[37]);
        lblTDateForInsurance1.setText(selectedCustomerData[38]);
        lblTAmountInsurance1.setText(selectedCustomerData[39]);
        lblAreaInsurance1.setText(selectedCustomerData[40] + ", " + selectedCustomerData[41] + ", " + selectedCustomerData[42] + ", " + selectedCustomerData[43] + ", " + selectedCustomerData[44]);
        lblTSumInsurance1.setText(selectedCustomerData[45]);

        //"Fritidsboligforsikring" tab'en
        lblCInsuranceNr1.setText(selectedCustomerData[46]);
        lblCInsurancePrm1.setText(selectedCustomerData[47]);
        lblCDateForInsurance1.setText(selectedCustomerData[48]);
        lblCAmountInsurance1.setText(selectedCustomerData[49]);
        lblCAddress1.setText(selectedCustomerData[50]);
        lblCType1.setText(selectedCustomerData[51]);
        lblCBuildingMaterial1.setText(selectedCustomerData[52]);
        lblCStandard1.setText(selectedCustomerData[53]);
        lblCSquaremeter1.setText(selectedCustomerData[54]);
        lblCInsuranceVB1.setText(selectedCustomerData[55]);
        lblCInsuranceVC1.setText(selectedCustomerData[56]);

        //"Skademeldinger/Historikk" tab'en
        for (int i = 57; i < selectedCustomerData.length; i++){
            ListForClaimsHistory.getItems().add(selectedCustomerData[i]);
        }
    }



    public void btnNykunde(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyKundeScene = FXMLLoader.load(getClass().getResource("/FXML/NyKunde.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyKundeScene);
        modalBack(primaryStage, scene);
    }

    public void btnNyHus(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.NyHusScene = FXMLLoader.load(getClass().getResource("/FXML/Husoginnbo.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(NyHusScene);
        modalBack(primaryStage, scene);
    }

    public void btnNewBoat(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyBåtScene = FXMLLoader.load(getClass().getResource("/FXML/Båt.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyBåtScene);
        modalBack(primaryStage, scene);
    }

    public void btnNewT(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyReiseScene = FXMLLoader.load(getClass().getResource("/FXML/Reise.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyReiseScene);
        modalBack(primaryStage, scene);
    }

    public void btnNewC(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyFritidsboligScene = FXMLLoader.load(getClass().getResource("/FXML/Fritidsbolig.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyFritidsboligScene);
        modalBack(primaryStage, scene);
    }

    public void btnNySkademelding(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nySkadeScene = FXMLLoader.load(getClass().getResource("/FXML/NySkade.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nySkadeScene);
        modalBack(primaryStage, scene);
    }

    public static void modalBack(Stage stage, Scene newScene) {
        Stage modal = new Stage();
        modal.setScene(newScene);
        modal.initOwner(stage);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.show();
    }

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