package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /**
    TC1: Valg af spillere
     */
    @Test
    void newGamePlayerTwoPlayers() {
        Game game = new Game();
        game.addPlayers(20,2,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int exectedAmountOfPlayers=2;
        assertEquals(exectedAmountOfPlayers,amountOfPlayers);
    }
    @Test
    void newGamePlayerThreePlayers() {
        Game game = new Game();
        game.addPlayers(18,3,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int exectedAmountOfPlayers=3;
        assertEquals(exectedAmountOfPlayers,amountOfPlayers);
    }
    @Test
    void newGamePlayerFourPlayers() {
        Game game = new Game();
        game.addPlayers(16,4,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int exectedAmountOfPlayers=4;
        assertEquals(exectedAmountOfPlayers,amountOfPlayers);
    }

    /**
     TC2: Spillerens beholdning ved n spillere.
     */
    @Test
    void newGameBalanceTwoPlayers() {
        Game game = new Game();
        game.addPlayers(20,2,game.getGui());
        int expectedValue = 20;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
    @Test
    void newGameBalanceThreePlayers() {
        Game game = new Game();
        game.addPlayers(18,3,game.getGui());
        int expectedValue = 18;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
    @Test
    void newGameBalanceFourPlayers() {
        Game game = new Game();
        game.addPlayers(16,4,game.getGui());
        int expectedValue = 16;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
}