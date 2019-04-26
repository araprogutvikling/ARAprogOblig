package ARAprog.Persons;

public class Customer extends Person{
//Datafelt for Customer
    private int Customernr;
//Konstruktør for Customer
    public Customer(int prsnPnr, int prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress,
                    String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr) {

        super(prsnPnr, prsnAge, prsnFirstName, prsnLastName, prsnAdress, prsnAreaCode, prsnPostAlarea, prsnEMail, prsnTlfNr);
    }
//Getter for Customer
    public int getCustomernr() {
        return Customernr;
    }
//Setter for Customer
    public void setCustomernr(int customernr) {
        Customernr = customernr;
    }
//ToString for Customer
    @Override
    public String toString() {
        return super.toString();
    }
}
