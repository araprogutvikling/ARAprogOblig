package ARAprog;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NyKundeController {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @FXML
    public TextField inputPnr, inputFirstName, inputLastName, inputAdress, inputZipCode, InputArea,
            inputPhone, inputEmail;
    public CheckBox pNrCheck, firstNameCheck, checkLastName, checkAdress, checkZip, tlfCheck, emailCheck, checkArea;
    public Button buttonLagNyKunde;



    public void lagNyKundeOnClick(ActionEvent actionEvent){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        String kundeNr = String.format("%06d", number);
        String pNr = inputPnr.getText();
        String firstName = inputFirstName.getText();
        String lastName = inputLastName.getText();
        String adress = inputAdress.getText();
        String zipCode = inputZipCode.getText();
        String area = InputArea.getText();
        String currentDate = dateFormat.format(date);
        String emptyData = "";

        for (int i = 12; i < 57; i++){
            emptyData += ";----------";
        }

        String newData = kundeNr + ";" + firstName + ";" + lastName + ";" + pNr + ";" + adress + ";" + zipCode + ";" + area + ";" + currentDate + ";Nei;Nei;Nei;Nei" + emptyData;

        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();

        //Får dessverre ikke dette til å funke i tide...
        //Controller controller = new Controller();
        //controller.createNewData(newData, "Customer");


    }

    public void btnNyKundeLukk(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }

    public void verifyArea(KeyEvent keyEvent){
        String tempArea = InputArea.getText();
        boolean correctArea = isAlpha(tempArea);
        setChecked(correctArea, InputArea, checkArea);
        checkBoxSelected();
    }

    public void verifyFirsName(KeyEvent keyEvent){
        String tempFirstname = inputFirstName.getText();
        boolean correctFirstName = isAlpha(tempFirstname);
        setChecked(correctFirstName, inputFirstName, firstNameCheck);
        checkBoxSelected();
    }

    public void verifyLastName(KeyEvent keyEvent){
        String tempLastName = inputLastName.getText();
        boolean correctLastName = isAlpha(tempLastName);
        setChecked(correctLastName, inputLastName, checkLastName);
        checkBoxSelected();
    }

    public void verifyAdress (KeyEvent keyEvent){
        String tempAdress = inputAdress.getText();
        boolean correctAdress = checkAdress(tempAdress);
        setChecked(correctAdress, inputAdress, checkAdress);
        checkBoxSelected();
    }

    public void verifyZipcode(){
        String tempZipCode = inputZipCode.getText();
        boolean correctZip = checkZip(tempZipCode);
        setChecked(correctZip, inputZipCode, checkZip);
        checkBoxSelected();
    }

    public void verifyPnr(KeyEvent keyEvent) {
        String tempin = inputPnr.getText();
        boolean corectPnr = checkPnr(tempin);
        setChecked(corectPnr, inputPnr, pNrCheck);
        checkBoxSelected();
    }

    public void verifyTlfNr(KeyEvent keyEvent){
        String tempTlf = inputPhone.getText();
        boolean correctTlf = checkTlf(tempTlf);
        setChecked(correctTlf, inputPhone, tlfCheck);
        checkBoxSelected();
    }

    public void verifyEmail(KeyEvent keyEvent){
        String tempEmail = inputEmail.getText();
        boolean correctEmail = checkEmail(tempEmail);
        setChecked(correctEmail, inputEmail, emailCheck);
        checkBoxSelected();
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

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(s);
        return matcher.find();
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
        if (s.length()!=4){
            return false;
        }
        try {
            int temp = Integer.parseInt(s);
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

    public static boolean activateRegisterBTN(CheckBox... checkBoxes) {
        int x = checkBoxes.length;
        int i = 0;
        for(CheckBox checkBox : checkBoxes){
            if(checkBox.isSelected()){
                i++;
            }
        }
        if (x == i){
            return true;
        }
        return false;
    }

    public void checkBoxSelected(){
        if (activateRegisterBTN(pNrCheck, firstNameCheck, checkLastName, checkAdress, checkZip, tlfCheck, emailCheck, checkArea)){
            buttonLagNyKunde.setDisable(false);
        }
        else {
            buttonLagNyKunde.setDisable(true);
        }
    }

}