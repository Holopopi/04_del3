// Denne klasse bruges til at lave selve spillet

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Game {
    private Game() {
    }

    public static void nytSpil() {

        GameBoard gameboard = new GameBoard();
        GUI gui = new GUI(gameboard.getGuiFields());

        // To spillere bliver instantieret med saldo 1000 i deres konto
        Spiller spiller1 = new Spiller(1000, "Player 2");
        Spiller spiller2 = new Spiller(1000, "Player 1");

        //Boolean til at spille igen
        boolean YesorNo;

        //Spiller objektet bliver nu tilføjet til vores GUI, så navn og saldo vises på spillebrættet.
        GUI_Player sp1 = new GUI_Player(spiller1.getNavn(), spiller1.getSaldo());
        gui.addPlayer(sp1);
        GUI_Player sp2 = new GUI_Player(spiller2.getNavn(), spiller2.getSaldo());
        gui.addPlayer(sp2);

        //2 Terninger oprettes med 6 sider.
        Terning terning1 = new Terning(6);
        Terning terning2 = new Terning(6);

        //Gui'en starter med at vise et sæt terninger. I løbet af spillet vil det opdatere med terning1 og terning 2's værdier.
        gui.setDice(1, 1);

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
                gui.getUserButtonPressed(spiller1.getNavn() + " " + Tekstfelt.kast(), Tekstfelt.kast());
                t1 = terning1.kastTerning();
                t2 = terning2.kastTerning();
                terningernesVaerdi = t1 + t2;
                gui.setDice(t1, t2);
                spiller1.setTur(false);
                spiller2.setTur(true);
                for (int index = 0; index < 11; index++) {
                    if (gameboard.getGuiFields()[index].hasCar(sp2)) {
                        gameboard.getGuiFields()[index].removeAllCars();
                        gameboard.getGuiFields()[index].setCar(sp2, true);
                    } else
                        gameboard.getGuiFields()[index].removeAllCars();
                }
                // Her er koden for spiller 1 til felterne, og det bestemmer hvad der sker hvis man lander på det pågældende felt
                switch (terningernesVaerdi) {
                }
            }
            // Dette er "win conditionen" altså når pengebeholdningen kommer over 3000 så vinder enten spiller 1 eller 2
            //Spilleren vinder og det læses op, samt muligheden for at spille igen gives

            if (spiller1.getSaldo() >= 3000) {
                gui.getUserButtonPressed(spiller1.getNavn() + " " + Tekstfelt.spillerVinder(), Tekstfelt.OK());
                YesorNo = gui.getUserLeftButtonPressed("Game over. Play again?", "yes", "no");
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
                } else if (!YesorNo) {
                    System.exit(0);
                }
                //break;
            }
            // Det her bestemmer hvis tur det er, samt terningakastet og at bilerne bliver rykket
            if (spiller2.getTur()) {
                gui.getUserButtonPressed(spiller2.getNavn() + " " + Tekstfelt.kast(), Tekstfelt.kast());
                t1 = terning1.kastTerning();
                t2 = terning2.kastTerning();
                terningernesVaerdi = t1 + t2;
                gui.setDice(t1, t2);
                spiller2.setTur(false);
                spiller1.setTur(true);
                for (int index = 0; index < 11; index++) {
                    if (gameboard.getGuiFields()[index].hasCar(sp1)) {
                        gameboard.getGuiFields()[index].removeAllCars();
                        gameboard.getGuiFields()[index].setCar(sp1, true);
                    } else
                        gameboard.getGuiFields()[index].removeAllCars();
                }
                // Her er koden for spiller 2 til felterne, og det bestemmer hvad der sker hvis man lander på det pågældende felt
                switch (terningernesVaerdi) {

                }
            }

            // Dette er "win conditionen" altså når pengebeholdningen kommer over 3000 så vinder enten spiller 1 eller 2
            //Spilleren vinder og det læses op, samt muligheden for at spille igen gives
            if (spiller2.getSaldo() >= 3000) {
                gui.getUserButtonPressed(spiller2.getNavn() + " " + Tekstfelt.spillerVinder(), Tekstfelt.OK());
                YesorNo = gui.getUserLeftButtonPressed("Game over. Play again?", "yes", "no");
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
                        } else if (!YesorNo) {
                            System.exit(0);
                        }
                        //break;
                    }
                }
            }
        }
    }
}
