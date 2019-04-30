package ARAprog.Persons;

public class Customer extends Person {
    //Datafelt for Customer
    private int Customernr;
    private int randomTall;
    final int maxGrense = 999999; /*konstant (final)*/
    final int minGrense = 100000; /*konstant (final)*/
    int[] array;

    //Konstruktør for Customer
    public Customer(int prsnPnr, String prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress,
                    String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr) {

        super(prsnPnr, prsnAge, prsnFirstName, prsnLastName, prsnAdress, prsnAreaCode, prsnPostAlarea, prsnEMail, prsnTlfNr);
    }

    //Getter for Customer
    public int getCustomernr(int numberOfC) {
            return Customernr;
    }

    //Setter for Customer
    public void setCustomernr() {
        this.Customernr = generateCNr();
    }

    private boolean AlreadyACNr(int newCNr) {
        for (int i = 0; i < array.length; i++) {
            if (newCNr == array[i]) {
                return true;
            }
        }
        return false;
    }

    public int generateCNr() {
        randomTall = minGrense + (int) (Math.random() * ((maxGrense -
                minGrense) + 1));
        if (!AlreadyACNr(randomTall)) {
            return randomTall;
        }
        for (int i = 0; i < array.length; i++) {
            do {
                randomTall = minGrense + (int) (Math.random() * ((maxGrense
                        - minGrense) + 1));
            }
            while (AlreadyACNr(randomTall));
            array[i] = randomTall;
            return randomTall;
        }
        return 0;
    }
}

