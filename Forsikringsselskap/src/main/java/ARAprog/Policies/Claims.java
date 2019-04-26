package ARAprog.Policies;
import ARAprog.Persons.Witness;

import java.util.ArrayList;

public class Claims extends Polices {

    private String dateOfIncident;
    private String claimNr;
    private String typeOfIncident;
    private String descriptionOfIncident;
    private ArrayList <Witness> witnesses;
    private String damageEstimation;
    private String damagePayOut;

    public Claims(int plcsPremium, int plcsPayOut, String plcsTerms, String dateOfIncident, String claimNr,
                  String typeOfIncident, String descriptionOfIncident, ArrayList<Witness> witnesses,
                  String damageEstimation, String damagePayOut) {
        super(plcsPremium, plcsPayOut, plcsTerms);
        this.dateOfIncident = dateOfIncident;
        this.claimNr = claimNr;
        this.typeOfIncident = typeOfIncident;
        this.descriptionOfIncident = descriptionOfIncident;
        this.witnesses = witnesses;
        this.damageEstimation = damageEstimation;
        this.damagePayOut = damagePayOut;
    }

    //Getter
    public String getDateOfIncident() {
        return dateOfIncident;
    }
    public String getClaimNr() {
        return claimNr;
    }
    public String getTypeOfIncident() {
        return typeOfIncident;
    }
    public String getDescriptionOfIncident() {
        return descriptionOfIncident;
    }
    public ArrayList<Witness> getWitnesses() {
        return witnesses;
    }
    public String getDamageEstimation() {
        return damageEstimation;
    }
    public String getDamagePayOut() {
        return damagePayOut;
    }

    //Setter
    public void setDateOfIncident(String dateOfIncident) {
        this.dateOfIncident = dateOfIncident;
    }
    public void setClaimNr(String claimNr) {
        this.claimNr = claimNr;
    }
    public void setTypeOfIncident(String typeOfIncident) {
        this.typeOfIncident = typeOfIncident;
    }
    public void setDescriptionOfIncident(String descriptionOfIncident) {
        this.descriptionOfIncident = descriptionOfIncident;
    }
    public void setWitnesses(ArrayList<Witness> witnesses) {
        this.witnesses = witnesses;
    }
    public void setDamageEstimation(String damageEstimation) {
        this.damageEstimation = damageEstimation;
    }
    public void setDamagePayOut(String damagePayOut) {
        this.damagePayOut = damagePayOut;
    }
}
