package ARAprog.Policies;

import ARAprog.Persons.Customer;

public class Boat extends Polices {

    private Customer owner;
    private String boatRegNR;
    private String boatManufacturer;
    private String boatModel;
    private String boatLength;
    private String boatFeet;
    private String boatEngine;
    private String boatEngineYear;


    public Boat(int plcsPremium, int plcsPayOut, String plcsTerms, Customer owner, String boatRegNR,
                String boatManufacturer, String boatModel, String boatLength, String boatFeet, String boatEngine, String boatEngineYear) {

        super(plcsPremium, plcsPayOut, plcsTerms);

        this.owner = owner;
        this.boatRegNR = boatRegNR;
        this.boatManufacturer = boatManufacturer;
        this.boatModel = boatModel;
        this.boatLength = boatLength;
        this.boatFeet = boatFeet;
        this.boatEngine = boatEngine;
        this.boatEngineYear = boatEngineYear;
    }

    //Getter for Boat
    public Customer getOwner() {
        return owner;
    }
    public String getBoatRegNR() {
        return boatRegNR;
    }
    public String getBoatManufacturer() {
        return boatManufacturer;
    }
    public String getBoatModel() {
        return boatModel;
    }
    public String getBoatLength() {
        return boatLength;
    }
    public String getBoatFeet() {
        return boatFeet;
    }
    public String getBoatEngine() {
        return boatEngine;
    }
    public String getBoatEngineYear() {
        return boatEngineYear;
    }

    //Setter for Boat
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    public void setBoatRegNR(String boatRegNR) {
        this.boatRegNR = boatRegNR;
    }
    public void setBoatManufacturer(String boatManufacturer) {
        this.boatManufacturer = boatManufacturer;
    }
    public void setBoatModel(String boatModel) {
        this.boatModel = boatModel;
    }
    public void setBoatLength(String boatLength) {
        this.boatLength = boatLength;
    }
    public void setBoatFeet(String boatFeet) {
        this.boatFeet = boatFeet;
    }
    public void setBoatEngine(String boatEngine) {
        this.boatEngine = boatEngine;
    }
    public void setBoatEngineYear(String boatEngineYear) {
        this.boatEngineYear = boatEngineYear;
    }
}
