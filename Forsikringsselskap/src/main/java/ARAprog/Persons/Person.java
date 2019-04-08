package ARAprog.Persons;

public class Person {

    private int pPnr;
    private int pAge;
    private String pFirstName;
    private String pLastname;
    private String pAdress;
    private String pAreacode;
    private String pPostalarea;

    public Person(int pPnr, int pAge, String pFirstName, String pLastname, String pAdress, String pAreacode, String pPostalarea) {
        this.pPnr = pPnr;
        this.pAge = pAge;
        this.pFirstName = pFirstName;
        this.pLastname = pLastname;
        this.pAdress = pAdress;
        this.pAreacode = pAreacode;
        this.pPostalarea = pPostalarea;
    }

    public int getpPnr() {
        return pPnr;
    }

    public void setpPnr(int pPnr) {
        this.pPnr = pPnr;
    }

    public int getpAge() {
        return pAge;
    }

    public String getpFirstName() {
        return pFirstName;
    }

    public String getpLastname() {
        return pLastname;
    }

    public String getpAdress() {
        return pAdress;
    }

    public String getpAreacode() {
        return pAreacode;
    }

    public String getpPostalarea() {
        return pPostalarea;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public void setpLastname(String pLastname) {
        this.pLastname = pLastname;
    }

    public void setpAdress(String pAdress) {
        this.pAdress = pAdress;
    }

    public void setpAreacode(String pAreacode) {
        this.pAreacode = pAreacode;
    }

    public void setpPostalarea(String pPostalarea) {
        this.pPostalarea = pPostalarea;
    }

}

