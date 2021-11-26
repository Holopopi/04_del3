package Game;

import org.junit.Assert.*;

import gui_fields.GUI_Car;
import org.junit.jupiter.api.Test;


import java.awt.*;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
// Denne class er til junit test


public class PlayerTest {
    // Denne junit test, tester om spilleren kan laves med en negativ saldo og dermed gå i minus, det må den ikke og skal derfor blive 0
    @org.junit.Test
    public void negativBeholdning(){
        GUI_Car car = new GUI_Car(Color.black,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        Player player = new Player(-1000,"navn", car,false);
        int saldo = player.getSaldo();
        int expectedResult = 0;
        assertEquals(expectedResult,saldo);
    }
    // Denne junit test, tester om det er muligt for saldoen at gå i minus, ved at opdatere saldoen.
    @org.junit.Test
    public void negativSaldoOpdatering(){
        GUI_Car car = new GUI_Car(Color.black,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        Player player = new Player(0,"navn",car,false);
        player.saldoOpdatering(-1000);
        int saldo = player.getSaldo();
        int expectedResult = -1000;
        assertEquals(expectedResult,saldo);
    }
    // Denne junit test, tester om saldoen generelt opdateres hvis der bliver lagt 500 til i saldoen
    @org.junit.Test
    public void saldoOpdatering(){
        GUI_Car car = new GUI_Car(Color.black,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        Player player = new Player(0,"navn",car,false);
        player.saldoOpdatering(500);
        int saldo = player.getSaldo();
        int expectedResult = 500;
        assertEquals(expectedResult,saldo);
    }

}