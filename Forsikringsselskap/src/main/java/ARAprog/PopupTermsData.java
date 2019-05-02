package ARAprog;

import javafx.event.ActionEvent;

public class PopupTermsData {

    public static String popupTermsData(String ID){

        if (ID.equals("btnHInsuranceConditions")){

            return "ARA Husforsikring gjelder for eneboliger, rekkehus og andre typer boliger. \n" +
                    "\n" +
                    "Forsikringen garanterer for alle kostnader tilknyttet skader på boligen din.\n" +
                    "\n" +
                    "Det dekkes også for gjenoppbygging ved skader på mer enn 75% av bygningen, såkalt totalskade. \n" +
                    "\n" +
                    "Brannskader, vannskader, tyveri, naturskader, bekjempelse av skadedyr og skader påført av leietakere i din bolig er også omfattet av denne forsikringen. \n" +
                    "\n" +
                    "For nærmere beløpsgrenser se den enkelte kundes kontrakt. \n";
        }

        else if (ID.equals("btnBInsuranceConditions")){

            return"ARA båtforsikring\n" +
                    "\n" +
                    "Båtforsikringen gjelder alle motorskader (inntil motoren er 15 år gammel), skader på selve båtskroget og skader på drivstoffsystemet/skader grunnet feilfylling av drivstoff.\n" +
                    "\n" +
                    "Hvis båten er totalskadet, dvs. 60% av båten eller mer er skadet vil forsikringen utløse fullstendig erstatning av båten.\n";
        }

        else if (ID.equals("btnTInsuranceConditions1")) {

            return"ARA reiseforsikring gjelder for alle land innenfor Europa, Asia, Oseania, Nord- og Sør-Amerika, og Afrika. \n" +
                    "\n" +
                    "Ved tyveri og skade på reisegods er maks utbetaling ubegrenset.\n" +
                    "\n" +
                    "Ved innleggelse på sykehus, legebesøk, hjemtransport ved sykdom o.l. er maks utbetaling ubegrenset. \n" +
                    "\n" +
                    "Ved avbrutt ferie (fremskyndet hjemreise) utbetales 1500 kr per dag (inntil 100 000 kr). \n" +
                    "\n" +
                    "Ved avbestilling av ferie grunnet sykdom eller skade på egen bolig er maks utbetaling ubegrenset.\n" +
                    "\n" +
                    "For nærmere informasjon se den enkelte kundes kontrakt. \n";
        }

        else if (ID.equals("btnCInsuranceConditions")){

            return"ARA forsikring for fritidsbolig\n" +
                    "\n" +
                    "Forsikringen garanterer for alle kostnader tilknyttet skader på fritidsboligen din.\n" +
                    "\n" +
                    "Det dekkes også for gjenoppbygging ved skader på mer enn 75% av bygningen, såkalt totalskade. \n" +
                    "\n" +
                    "Brannskader, vannskader, tyveri, naturskader, bekjempelse av skadedyr og skader påført av leietakere i din fritidsbolig er også omfattet av denne forsikringen. \n" +
                    "\n" +
                    "For nærmere beløpsgrenser se den enkelte kundes kontrakt. \n";
        }
        else {


            System.err.println("Kunne ikke finne forsikringsbetingelser");

            return null;

        }

    }

}
