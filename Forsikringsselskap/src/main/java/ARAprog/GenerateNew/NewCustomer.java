package ARAprog.GenerateNew;

import ARAprog.Controller;
import ARAprog.Persons.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCustomer {
    int pNr;
    @FXML
    TextField InputPnr;

    public Customer saveNewCustumer(){
        customerNewPnr();
        Customer newCustomer;
        //newCustomer = new Customer(pNr, inputAge.getText(), inputFirstName.getText(),
              //  inputLastName.getText(), inputAdress.getText(), inputZipCode.getText(), InputArea.getText(),
               // inputPhone.getText(), inputEmail.getText());

    return null;
    }
    public boolean isANumber(String s){
        String regex="\\d+";
        return s.matches(regex);//returns true if input and regex matches otherwise false;
    }

    public int customerNewPnr() {
        String customerPnrtemp = InputPnr.getText();
        if (customerPnrtemp.length() < 10){

        }
        if (customerPnrtemp.length() > 10){

        }
        if (!isANumber(customerPnrtemp)) {

        }
            pNr = Integer.parseInt(customerPnrtemp);
            return pNr;
        }
    }

