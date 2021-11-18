package Game;

import static org.junit.jupiter.api.Assertions.*;
// Denne klasse bruges til junit test, og tester om hvorvidt vores terning virker
// Hvis to ud af de tre tests bestås, kan vi også dømme terningen valid
public class DiceTest {
    // Denne junit test, tester hvor mange gange summen af terningerne bliver 7
    // For at denne test bestås skal resultatet af testen være mellem 187 og 147
    // Hvis testen består kan vi dømme terningen valid
    @org.junit.Test
    public void kastTerningSyv() {
        Dice dice = new Dice(6);
        Dice dice2 = new Dice(6);
        int countSyv=0;
        for (int i=0;i<1000;i++){
            int t1=dice.kastTerning();
            int t2=dice2.kastTerning();
            int vaerdi=t1+t2;
            if (vaerdi==7){
                countSyv++;
            }
        }
        int expectedResult=167;
        assertEquals(expectedResult,countSyv,40);
    }
    // Denne junit test, tester hvor mange gange summen af terningerne bliver 2
    // For at denne test bestås skal resultatet af testen være mellem 35 og 21
    // Hvis testen består kan vi dømme terningen valid
    @org.junit.Test
    public void kastTerningTo() {
        Dice dice = new Dice(6);
        Dice dice2 = new Dice(6);
        int countSyv=0;
        for (int i=0;i<1000;i++){
            int t1=dice.kastTerning();
            int t2=dice2.kastTerning();
            int vaerdi=t1+t2;
            if (vaerdi==2){
                countSyv++;
            }
        }
        int expectedResult=28;
        assertEquals(expectedResult,countSyv,12);
    }
    // Denne junit test, tester hvor mange gange summen af terningerne bliver 10
    // For at denne test bestås skal resultatet af testen være mellem 93 og 73
    // Hvis testen består kan vi dømme terningen valid
    @org.junit.Test
    public void kastTerningTi() {
        Dice dice = new Dice(6);
        Dice dice2 = new Dice(6);
        int countSyv=0;
        for (int i=0;i<1000;i++){
            int t1=dice.kastTerning();
            int t2=dice2.kastTerning();
            int vaerdi=t1+t2;
            if (vaerdi==10){
                countSyv++;
            }
        }
        int expectedResult=83;
        assertEquals(expectedResult,countSyv,30);
    }
    @org.junit.Test
    public void nSideTerning() {
        int n=50;
        int terningvaerdi;
        for (int i=0;i<50;i++){
            Dice terning = new Dice(n);
            terningvaerdi=terning.kastTerning();
            assertTrue(terningvaerdi>=1 && terningvaerdi<=n);
            n--;
        }

    }
}
