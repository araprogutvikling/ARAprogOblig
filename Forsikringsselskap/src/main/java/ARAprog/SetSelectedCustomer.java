package ARAprog;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class SetSelectedCustomer {
    public ListView ListForClaimsHistory;
    public ListView ScrollList;
    public Label lblOCustomer, lblOAddress, lblOCustomerStart, lblOYN1, lblOYN2, lblOYN3, lblOYN4, lblHInsuranceNr1,
            lblHInsurancePrm1, lblHAddress1, lblHType1, lblHBuildingMaterial1, lblHStandard1, lblHSquaremeter1,
            lblHInsuranceVB1, lblHDateForInsurance1, lblHAmountInsurance1, lblBInsuranceNr1, lblBInsurancePrm1,
            lblBOwner1, lblHType11, lblBTypeModel1, lblBRegNr1, lblBYear1, lblBMotor1, lblBAmountInsurance1,
            lblBDateForInsurance2, lblTInsuranceNr1, lblTInsurancePrm1, lblTDateForInsurance1, lblTAmountInsurance1, lblTSumInsurance1,
            lblAreaInsurance1, lblCInsuranceNr1, lblCInsurancePrm1, lblCAddress1, lblCType1, lblCBuildingMaterial1, lblHInsuranceVC1,
            lblCStandard1, lblCSquaremeter1, lblCInsuranceVB1, lblCInsuranceVC1, lblCDateForInsurance1, lblCAmountInsurance1;


    public void setSelectedCustomer(int selectedCustomer, ArrayList<String> data){
        String[] selectedCustomerData = parseCustomerData(data.get(selectedCustomer));
        //"Oversikt" tab'en
        lblOCustomer.setText("Kundenr: " + selectedCustomerData[0] + " | Navn: " + selectedCustomerData[1] + " " + selectedCustomerData[2] + " | Personnr: " + selectedCustomerData[3]);
        lblOAddress.setText("Faktureringsadresse: " + selectedCustomerData[4] + ", " + selectedCustomerData[5] + " " + selectedCustomerData[6]);
        lblOCustomerStart.setText("Kundeforhold opprettet: " + selectedCustomerData[7]);
        lblOYN1.setText(selectedCustomerData[8]);
        lblOYN2.setText(selectedCustomerData[9]);
        lblOYN3.setText(selectedCustomerData[10]);
        lblOYN4.setText(selectedCustomerData[11]);

        //"Hus og innbo" tab'en
        lblHInsuranceNr1.setText(selectedCustomerData[12]);
        lblHInsurancePrm1.setText(selectedCustomerData[13]);
        lblHDateForInsurance1.setText(selectedCustomerData[14]);
        lblHAmountInsurance1.setText(selectedCustomerData[15]);
        lblHAddress1.setText(selectedCustomerData[16] + ", " + selectedCustomerData[17] + " " + selectedCustomerData[18]);
        lblHType1.setText(selectedCustomerData[19]);
        lblHBuildingMaterial1.setText(selectedCustomerData[20]);
        lblHStandard1.setText(selectedCustomerData[21]);
        lblHSquaremeter1.setText(selectedCustomerData[22]);
        lblHInsuranceVB1.setText(selectedCustomerData[23]);
        lblHInsuranceVC1.setText(selectedCustomerData[24]);

        //"Båtforsikring" tab'en
        lblBInsuranceNr1.setText(selectedCustomerData[25]);
        lblBInsurancePrm1.setText(selectedCustomerData[26]);
        lblBDateForInsurance2.setText(selectedCustomerData[27]);
        lblBAmountInsurance1.setText(selectedCustomerData[28]);
        lblBOwner1.setText(selectedCustomerData[29] + " " + selectedCustomerData[30]);
        lblBRegNr1.setText(selectedCustomerData[31]);
        lblBTypeModel1.setText(selectedCustomerData[32]);
        lblHType11.setText(selectedCustomerData[33]);
        lblBYear1.setText(selectedCustomerData[34]);
        lblBMotor1.setText(selectedCustomerData[35]);

        //"Reiseforsikring" tab'en
        lblTInsuranceNr1.setText(selectedCustomerData[36]);
        lblTInsurancePrm1.setText(selectedCustomerData[37]);
        lblTDateForInsurance1.setText(selectedCustomerData[38]);
        lblTAmountInsurance1.setText(selectedCustomerData[39]);
        lblAreaInsurance1.setText(selectedCustomerData[40] + ", " + selectedCustomerData[41] + ", " + selectedCustomerData[42] + ", " + selectedCustomerData[43] + ", " + selectedCustomerData[44]);
        lblTSumInsurance1.setText(selectedCustomerData[45]);

        //"Fritidsboligforsikring" tab'en
        lblCInsuranceNr1.setText(selectedCustomerData[46]);
        lblCInsurancePrm1.setText(selectedCustomerData[47]);
        lblCDateForInsurance1.setText(selectedCustomerData[48]);
        lblCAmountInsurance1.setText(selectedCustomerData[49]);
        lblCAddress1.setText(selectedCustomerData[50]);
        lblCType1.setText(selectedCustomerData[51]);
        lblCBuildingMaterial1.setText(selectedCustomerData[52]);
        lblCStandard1.setText(selectedCustomerData[53]);
        lblCSquaremeter1.setText(selectedCustomerData[54]);
        lblCInsuranceVB1.setText(selectedCustomerData[55]);
        lblCInsuranceVC1.setText(selectedCustomerData[56]);

        //"Skademeldinger/Historikk" tab'en
        for (int i = 57; i < selectedCustomerData.length; i++){
            ListForClaimsHistory.getItems().add(selectedCustomerData[i]);
        }
    }

    protected static String[] parseCustomerData(String data){
        String[] customerDataList = data.split(";");
        //TODO: Add exception checks with error messages
        return customerDataList;
    }

}
