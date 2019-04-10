package ARAprog.Persons;

public class Customer extends Person{

    private int Customernr;

    public Customer(int prsnPnr, int prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress, String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr) {
        super(prsnPnr, prsnAge, prsnFirstName, prsnLastName, prsnAdress, prsnAreaCode, prsnPostAlarea, prsnEMail, prsnTlfNr);
    }

    public int getCustomernr() {
        return Customernr;
    }

    public void setCustomernr(int customernr) {
        Customernr = customernr;
    }
}
