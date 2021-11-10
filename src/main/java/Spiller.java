//Denne klasse bruges til at lave spilleren, samt opretter en saldo, navn og gør det muligt at skifte tur

import gui_fields.GUI_Player;

public class Spiller {
    Konto konto;
    String navn;
    Boolean tur;
    GUI_Player player;

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

}
