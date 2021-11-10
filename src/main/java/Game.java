// Denne klasse bruges til at lave selve spillet

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Game {

    GameBoard gameboard;
    GUI gui;
    Spiller[] players;
    Terning terning1;
    Terning terning2;
    int amountOfPlayers;


    public Game() {
        this.gameboard = new GameBoard();
        this.gui = new GUI(gameboard.getGuiFields());
        this.players = new Spiller[]{new Spiller(35, "John"), new Spiller(35, "Marcus"),
                new Spiller(35, "Jack"), new Spiller(35, "Joy")};
        this.terning1 = new Terning(6);
        this.terning2 = new Terning(6);
    }

    public void newGame() {
        switch (gui.getUserSelection("How many players?", "2", "3", "4")) {
            case "2":
                addPlayers(2,gui);
                amountOfPlayers=2;
                break;
            case "3":
                addPlayers(3,gui);
                amountOfPlayers=3;
                break;
            case "4":
                addPlayers(4,gui);
                amountOfPlayers=4;
                break;
        }
    }

    private void addPlayers(int n,GUI gui){
        for(int i=0;i<n;i++){
            gui.addPlayer(players[i].getPlayer());
        }
    }

    public void playGame(){
        int t1;
        int t2;
        int die;
        int playersTurn;

        for(int i=0;i<24;i++){
            this.gui.getUserButtonPressed("kast","kast");
            t1= terning1.kastTerning();
            t2= terning2.kastTerning();
            die=t1+t2;
            playersTurn=i%amountOfPlayers;
            this.gameboard.getGuiFields()[die].setCar(this.players[playersTurn].getPlayer(),true);
        }


    }

    private void takeTurn(){
    }

    public static void nytSpil() {

        GameBoard gameboard = new GameBoard();
        GUI gui = new GUI(gameboard.getGuiFields());

        // To spillere bliver instantieret med saldo 1000 i deres konto
        Spiller spiller1 = new Spiller(1000, "Player 2");
        Spiller spiller2 = new Spiller(1000, "Player 1");

        //Spiller objektet bliver nu tilføjet til vores GUI, så navn og saldo vises på spillebrættet.
        gui.addPlayer(spiller1.getPlayer());
        gui.addPlayer(spiller2.getPlayer());


        //Boolean til at spille igen
        boolean YesorNo;


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
                    if (gameboard.getGuiFields()[index].hasCar(spiller2.getPlayer())) {
                        gameboard.getGuiFields()[index].removeAllCars();
                        gameboard.getGuiFields()[index].setCar(spiller2.getPlayer(), true);
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
                    spiller1.getPlayer().setBalance(spiller1.getSaldo());
                    spiller2.saldoOpdatering(-4000);
                    spiller2.saldoOpdatering(1000);
                    spiller2.getPlayer().setBalance(spiller2.getSaldo());

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
                    if (gameboard.getGuiFields()[index].hasCar(spiller1.getPlayer())) {
                        gameboard.getGuiFields()[index].removeAllCars();
                        gameboard.getGuiFields()[index].setCar(spiller1.getPlayer(), true);
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
                    spiller1.getPlayer().setBalance(spiller1.getSaldo());
                    spiller2.saldoOpdatering(-4000);
                    spiller2.saldoOpdatering(1000);
                    spiller2.getPlayer().setBalance(spiller2.getSaldo());

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
