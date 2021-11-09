//Denne klasse bruges til at lave en pengebeholdning
// Konto bliver oprettet inde på spilleren istedet for at blive oprettet inde på kontoklassen
public class Konto {
    public int saldo;
    public Konto(int saldo){
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    // Dette er når spilleren lander på et felt med en given værdi, så bliver der sat penge ind på saldoen
    // Saldoen kan ikke gå i minus, og derfor hvis den kommer under 0 så bliver saldoen sat til 0

    public void addSaldo(int saldoOpdatering) {
        this.saldo = saldo+saldoOpdatering;
        if (this.saldo < 0) {
            this.saldo = 0;
    }
}
}

