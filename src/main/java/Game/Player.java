package Game;//Denne klasse bruges til at lave spilleren, samt opretter en saldo, navn og gør det muligt at skifte tur

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

import java.awt.*;

public class Player {
    private Account konto;
    private String navn;
    private Boolean tur;
    private GUI_Player player;
    private int locationIndex;
    public int getOutOfJail;
    private boolean inJail;



    private GUI_Car car = new GUI_Car(Color.black,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

    public Player(int saldo, String navn,GUI_Car car){
        if (saldo<0){
            this.konto = new Account(0);
        }
        else {
            this.konto = new Account(saldo);
        }
        this.navn=navn;
        this.player = new GUI_Player(navn,saldo,car);
    }


    /**
     * Adds to the player's account and GUI
     */
    public void saldoOpdatering(int saldoOpdatering){
        this.konto.addSaldo(saldoOpdatering);
        this.player.setBalance(this.getSaldo());
    }

    /**
     * Get spillerens GUI spiller objekt
     */
    public GUI_Player getPlayer(){
        return this.player;
    }

    public void setTur(Boolean tur) {
        this.tur = tur;
    }

    public Boolean getTur() {
        return tur;
    }

    /**
     * Get players name
     */
    public int getSaldo() {
        return this.konto.getSaldo();
    }

    /**
     * Get players name
     */
    public String getNavn(){
        return this.navn;
    }


    /**
     * Returns the players location index
     */
    public int getLocationIndex() {
        return locationIndex;
    }

    /**
     * Used if player is manually placed somewhere and needs to collect Start money.
     */
    public void collectStart(){
        this.saldoOpdatering(2);
    }

    /**
     * Set the location index for player. If over 24(the player has made a lap), the player will receive
     * start money and location index resets to avoid index out of bounds.
     */
    public void setLocationIndex(int location) {
        if (location>24){
            this.collectStart();
        }
        this.locationIndex = location%24;
    }
    public void setGetOutOfJail(int getOutOfJail){
        getOutOfJail=getOutOfJail;
    }
    private int getGetOutOfJail(){
        return getOutOfJail;
    }
}
