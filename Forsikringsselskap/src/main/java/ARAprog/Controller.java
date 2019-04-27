package ARAprog;
import ARAprog.Persons.Customer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller{

    @FXML
    public Button btnNyKundeLukk;
    public Button btnNyku;
    public TextField InputPnr;
    public TextField inputAge;
    public TextField inputFirstName;
    public TextField inputLastName;
    public TextField inputAdress;
    public TextField inputZipCode;
    public TextField InputArea;
    public TextField inputPhone;
    public TextField inputEmail;

    public Parent nyKundeScene, loadingScene;

    @FXML public void initialize(){

    }

    public void LagNyKundeOnClick(ActionEvent actionEvent){
        int customerPNr = 0;
        String customerDateBirth;
        String customerFirstName;
        String CustomerLastName;
        String CustomerAdress;
        String CustomerZipcode;
        String CustomerArea;
        String CustomerPhone;
        String CustomerEmail;

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
        InputPnr.lengthProperty() = 11;
        try {
            customerPNr = Integer.parseInt(InputPnr.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


       /* Customer newCustomer;
        newCustomer = new Customer(Integer.parseInt(InputPnr.getText()), inputAge.getText(), inputFirstName.getText(),
                inputLastName.getText(), inputAdress.getText(), inputZipCode.getText(), InputArea.getText(),
                inputPhone.getText(), inputEmail.getText());*/
    }

    public void btnNykunde(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage primaryStage = (Stage) node.getScene().getWindow();
        try {
            this.nyKundeScene = FXMLLoader.load(getClass().getResource("/FXML/NyKunde.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(nyKundeScene);
        Stage modal= new Stage();
        modal.setScene(scene);
        modal.initOwner(primaryStage);
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }
    public void btnNyKundeLukk(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage modal = (Stage) node.getScene().getWindow();
        modal.close();
    }
}