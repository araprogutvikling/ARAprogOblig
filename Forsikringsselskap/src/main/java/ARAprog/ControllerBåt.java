package ARAprog;


import ARAprog.GenerateNew.NewCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControllerBåt {
    @FXML
    public TextField BInputPremium, bInputOwner, BInputAmount, inputbRegNr, inputBLength, inputBModel, inputBStrength,
            inputBType;
    public CheckBox bPremiumCb, bAmountCb, bOwnerCb, bRegNrCb, bTypeCb, bLengthCb, bModelCb, bStrengthCb;
    public Button buttonOpprettNyBåt, buttonLukkOpprettNyBåt;
    @FXML
    public Parent loadingScene;


    public void opprettNyBåt(ActionEvent actionEvent){
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
    public void lukkOpprettNyBåt(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
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

    public void verifyBpremium (KeyEvent keyEvent){
        String tempArea = BInputPremium.getText();
        boolean correctArea = checkNumbers(tempArea);
        setChecked(correctArea, BInputPremium, bPremiumCb);
    }
    public void verifyBOwner (KeyEvent keyEvent){
        String tempOwnerPnr = bInputOwner.getText();
        boolean correctPnr = checkPnr(tempOwnerPnr);
        setChecked(correctPnr, bInputOwner, bAmountCb);
    }
    public void verifyBAmount (KeyEvent keyEvent){
        String tempBamount = BInputAmount.getText();
        boolean correctBAmount = checkNumbers(tempBamount);
        setChecked(correctBAmount, BInputAmount, bOwnerCb);
    }
    public void verifyBRegNr (KeyEvent keyEvent){
        String tempreg = inputbRegNr.getText();
        boolean correctReg = CheckReg(tempreg);
        setChecked(correctReg, inputbRegNr, bRegNrCb);
    }
    public void verifyBLength (KeyEvent keyEvent){
        String tempLength = inputBLength.getText();
        boolean correctLength = checkNumbers(tempLength);
        setChecked(correctLength, inputBLength, bTypeCb);
    }
    public void verifyBModel (KeyEvent keyEvent){
        String tempModell = inputBModel.getText();
        boolean correctModell = isAlpha(tempModell);
        setChecked(correctModell, inputBModel, bLengthCb);
    }
    public void verifyBStrength (KeyEvent keyEvent){
        String tempHP = inputBStrength.getText();
        boolean correctHP = checkNumbers(tempHP);
        setChecked(correctHP, inputBStrength, bModelCb);
    }
    public void verifyBType (KeyEvent keyEvent){
        String tempType = inputBType.getText();
        boolean correctType = isAlpha(tempType);
        setChecked(correctType, inputBType, bStrengthCb);
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
    public boolean CheckReg(String s){
        if (s.length()==0){
            return false;
        }
        if (s.length()!= 7){
            return false;
        }
        for (int i = 2; i < s.length(); i++){
            if (!Character.isUpperCase(s.charAt(i))){
                return false;
            }
        }
        for (int i = 0; i < 2; i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
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
    public boolean checkNumbers(String s){
    if (s.isEmpty()){
        return false;
    }
        try {
        long premium = Long.parseLong(s);
    }
        catch (NumberFormatException nfe){
        return false;
    }
        return true;
}



}
