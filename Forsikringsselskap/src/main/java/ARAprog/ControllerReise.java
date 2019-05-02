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

public class ControllerReise {


    @FXML
    public Parent loadingScene;
    public TextField tInputPremium, tInputArea, tInputAmount, inputTSum;
    public CheckBox tPremiumCb, tAreaCb, tAmountCb, tSumCb;
    public Button buttonOpprettNyReise, buttonLukkOpprettNyReise;


    public void opprettNyReise(ActionEvent actionEvent) {
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

    public void lukkOpprettNyReise(ActionEvent actionEvent) {
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

    public void verifyTpremium(KeyEvent keyEvent) {
    String tempTPremium = tInputPremium.getText();
    boolean checkTPremium = checkerTPremium (tempTPremium);
    setChecked(checkTPremium, tInputPremium, tPremiumCb);

    }

    public void verifyTArea(KeyEvent keyEvent) {
        String tempTArea = tInputArea.getText();
        boolean checkTArea = isAlpha (tempTArea);
        setChecked(checkTArea, tInputArea, tAreaCb);

    }
    public void verifyTAmount(KeyEvent keyEvent) {
        String tempTAmount = tInputAmount.getText();
        boolean checkTAmount = checkerTPremium (tempTAmount);
        setChecked(checkTAmount, tInputAmount, tAmountCb);

    }
    public void verifyTSum(KeyEvent keyEvent) {
        String tempTSum = inputTSum.getText();
        boolean checkTSum = checkerTPremium (tempTSum);
        setChecked(checkTSum, inputTSum, tSumCb);

    }

    public boolean checkerTPremium(String s) {
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

}





