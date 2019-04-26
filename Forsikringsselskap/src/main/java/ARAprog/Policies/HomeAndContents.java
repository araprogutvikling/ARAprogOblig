package ARAprog.Policies;

import ARAprog.Persons.Person;

public class HomeAndContents extends Polices {

    private Person homeOwner;
    private String homeAdress;
    private String homeBuildYear;
    private String homeType;
    private String homeMaterial;
    private String standar; //TODO: finne ut hva som menes med "Standar". Spør Annette!
    private String homeSquareM;
    private double homeInsuredFor;
    private double ContentInsuredFor;

    public HomeAndContents(int plcsPremium, int plcsPayOut, String plcsTerms, Person homeOwner, String homeAdress,
                           String homeBuildYear, String homeType, String homeMaterial, String standar, String homeSquareM,
                           double homeInsuredFor, double contentInsuredFor) {

        super(plcsPremium, plcsPayOut, plcsTerms);

        this.homeOwner = homeOwner;
        this.homeAdress = homeAdress;
        this.homeBuildYear = homeBuildYear;
        this.homeType = homeType;
        this.homeMaterial = homeMaterial;
        this.standar = standar;
        this.homeSquareM = homeSquareM;
        this.homeInsuredFor = homeInsuredFor;
        this.ContentInsuredFor = contentInsuredFor;
    }

    //Getter for Home
    public Person getHomeOwner() {
        return homeOwner;
    }
    public String getHomeAdress() {
        return homeAdress;
    }
    public String getHomeBuildYear() {
        return homeBuildYear;
    }
    public String getHomeType() {
        return homeType;
    }
    public String getHomeMaterial() {
        return homeMaterial;
    }
    public String getStandar() {
        return standar;
    }
    public String getHomeSquareM() {
        return homeSquareM;
    }
    public double getHomeInsuredFor() {
        return homeInsuredFor;
    }
    public double getContentInsuredFor() {
        return ContentInsuredFor;
    }

    //Setter for Home
    public void setHomeOwner(Person homeOwner) {
        this.homeOwner = homeOwner;
    }
    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }
    public void setHomeBuildYear(String homeBuildYear) {
        this.homeBuildYear = homeBuildYear;
    }
    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }
    public void setHomeMaterial(String homeMaterial) {
        this.homeMaterial = homeMaterial;
    }
    public void setStandar(String standar) {
        this.standar = standar;
    }
    public void setHomeSquareM(String homeSquareM) {
        this.homeSquareM = homeSquareM;
    }
    public void setHomeInsuredFor(double homeInsuredFor) {
        this.homeInsuredFor = homeInsuredFor;
    }
    public void setContentInsuredFor(double contentInsuredFor) {
        ContentInsuredFor = contentInsuredFor;
    }
}
