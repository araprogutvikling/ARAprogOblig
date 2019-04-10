package ARAprog.Persons;

public class Customer extends Person implements Cloneable {

    private int cCustomernr;

    private boolean cHasPolicies;



    public int getcCustomernr() {
        return cCustomernr;
    }

    public void setcCustomernr(int cCustomernr) {
        this.cCustomernr = cCustomernr;
    }

    public boolean isChasPolicies() {
        return cHasPolicies;
    }

    public void setChasPolicies(boolean chasPolicies) {
        this.cHasPolicies = chasPolicies;
    }

    public boolean isCustomernr(boolean chasPolicies){
        if (!chasPolicies){
            return false;
        }
        else {
            return true;
        }

    }

    public Customer clone() {
        if (!cHasPolicies) {
            Customer copied = null;
            try {
                copied = (Customer) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
            return copied;
        }
        return null;
    }
}
