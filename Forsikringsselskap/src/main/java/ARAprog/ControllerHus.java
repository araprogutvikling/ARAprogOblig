package ARAprog;

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

public class ControllerHus {

    @FXML
    public TextField hInputPremium, hInputAddress, inputHType, inputHStandard, inputHSquareM,
            inputHAmountB, inputHMaterial, inputHAmountC;
    public CheckBox hPremiumCb, hAddressCb, hTypeCb, hStandardCb, hSquaremeterCb, hAmountBCb, hMaterialCb,
    hAmountICb;
    public Button buttonOpprettNyHus, buttonLukkOpprettNyHus;
    public Parent loadingScene;

    public void OpprettNyHus(ActionEvent actionEvent){
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

    public void lukkOpprettNyhus(ActionEvent actionEvent){
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

    public void verifyHpremium (KeyEvent keyEvent){
        String tempHpremium = hInputPremium.getText();
        boolean checkHpremium = checkerHpremium(tempHpremium);
        setChecked(checkHpremium, hInputPremium, hPremiumCb);
    }
    public void verifyHAddress (KeyEvent keyEvent){
        String tempAddress = hInputAddress.getText();
        boolean checkAddres = checkAddres(tempAddress);
        setChecked(checkAddres, hInputAddress, hAddressCb);
    }

    public void verifyHType (KeyEvent keyEvent){
        String tempType = inputHType.getText();
        boolean correctType = isAlpha(tempType);
        setChecked(correctType, inputHType, hTypeCb);
    }

    public void verifyHStandard (KeyEvent keyEvent){
        String tempStandar = inputHStandard.getText();
        boolean correctStandard = isAlpha(tempStandar);
        setChecked(correctStandard, inputHStandard, hStandardCb);
    }
    public void verifyHSquareM (KeyEvent keyEvent){
        String tempSquere = inputHSquareM.getText();
        boolean correctSquere = checkAmount(tempSquere);
        setChecked(correctSquere, inputHSquareM, hSquaremeterCb);
    }
    public void verifyHAmountB (KeyEvent keyEvent){
        String tempAmountB = inputHAmountB.getText();
        boolean correctAmountB = checkAmount(tempAmountB);
        setChecked(correctAmountB, inputHAmountB, hAmountBCb);
    }
    public void verifyHMaterial (KeyEvent keyEvent){
        String tempMaterial = inputHMaterial.getText();
        boolean correctMaterial = isAlpha(tempMaterial);
        setChecked(correctMaterial, inputHMaterial, hMaterialCb);
    }
    public void verifyHAmountC (KeyEvent keyEvent){
        String tempAmountC = inputHAmountC.getText();
        boolean correctAmountB = checkAmount(tempAmountC);
        setChecked(correctAmountB, inputHAmountC, hAmountICb);
    }

    public boolean checkerHpremium(String s){
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

    public boolean checkAddres (String s){
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
    public boolean checkAmount(String s){
        try{
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


}
