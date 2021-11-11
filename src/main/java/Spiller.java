//Denne klasse bruges til at lave spilleren, samt opretter en saldo, navn og gør det muligt at skifte tur

import gui_fields.GUI_Player;

public class Spiller {
    private Konto konto;
    private String navn;
    private Boolean tur;
    private GUI_Player player;
    private int locationIndex;

    public Spiller(int saldo,String navn){
        if (saldo<0){
            this.konto = new Konto(0);
        }
        else {
            this.konto = new Konto(saldo);
        }
        this.navn=navn;
        this.player = new GUI_Player(navn,saldo);
    }
    public void saldoOpdatering(int saldoOpdatering){
        this.konto.addSaldo(saldoOpdatering);
    }

    public GUI_Player getPlayer(){
        return this.player;
    }

    public void setTur(Boolean tur) {
        this.tur = tur;
    }

    public Boolean getTur() {
        return tur;
    }

    public int getSaldo() {
        return this.konto.getSaldo();
    }
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
            this.saldoOpdatering(2);
        }
        this.locationIndex = location%24;
    }
}
