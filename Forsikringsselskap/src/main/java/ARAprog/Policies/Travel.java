package ARAprog.Policies;

public class Travel extends Polices {

    private String affectedArea;
    private String travelInsuredFor;

    public Travel(int plcsPremium, int plcsPayOut, String plcsTerms, String affectedArea, String travelInsuredFor) {

        super(plcsPremium, plcsPayOut, plcsTerms);

        this.affectedArea = affectedArea;
        this.travelInsuredFor = travelInsuredFor;
    }

    public String getAffectedArea() {
        return affectedArea;
    }
    public String getTravelInsuredFor() {
        return travelInsuredFor;
    }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }
    public void setTravelInsuredFor(String travelInsuredFor) {
        this.travelInsuredFor = travelInsuredFor;
    }

}
