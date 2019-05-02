package ARAprog.Controllers;

import ARAprog.GenerateNew.NewCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class NyKundeController {

    @FXML
    public TextField inputPnr, inputFirstName, inputLastName, inputAdress, inputZipCode, InputArea,
            inputPhone, inputEmail;
    public CheckBox pNrCheck, firstNameCheck, checkLastName, checkAdress, checkZip, tlfCheck, emailCheck;
    public Parent loadingScene;



    public void LagNyKundeOnClick(ActionEvent actionEvent){
        NewCustomer customer = new NewCustomer();
        customer.saveNewCustumer();
        try{
            Node node = (Node) actionEvent.getSource();
            Stage loadingStage = (Stage) node.getScene().getWindow();
            this.loadingScene = FXMLLoader.load(getClass().getResource("/FXML/Loading.fxml"));
            Scene scene = new Scene(loadingScene);
            loadingStage.setScene(scene);
            loadingStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnNyKundeLukk(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }

    public void verifyFirsName(KeyEvent keyEvent){
        String tempFirstname = inputFirstName.getText();
        boolean correctFirstName = isAlpha(tempFirstname);
        setChecked(correctFirstName, inputFirstName, firstNameCheck);
    }

    public void verifyLastName(KeyEvent keyEvent){
        String tempLastName = inputLastName.getText();
        boolean correctLastName = isAlpha(tempLastName);
        setChecked(correctLastName, inputLastName, checkLastName);
    }

    public void verifyAdress (KeyEvent keyEvent){
        String tempAdress = inputAdress.getText();
        boolean correctAdress = checkAdress(tempAdress);
        setChecked(correctAdress, inputAdress, checkAdress);
    }

    public void verifyZipcode(){
        String tempZipCode = inputZipCode.getText();
        boolean correctZip = checkZip(tempZipCode);
        setChecked(correctZip, inputZipCode, checkZip);
    }

    public void verifyPnr(KeyEvent keyEvent) {
        String tempin = inputPnr.getText();
        boolean corectPnr = checkPnr(tempin);
        setChecked(corectPnr, inputPnr, pNrCheck);
    }

    public void verifyTlfNr(KeyEvent keyEvent){
        String tempTlf = inputPhone.getText();
        boolean correctTlf = checkTlf(tempTlf);
        setChecked(correctTlf, inputPhone, tlfCheck);
    }

    public void verifyEmail(KeyEvent keyEvent){
        String tempEmail = inputEmail.getText();
        boolean correctEmail = checkEmail(tempEmail);
        setChecked(correctEmail, inputEmail, emailCheck);
    }

    public void setChecked(boolean check, TextField t, CheckBox b){
        if (!check){
            t.setStyle("-fx-border-color: red;");
            b.setSelected(check);
            b.setStyle("-fx-border-color: transparent");
        }
        else {
            t.setStyle("-fx-border-color: transparent");
            b.setSelected(check);
            b.setStyle("-fx-border-color: green");
        }
    }

    public boolean checkEmail(String s){
        if (s.length() != 0){
            return false;
        }
        if (!s.contains("@")){
            return false;
        }
        String [] splittAlpha = s.split("@");
        if (splittAlpha.length != 2){
            return false;
        }
        return true;

    }

    public boolean checkTlf(String s){
        if (s.length()!=8){
            return false;
        }
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkPnr(String s) {
        try{
            if (s.length()!=11){
                return false;
            }
            long temp = Long.parseLong(s);
            if (temp <= 0 ){
                return false;
            }
        }
        catch (NumberFormatException nfe) {
            return false;

        }
        return true;
    }

    public boolean checkZip(String s){
        if (s.length()==0){
            return false;
        }
        if (s.length()!=4){
            return false;
        }
        try {
            long temp = Long.parseLong(s);
            if (temp <= 0 ){
                return false;
            }
        }
        catch (NumberFormatException nfe) {
            return false;

        }
        return true;
    }

    public boolean checkAdress(String s){
        if (s.length()==0){
            return false;
        }
        if (!Character.isUpperCase(s.charAt(0))){
            return false;
        }
        return true;
    }

    public boolean isAlpha(String s) {
        if (s.length()==0){
            return false;
        }
        if (!Character.isUpperCase(s.charAt(0))){
            return false;
        }
        for (int i = 1; i < s.length(); i++){
            if (!Character.isLowerCase(s.charAt(i))){
                return false;
            }
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}