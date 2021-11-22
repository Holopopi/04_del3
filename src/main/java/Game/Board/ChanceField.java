package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class ChanceField extends Field{

    public ChanceField() {
        super("Chance", "Træk et chancekort", "", Color.lightGray, Color.black);
    }

    @Override
    protected GUI_Chance createGUIField(){
        return new GUI_Chance();
    }

    @Override
    public GUI_Chance getGuiField() {
        return (GUI_Chance) this.guiField;
    }

    @Override
    public void runAction(Player player, Game game) {
        GameBoard gameBoard = game.getGameBoard();
        //HouseField field = gameBoard.getFields()[player.getLocationIndex()];

        //gameBoard.chanceFreeBuilding(field, player, game);
    }
}
