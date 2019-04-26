package ARAprog.Policies;

import java.io.Serializable;
import java.time.LocalDate;

public class Polices implements Serializable {
    private int plcsPremium;
    private int plcsPayOut;
    private String plcsTerms;
    private LocalDate plcsInitialisedDate;

    public Polices(int plcsPremium, int plcsPayOut, String plcsTerms) {
        this.plcsPremium = plcsPremium;
        this.plcsPayOut = plcsPayOut;
        this.plcsTerms = plcsTerms;
        setPlcsInitialisedDate();
    }

    public int getPlcsPremium() {
        return plcsPremium;
    }
    public int getPlcsPayOut() {
        return plcsPayOut;
    }
    public String getPlcsTerms() {
        return plcsTerms;
    }
    public LocalDate getPlcsInitialisedDate() {
        return plcsInitialisedDate;
    }


    public void setPlcsPremium(int plcsPremium) {
        this.plcsPremium = plcsPremium;
    }
    public void setPlcsPayOut(int plcsPayOut) {
        this.plcsPayOut = plcsPayOut;
    }
    public void setPlcsTerms(String plcsTerms) {
        this.plcsTerms = plcsTerms;
    }
    public void setPlcsInitialisedDate() {
        this.plcsInitialisedDate = LocalDate.now();
    }
}
