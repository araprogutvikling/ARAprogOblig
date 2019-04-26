package ARAprog.Persons;

import java.io.Serializable;

public abstract class Person implements Serializable{
//Datafelt for person
    private int prsnPnr;
    private int prsnAge;
    private String prsnFirstName;
    private String prsnLastName;
    private String prsnAdress;
    private String prsnAreaCode;
    private String prsnPostAlarea;
    private String prsnEMail;
    private String prsnTlfNr;
//Konstruktør for Person
    public Person(int prsnPnr, int prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress,
                  String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr) {

        this.prsnPnr = prsnPnr;
        this.prsnAge = prsnAge;
        this.prsnFirstName = prsnFirstName;
        this.prsnLastName = prsnLastName;
        this.prsnAdress = prsnAdress;
        this.prsnAreaCode = prsnAreaCode;
        this.prsnPostAlarea = prsnPostAlarea;
        this.prsnEMail = prsnEMail;
        this.prsnTlfNr = prsnTlfNr;
    }
//Gettere for person
    public int getPrsnPnr() {
        return prsnPnr;
    }
    public int getPrsnAge() {
        return prsnAge;
    }
    public String getPrsnFirstName() {
        return prsnFirstName;
    }
    public String getPrsnLastName() {
        return prsnLastName;
    }
    public String getPrsnAdress() {
        return prsnAdress;
    }
    public String getPrsnAreaCode() {
        return prsnAreaCode;
    }
    public String getPrsnPostAlarea() {
        return prsnPostAlarea;
    }
    public String getPrsnEMail() {
        return prsnEMail;
    }
    public String getPrsnTlfNr() {
        return prsnTlfNr;
    }

//Settere for person
    public void setPrsnPnr(int prsnPnr) {
        this.prsnPnr = prsnPnr;
    }
    public void setPrsnAge(int prsnAge) {
        this.prsnAge = prsnAge;
    }
    public void setPrsnFirstName(String prsnFirstName) {
        this.prsnFirstName = prsnFirstName;
    }
    public void setPrsnLastName(String prsnLastName) {
        this.prsnLastName = prsnLastName;
    }
    public void setPrsnAdress(String prsnAdress) {
        this.prsnAdress = prsnAdress;
    }
    public void setPrsnAreaCode(String prsnAreaCode) {
        this.prsnAreaCode = prsnAreaCode;
    }
    public void setPrsnPostAlarea(String prsnPostAlarea) {
        this.prsnPostAlarea = prsnPostAlarea;
    }
    public void setPrsnEMail(String prsnEMail) {
        this.prsnEMail = prsnEMail;
    }
    public void setPrsnTlfNr(String prsnTlfNr) {
        this.prsnTlfNr = prsnTlfNr;
    }

}
