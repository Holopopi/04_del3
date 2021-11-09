//Denne klasse bruges til at lave spilleren, samt opretter en saldo, navn og gør det muligt at skifte tur

public class Spiller {
    Konto konto;
    String navn;
    Boolean tur;

    public Spiller(int saldo,String navn){
        if (saldo<0){
            this.konto = new Konto(0);
        }
        else {
            this.konto = new Konto(saldo);
        }
        this.navn=navn;
    }
    public void saldoOpdatering(int saldoOpdatering){
        this.konto.addSaldo(saldoOpdatering);
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
