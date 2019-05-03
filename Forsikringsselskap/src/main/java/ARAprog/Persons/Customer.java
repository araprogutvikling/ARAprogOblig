package ARAprog.Persons;

public class Customer extends Person {
    //Datafelt for Customer
    private int Customernr;
    private int randomTall;
    final int maxGrense = 999_999; /*konstant (final)*/
    final int minGrense = 100_000; /*konstant (final)*/
    int[] array;

    //Konstruktør for Customer
    public Customer(long prsnPnr, String prsnAge, String prsnFirstName, String prsnLastName, String prsnAdress,
                    String prsnAreaCode, String prsnPostAlarea, String prsnEMail, String prsnTlfNr) {

        super(prsnPnr, prsnAge, prsnFirstName, prsnLastName, prsnAdress, prsnAreaCode, prsnPostAlarea, prsnEMail, prsnTlfNr);
    }

    //Getter for Customer
    public int getCustomernr(int numberOfC) {
            return Customernr;
    }

    //Setter for Customer, starter metoden generateCNr for å genere et unikt kundenr.
    public void setCustomernr() {
        this.Customernr = generateCNr();
    }
    //Sjekker om et Customernr er unikt, eller allerede eksistierer!
    private boolean alreadyACNr(int newCNr) {
        for (int i = 0; i < array.length; i++) {
            if (newCNr == array[i]) {
                return true;
            }
        }
        return false;
    }
    //Genererer et tilfelig tall, sender det gjennom checkeren over og dersom det er unikt, retunerer det i arrayet.
    // Deretter blir det sendt inn i setCustomernr
    public int generateCNr() {
        randomTall = minGrense + (int) (Math.random() * ((maxGrense -
                minGrense) + 1));
        if (!alreadyACNr(randomTall)) {
            return randomTall;
        }
        for (int i = 0; i < array.length; i++) {
            do {
                randomTall = minGrense + (int) (Math.random() * ((maxGrense
                        - minGrense) + 1));
            }
            while (alreadyACNr(randomTall));
            array[i] = randomTall;
            return randomTall;
        }
        return 0;
    }
}

