package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /**
    TC1
     */

    @Test
    void newGamePlayerTwoPlayers() {
        Game game = new Game();
        game.addPlayers(2,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int expectedAmountOfPlayers=2;
        assertEquals(expectedAmountOfPlayers,amountOfPlayers);
    }
    @Test
    void newGamePlayerThreePlayers() {
        Game game = new Game();
        game.addPlayers(3,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int expectedAmountOfPlayers=3;
        assertEquals(expectedAmountOfPlayers,amountOfPlayers);
    }
    @Test
    void newGamePlayerFourPlayers() {
        Game game = new Game();
        game.addPlayers(4,game.getGui());
        int amountOfPlayers=game.getAmountOfPlayers();
        int expectedAmountOfPlayers=4;
        assertEquals(expectedAmountOfPlayers,amountOfPlayers);
    }

    /**
     TC2
     */

    @Test
    void newGameBalanceTwoPlayers() {
        Game game = new Game();
        game.addPlayers(2,game.getGui());
        game.startBalance(20);
        int expectedValue = 20;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
    @Test
    void newGameBalanceThreePlayers() {
        Game game = new Game();
        game.addPlayers(3,game.getGui());
        game.startBalance(18);
        int expectedValue = 18;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
    @Test
    void newGameBalanceFourPlayers() {
        Game game = new Game();
        game.addPlayers(4,game.getGui());
        game.startBalance(16);
        int expectedValue = 16;
        assertEquals(expectedValue,game.getPlayer(1).getSaldo());
    }
    /**
     TC3
     */
    @Test
    void movePlayerStart() {
        Game game = new Game();
        game.addPlayers(2,game.getGui());
        game.startBalance(16);
        int expectedFirstValue = 16;
        assertEquals(expectedFirstValue,game.getPlayer(1).getSaldo());
        game.movePlayer(game.getPlayer(1),25);
        int expectedSecondValue = expectedFirstValue+2;
        assertEquals(expectedSecondValue,game.getPlayer(1).getSaldo());
    }

    /**
     TC4 & TC5
     */
    @Test
    void buyBuilding() {
        Game game = new Game();
        game.addPlayers(2,game.getGui());
        game.startBalance(16);
        game.movePlayer(game.getPlayer(0),1);
        game.getGameBoard().getFields()[1].runAction(game.getPlayer(0),game);
        int expectedFirstValue = 15;
        assertEquals(expectedFirstValue,game.getPlayer(0).getSaldo());
        game.movePlayer(game.getPlayer(1),1);
        game.getGameBoard().getFields()[1].runAction(game.getPlayer(1),game);
        int expectedSecondValue=16;
        assertEquals(expectedSecondValue,game.getPlayer(0).getSaldo());
        assertEquals(expectedFirstValue,game.getPlayer(1).getSaldo());


    }

}