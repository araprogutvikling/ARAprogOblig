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
        boolean correctArea = checkPremium(tempArea);
        setChecked(correctArea, BInputPremium, bPremiumCb);
    }
    public void verifyBOwner (KeyEvent keyEvent){
        String tempArea = bInputOwner.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, bInputOwner, bAmountCb);
    }
    public void verifyBAmount (KeyEvent keyEvent){
        String tempArea = BInputAmount.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, BInputAmount, bOwnerCb);
    }
    public void verifyBRegNr (KeyEvent keyEvent){
        String tempArea = inputbRegNr.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, inputbRegNr, bRegNrCb);
    }
    public void verifyBLength (KeyEvent keyEvent){
        String tempArea = inputBLength.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, inputBLength, bTypeCb);
    }
    public void verifyBModel (KeyEvent keyEvent){
        String tempArea = inputBModel.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, inputBModel, bLengthCb);
    }
    public void verifyBStrength (KeyEvent keyEvent){
        String tempArea = inputBStrength.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, inputBStrength, bModelCb);
    }
    public void verifyBType (KeyEvent keyEvent){
        String tempArea = inputBType.getText();
        boolean correctArea = checkArea(tempArea);
        setChecked(correctArea, inputBType, bStrengthCb);
    }



}
