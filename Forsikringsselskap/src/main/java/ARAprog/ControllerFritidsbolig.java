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

import static ARAprog.NyKundeController.activateRegisterBTN;

public class ControllerFritidsbolig {
    @FXML
    public TextField cInputPremium, cInputAddress, inputCType, inputCStandard, inputCSquareM, inputCAmountB,
            inputCMaterial, inputCAmountC;
    public CheckBox cPremiumCb, cAddressCb, cTypeCb, cStandardCb, cSquaremeterCb, cAmountBCb, cAmountICb, cMaterialCb;
    public Button buttonOpprettNyFritidsB, buttonLukkOpprettNyFritidsB;
    public Parent loadingScene;

    public void OpprettNyFritidsB(ActionEvent actionEvent) {
        try {
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

    public void lukkOpprettNyFritidsB(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }

    public void setChecked(boolean check, TextField t, CheckBox b) {
        if (!check) {
            t.setStyle("-fx-border-color: red;");
            b.setSelected(check);
            b.setStyle("-fx-border-color: transparent");
        } else {
            t.setStyle("-fx-border-color: transparent");
            b.setSelected(check);
            b.setStyle("-fx-border-color: green");
        }
    }


    public void verifyCpremium(KeyEvent keyEvent) {
        String tempCPremium = cInputPremium.getText();
        boolean checkCPremium = checkerCPremium(tempCPremium);
        setChecked(checkCPremium, cInputPremium, cPremiumCb);
        checkBoxSelected();
    }

    public void verifyCAddress(KeyEvent keyEvent) {
        String tempCAddress = cInputAddress.getText();
        boolean checkCAddress = checkerCAddress(tempCAddress);
        setChecked(checkCAddress, cInputAddress, cAddressCb);
        checkBoxSelected();
    }

    public void verifyCType(KeyEvent keyEvent) {
        String tempCType = inputCType.getText();
        boolean checkCType = isAlpha(tempCType);
        setChecked(checkCType, inputCType, cTypeCb);
        checkBoxSelected();
    }

    public void verifyCStandard(KeyEvent keyEvent) {
        String tempCStandard = inputCStandard.getText();
        boolean checkCStandard = isAlpha(tempCStandard);
        setChecked(checkCStandard, inputCStandard, cStandardCb);
        checkBoxSelected();
    }

    public void verifyCSquareM(KeyEvent keyEvent) {
        String tempCSquareM = inputCSquareM.getText();
        boolean checkCSquareM = checkerCPremium(tempCSquareM);
        setChecked(checkCSquareM, inputCSquareM, cSquaremeterCb);
        checkBoxSelected();
    }

    public void verifyCAmountB(KeyEvent keyEvent) {
        String tempCAmountB = inputCAmountB.getText();
        boolean checkCAmountB = checkerCPremium(tempCAmountB);
        setChecked(checkCAmountB, inputCAmountB, cAmountBCb);
        checkBoxSelected();
    }

    public void verifyCMaterial(KeyEvent keyEvent) {
        String tempCMaterial =inputCMaterial.getText();
        boolean checkCMaterial = isAlpha(tempCMaterial);
        setChecked(checkCMaterial, inputCMaterial, cMaterialCb);
        checkBoxSelected();
    }

    public void verifyCAmountC(KeyEvent keyEvent) {
        String tempAmountC = inputCAmountC.getText();
        boolean checkCAmountC = checkerCPremium(tempAmountC);
        setChecked(checkCAmountC, inputCAmountC, cAmountICb);
        checkBoxSelected();
    }

    public boolean checkerCPremium(String s) {
        if (s.isEmpty()) {
            return false;
        }
        try {
            long premium = Long.parseLong(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkerCAddress(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (!Character.isUpperCase(s.charAt(0))) {
            return false;
        }
        return true;

    }

    public boolean isAlpha(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (!Character.isUpperCase(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLowerCase(s.charAt(i))) {
                return false;
            }
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;

    }

    public void checkBoxSelected(){
        if (activateRegisterBTN(cPremiumCb, cAddressCb, cTypeCb, cStandardCb, cSquaremeterCb, cAmountBCb, cAmountICb, cMaterialCb)){
            buttonOpprettNyFritidsB.setDisable(false);
        }
        else {
            buttonOpprettNyFritidsB.setDisable(true);
        }
    }

}












