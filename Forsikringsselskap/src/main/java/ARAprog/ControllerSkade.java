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

public class ControllerSkade {

    @FXML
    public TextField DatoForSkade, TypeSkade, Beskrivelse, VitneNavn, VitneTlf, estimert, utbetalt;
    public CheckBox CheckbDato, CheckbType, checkBBeskrivelse, CheckbNavn, CheckbUtbetalt, CheckbEstimert, Checkb;
    public Button lagreSkade, lukkSkademelding;
    public Parent loadingScene;

    public void saveSkade(ActionEvent actionEvent){
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

    public void lukk(ActionEvent actionEvent){
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

    public void checkDato (KeyEvent keyEvent){
        String tempDato = DatoForSkade.getText();
        boolean checkDato = isDate(tempDato);
        setChecked(checkDato, DatoForSkade, CheckbDato);
    }
    public void checkType (KeyEvent keyEvent){
        String tempType = TypeSkade.getText();
        boolean checkType = isAlpha(tempType);
        setChecked(checkType, TypeSkade, CheckbType);
    }

    public void checkBeskrivelse (KeyEvent keyEvent){
        String tempType = Beskrivelse.getText();
        boolean correctType = isName(tempType);
        setChecked(correctType, Beskrivelse, checkBBeskrivelse);
    }

    public void checkVitneNavn (KeyEvent keyEvent){
        String tempNavn = VitneNavn.getText();
        boolean correctNavn = isName(tempNavn);
        setChecked(correctNavn, VitneNavn, CheckbNavn);
    }
    public void checkTlf (KeyEvent keyEvent){
        String tempTlf = VitneTlf.getText();
        boolean correctTlf = checkerTlf(tempTlf);
        setChecked(correctTlf, VitneTlf, CheckbUtbetalt);
    }
    public void checkSkadeVerdi (KeyEvent keyEvent){
        String tempSkadeV = estimert.getText();
        boolean correctSkkadeVerdi = isNumber(tempSkadeV);
        setChecked(correctSkkadeVerdi, estimert, CheckbEstimert);
    }
    public void checkUtbetalt (KeyEvent keyEvent){
        String tempUtbetalt = utbetalt.getText();
        boolean correctUtbetalt = isNumber(tempUtbetalt);
        setChecked(correctUtbetalt, utbetalt, Checkb);
    }

    public boolean isNumber(String s){
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
    public boolean checkerTlf(String s){
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
    public boolean isName(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (!Character.isUpperCase(s.charAt(0))) {
            return false;
        }
        if (!Character.isLowerCase(s.charAt(1))) {
            return false;
        }
        return true;
    }
    public boolean isDate(String s) {
        try{
            if (s.length()!=6){
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
}
