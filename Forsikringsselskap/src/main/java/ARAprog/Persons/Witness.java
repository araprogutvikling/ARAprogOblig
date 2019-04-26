package ARAprog.Persons;

public class Witness extends Person {

    private Customer witnessFor;

    public Witness(int prsnPnr, int prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress,
                   String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr, Customer witnessFor) {
        super(prsnPnr, prsnAge, prsnFirstName, prsnLastName, prsnAdress, prsnAreaCode, prsnPostAlarea, prsnEMail, prsnTlfNr);
        this.witnessFor = witnessFor;
    }

    public Customer getWitnessFor() {
        return witnessFor;
    }

    public void setWitnessFor(Customer witnessFor) {
        this.witnessFor = witnessFor;
    }
}