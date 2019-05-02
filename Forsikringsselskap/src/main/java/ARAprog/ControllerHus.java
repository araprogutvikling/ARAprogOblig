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
    public TextField hInputPremium, hInputAddress, hInputAmount, inputHType, inputHStandard, inputHSquareM,
            inputHAmountB, inputHMaterial, inputHAmountC;
    public CheckBox hPremiumCb, hAddressCb, hAmountCb, hTypeCb, hStandardCb, hSquaremeterCb, hAmountBCb, hMaterialCb,
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

    public void verifyHpremium (KeyEvent keyEvent){

    }
    public void verifyHAddress (KeyEvent keyEvent){

    }
    public void verifyHAmount (KeyEvent keyEvent){

    }
    public void verifyHType (KeyEvent keyEvent){

    }
    public void verifyHStandard (KeyEvent keyEvent){

    }
    public void verifyHSquareM (KeyEvent keyEvent){

    }
    public void verifyHAmountB (KeyEvent keyEvent){

    }
    public void verifyHMaterial (KeyEvent keyEvent){

    }
    public void verifyHAmountC (KeyEvent keyEvent){

    }


}
