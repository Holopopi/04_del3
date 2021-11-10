// Denne klasse bruges til at lave selve spillet

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Terningspil {
    private Terningspil(){
    }
    public static void nytSpil(){
        // Den udleverede GUI bruges til at instantiere et array med 40 emner.
        // Vi indlæser 40 og ikke 11, da det bliver lidt pænere. Vi er nød til så at tillade tomme felter.
        GUI_Field[] fields = new GUI_Field[40];
        GUI.setNull_fields_allowed(true);
        // Et instans af felt bliver oprettet ved hjælp af den udleverede GUI.
        // Det sættes så som objekt i array'et.
        GUI_Street tower = new GUI_Street();
        tower.setTitle(Tekstfelt.feltNavn2());
        tower.setBackGroundColor(Color.CYAN);
        tower.setSubText(Tekstfelt.feltVærdi2());
        fields[0] = tower;

        //Gentages med resten.
        GUI_Street crater = new GUI_Street();
        crater.setTitle(Tekstfelt.feltNavn3());
        crater.setBackGroundColor(Color.PINK);
        crater.setSubText(Tekstfelt.feltVærdi3());
        fields[1] = crater;
        GUI_Street palaceGates = new GUI_Street();
        palaceGates.setTitle(Tekstfelt.feltNavn4());
        palaceGates.setBackGroundColor(Color.GRAY);
        palaceGates.setSubText(Tekstfelt.feltVærdi4());
        fields[2] = palaceGates;
        GUI_Street coldDesert = new GUI_Street();
        coldDesert.setTitle(Tekstfelt.feltNavn5());
        coldDesert.setBackGroundColor(Color.magenta);
        coldDesert.setSubText(Tekstfelt.feltVærdi5());
        fields[3] = coldDesert;
        GUI_Street walledCity = new GUI_Street();
        walledCity.setTitle(Tekstfelt.feltNavn6());
        walledCity.setBackGroundColor(Color.green);
        walledCity.setSubText(Tekstfelt.feltVærdi6());
        fields[4] = walledCity;
        GUI_Street monastery = new GUI_Street();
        monastery.setTitle(Tekstfelt.feltNavn7());
        monastery.setBackGroundColor(Color.yellow);
        monastery.setSubText(Tekstfelt.feltVærdi7());
        fields[5] = monastery;
        GUI_Street blackCave = new GUI_Street();
        blackCave.setTitle(Tekstfelt.feltNavn8());
        blackCave.setBackGroundColor(Color.blue);
        blackCave.setSubText(Tekstfelt.feltVærdi8());
        fields[6] = blackCave;
        GUI_Street huts = new GUI_Street();
        huts.setTitle(Tekstfelt.feltNavn9());
        huts.setBackGroundColor(Color.LIGHT_GRAY);
        huts.setSubText(Tekstfelt.feltVærdi9());
        fields[7] = huts;
        GUI_Street werewall = new GUI_Street();
        werewall.setTitle(Tekstfelt.feltNavn10());
        werewall.setBackGroundColor(Color.red);
        werewall.setSubText(Tekstfelt.feltVærdi10());
        fields[8] = werewall;
        GUI_Street thePit = new GUI_Street();
        thePit.setTitle(Tekstfelt.feltNavn11());
        thePit.setBackGroundColor(Color.white);
        thePit.setSubText(Tekstfelt.feltVærdi11());
        fields[9] = thePit;
        GUI_Street goldmine = new GUI_Street();
        goldmine.setTitle(Tekstfelt.feltNavn12());
        goldmine.setBackGroundColor(Color.ORANGE);
        goldmine.setSubText(Tekstfelt.feltVærdi12());
        fields[10] = goldmine;


        //Nu instantierers spillebrættet med vores fields-array med alle felterne og deres attributter
        // og en baggrundsfarve.

        GUI gui = new GUI(fields);

        // To spillere bliver instantieret med saldo 1000 i deres konto
        Spiller spiller1 = new Spiller(1000,"Player 2");
        Spiller spiller2 = new Spiller(1000,"Player 1");

        //Boolean til at spille igen
        boolean YesorNo;

        //Spiller objektet bliver nu tilføjet til vores GUI, så navn og saldo vises på spillebrættet.
        GUI_Player sp1 = new GUI_Player(spiller1.getNavn(),spiller1.getSaldo());
        gui.addPlayer(sp1);
        GUI_Player sp2 = new GUI_Player(spiller2.getNavn(),spiller2.getSaldo());
        gui.addPlayer(sp2);

        //2 Terninger oprettes med 6 sider.
        Terning terning1 = new Terning(6);
        Terning terning2 = new Terning(6);

        //Gui'en starter med at vise et sæt terninger. I løbet af spillet vil det opdatere med terning1 og terning 2's værdier.
        gui.setDice(1,1);

        //Spillerne slår om hvem, der starter
        //Spilleren, der slår højest vinder
        int i = 0;
        while (i < 1) {
            int a = terning1.kastTerning();
            int b = terning2.kastTerning();
            if (a > b) {
                spiller1.setTur(true);
                spiller2.setTur(false);
                i++;
            }
            if (b > a) {
                spiller1.setTur(false);
                spiller2.setTur(true);
                i++;
            }
        }
        //Spillet køres. Et par variabler oprettes for at holde styr på terningkastenes værdier.
        int t1;
        int t2;
        int terningernesVaerdi;
        // Det her bestemmer hvis tur det er, samt terningakastet og at bilerne bliver rykket
        while (true) {
            if (spiller1.getTur()) {
                gui.getUserButtonPressed(spiller1.getNavn()+" "+Tekstfelt.kast(), Tekstfelt.kast());
                t1 = terning1.kastTerning();
                t2 = terning2.kastTerning();
                terningernesVaerdi = t1 + t2;
                gui.setDice(t1, t2);
                spiller1.setTur(false);
                spiller2.setTur(true);
                for (int index = 0; index < 11; index++) {
                    if (fields[index].hasCar(sp2)) {
                        fields[index].removeAllCars();
                        fields[index].setCar(sp2, true);
                    } else
                        fields[index].removeAllCars();
                }
                // Her er koden for spiller 1 til felterne, og det bestemmer hvad der sker hvis man lander på det pågældende felt
                switch (terningernesVaerdi) {
                    case 2: {
                        spiller1.saldoOpdatering(250);
                        sp1.setBalance(spiller1.getSaldo());
                        tower.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt2Besked(),Tekstfelt.OK());
                        break;
                    }
                    case 3: {
                        spiller1.saldoOpdatering(-100);
                        sp1.setBalance(spiller1.getSaldo());
                        crater.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt3Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 4: {
                        spiller1.saldoOpdatering(100);
                        sp1.setBalance(spiller1.getSaldo());
                        palaceGates.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt4Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 5: {
                        spiller1.saldoOpdatering(-20);
                        sp1.setBalance(spiller1.getSaldo());
                        coldDesert.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt5Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 6: {
                        spiller1.saldoOpdatering(180);
                        sp1.setBalance(spiller1.getSaldo());
                        walledCity.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt6Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 7: {
                        monastery.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt7Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 8: {
                        spiller1.saldoOpdatering(-70);
                        sp1.setBalance(spiller1.getSaldo());
                        blackCave.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt8Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 9: {
                        spiller1.saldoOpdatering(60);
                        sp1.setBalance(spiller1.getSaldo());
                        huts.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt9Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 10: {
                        spiller1.saldoOpdatering(-80);
                        sp1.setBalance(spiller1.getSaldo());
                        werewall.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt10Besked(), Tekstfelt.OK());
                        spiller2.setTur(false);
                        spiller1.setTur(true);
                        break;
                    }
                    case 11: {
                        spiller1.saldoOpdatering(-50);
                        sp1.setBalance(spiller1.getSaldo());
                        thePit.setCar(sp1,true);
                        gui.getUserButtonPressed(Tekstfelt.felt11Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 12: {
                        spiller1.saldoOpdatering(650);
                        sp1.setBalance(spiller1.getSaldo());
                        goldmine.setCar(sp1, true);
                        gui.getUserButtonPressed(Tekstfelt.felt12Besked(), Tekstfelt.OK());
                        break;
                    }
                }
                // Dette er "win conditionen" altså når pengebeholdningen kommer over 3000 så vinder enten spiller 1 eller 2
                //Spilleren vinder og det læses op, samt muligheden for at spille igen gives

                if (spiller1.getSaldo() >= 3000) {
                    gui.getUserButtonPressed(spiller1.getNavn()+" "+Tekstfelt.spillerVinder(), Tekstfelt.OK());
                    YesorNo = gui.getUserLeftButtonPressed("Game over. Play again?","yes","no");
                    if (YesorNo) {
                        spiller1.saldoOpdatering(-4000);
                        spiller1.saldoOpdatering(1000);
                        sp1.setBalance(spiller1.getSaldo());
                        spiller2.saldoOpdatering(-4000);
                        spiller2.saldoOpdatering(1000);
                        sp2.setBalance(spiller2.getSaldo());

                        int j = 0;
                        while (j < 1) {
                            int a = terning1.kastTerning();
                            int b = terning2.kastTerning();
                            if (a > b) {
                                spiller1.setTur(true);
                                spiller2.setTur(false);
                                j++;
                            }
                            if (b > a) {
                                spiller1.setTur(false);
                                spiller2.setTur(true);
                                j++;
                            }
                        }
                    }
                    else if (!YesorNo){
                        System.exit(0);
                    }
                    //break;
                }
            }
            // Det her bestemmer hvis tur det er, samt terningakastet og at bilerne bliver rykket
            if (spiller2.getTur()) {
                gui.getUserButtonPressed(spiller2.getNavn()+" "+Tekstfelt.kast(), Tekstfelt.kast());
                t1 = terning1.kastTerning();
                t2 = terning2.kastTerning();
                terningernesVaerdi = t1 + t2;
                gui.setDice(t1, t2);
                spiller2.setTur(false);
                spiller1.setTur(true);
                for (int index = 0; index < 11; index++) {
                    if (fields[index].hasCar(sp1)) {
                        fields[index].removeAllCars();
                        fields[index].setCar(sp1, true);
                    } else
                        fields[index].removeAllCars();
                }
                // Her er koden for spiller 2 til felterne, og det bestemmer hvad der sker hvis man lander på det pågældende felt
                switch (terningernesVaerdi) {
                    case 2: {
                        spiller2.saldoOpdatering(250);
                        sp2.setBalance(spiller2.getSaldo());
                        tower.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt2Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 3: {
                        spiller2.saldoOpdatering(-100);
                        sp2.setBalance(spiller2.getSaldo());
                        crater.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt3Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 4: {
                        spiller2.saldoOpdatering(100);
                        sp2.setBalance(spiller2.getSaldo());
                        palaceGates.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt4Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 5: {
                        spiller2.saldoOpdatering(-20);
                        sp2.setBalance(spiller2.getSaldo());
                        coldDesert.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt5Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 6: {
                        spiller2.saldoOpdatering(180);
                        sp2.setBalance(spiller2.getSaldo());
                        walledCity.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt6Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 7: {
                        monastery.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt7Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 8: {
                        spiller2.saldoOpdatering(-70);
                        sp2.setBalance(spiller2.getSaldo());
                        blackCave.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt8Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 9: {
                        spiller2.saldoOpdatering(60);
                        sp2.setBalance(spiller2.getSaldo());
                        huts.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt9Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 10: {
                        spiller2.saldoOpdatering(-80);
                        sp2.setBalance(spiller2.getSaldo());
                        werewall.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt10Besked(), Tekstfelt.OK());
                        spiller1.setTur(false);
                        spiller2.setTur(true);
                        break;
                    }
                    case 11: {
                        spiller2.saldoOpdatering(-50);
                        sp2.setBalance(spiller2.getSaldo());
                        thePit.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt11Besked(), Tekstfelt.OK());
                        break;
                    }
                    case 12: {
                        spiller2.saldoOpdatering(650);
                        sp2.setBalance(spiller2.getSaldo());
                        goldmine.setCar(sp2, true);
                        gui.getUserButtonPressed(Tekstfelt.felt12Besked(), Tekstfelt.OK());
                        break;
                    }
                }

                // Dette er "win conditionen" altså når pengebeholdningen kommer over 3000 så vinder enten spiller 1 eller 2
                //Spilleren vinder og det læses op, samt muligheden for at spille igen gives
                if (spiller2.getSaldo() >= 3000) {
                    gui.getUserButtonPressed(spiller2.getNavn()+" "+Tekstfelt.spillerVinder(), Tekstfelt.OK());
                    YesorNo = gui.getUserLeftButtonPressed("Game over. Play again?","yes","no");
                    if (YesorNo) {
                        spiller1.saldoOpdatering(-4000);
                        spiller1.saldoOpdatering(1000);
                        sp1.setBalance(spiller1.getSaldo());
                        spiller2.saldoOpdatering(-4000);
                        spiller2.saldoOpdatering(1000);
                        sp2.setBalance(spiller2.getSaldo());

                        int j = 0;
                        while (j < 1) {
                            int a = terning1.kastTerning();
                            int b = terning2.kastTerning();
                            if (a > b) {
                                spiller1.setTur(true);
                                spiller2.setTur(false);
                                j++;
                            }
                            if (b > a) {
                                spiller1.setTur(false);
                                spiller2.setTur(true);
                                j++;
                            }
                        }
                    }
                    else if (!YesorNo){
                        System.exit(0);
                    }
                    //break;
                }
            }
        }
    }
}
