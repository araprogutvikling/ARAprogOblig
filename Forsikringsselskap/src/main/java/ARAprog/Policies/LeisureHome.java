package ARAprog.Policies;

import ARAprog.Persons.Person;

public class LeisureHome extends Polices {

    private Person leisureOwner;
    private String leisureAdress;
    private String leisureBuildYear;
    private String leisureType;
    private String leisureMaterial;
    private String leisureStandards;
    private String LeisureSquareM;
    private double leisureInsuredFor;
    private double leisureContentInsuredFor;

    public LeisureHome(int plcsPremium, int plcsPayOut, String plcsTerms, Person leisureOwner, String leisureAdress,
                       String leisureBuildYear, String leisureType, String leisureMaterial, String leisureStandards, String leisureSquareM,
                       double leisureInsuredFor, double leisureContentInsuredFor) {

        super(plcsPremium, plcsPayOut, plcsTerms);

        this.leisureOwner = leisureOwner;
        this.leisureAdress = leisureAdress;
        this.leisureBuildYear = leisureBuildYear;
        this.leisureType = leisureType;
        this.leisureMaterial = leisureMaterial;
        this.leisureStandards = leisureStandards;
        this.LeisureSquareM = leisureSquareM;
        this.leisureInsuredFor = leisureInsuredFor;
        this.leisureContentInsuredFor = leisureContentInsuredFor;
    }

    //Getter for Leisure
    public Person getLeisureOwner() {
        return leisureOwner;
    }
    public String getLeisureAdress() {
        return leisureAdress;
    }
    public String getLeisureBuildYear() {
        return leisureBuildYear;
    }
    public String getLeisureType() {
        return leisureType;
    }
    public String getLeisureMaterial() {
        return leisureMaterial;
    }
    public String getLeisureStandards() {
        return leisureStandards;
    }
    public String getLeisureSquareM() {
        return LeisureSquareM;
    }
    public double getLeisureInsuredFor() {
        return leisureInsuredFor;
    }
    public double getLeisureContentInsuredFor() {
        return leisureContentInsuredFor;
    }

    //Setter for Leisure
    public void setLeisureOwner(Person leisureOwner) {
        this.leisureOwner = leisureOwner;
    }
    public void setLeisureAdress(String leisureAdress) {
        this.leisureAdress = leisureAdress;
    }
    public void setLeisureBuildYear(String leisureBuildYear) {
        this.leisureBuildYear = leisureBuildYear;
    }
    public void setLeisureType(String leisureType) {
        this.leisureType = leisureType;
    }
    public void setLeisureMaterial(String leisureMaterial) {
        this.leisureMaterial = leisureMaterial;
    }
    public void setLeisureStandards(String leisureStandards) {
        this.leisureStandards = leisureStandards;
    }
    public void setLeisureSquareM(String leisureSquareM) {
        LeisureSquareM = leisureSquareM;
    }
    public void setLeisureInsuredFor(double leisureInsuredFor) {
        this.leisureInsuredFor = leisureInsuredFor;
    }
    public void setLeisureContentInsuredFor(double leisureContentInsuredFor) {
        this.leisureContentInsuredFor = leisureContentInsuredFor;
    }
}
