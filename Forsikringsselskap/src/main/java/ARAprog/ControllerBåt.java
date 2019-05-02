package ARAprog;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControllerBåt {

    @FXML
    public TextField BInputPremium, bInputOwner, BInputAmount, inputbRegNr, inputBLength, inputBModel, inputBStrength,
        inputBType;
    public CheckBox bPremiumCb, bAmountCb, bOwnerCb, bRegNrCb, bTypeCb, bLengthCb, bModelCb, bStrengthCb;
    public Button buttonOpprettNyBåt, buttonLukkOpprettNyBåt;

}
