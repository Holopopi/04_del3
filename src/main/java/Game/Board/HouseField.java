package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Street;

import java.awt.*;

public class HouseField extends Field {


    //private Player owner;
    public HouseField(String name, String description, String subText, Color color) {
        super(name, description, subText, color, Color.black);
    }

    @Override
    protected GUI_Street createGUIField() {
        return new GUI_Street();
    }

    @Override
    public GUI_Street getGuiField() {
        return (GUI_Street) this.guiField;
    }

    @Override
    public void runAction(Player player, Game game) {
        GameBoard gameBoard = game.getGameBoard();
        System.out.print(gameBoard.freeBuilding);
        if (gameBoard.freeBuilding) {
            gameBoard.chanceFreeBuilding(this, player, game);
        } else {
            if (gameBoard.isBought(this)) {
                gameBoard.PayRent(this, player, game);
                System.out.println("Paid rent");
            } else {
                gameBoard.BuyBuilding(this, player, game);
            }
        }
        gameBoard.freeBuilding = false;
    }
}