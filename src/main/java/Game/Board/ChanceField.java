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
        int ChanceCardNumber =1;


        switch (ChanceCardNumber){
            case 1: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
            break;
            case 2: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 3: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 4: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 5: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 6: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 7: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 8: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 9: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 10: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 11: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 12: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 13: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;
            case 14: game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No");
                break;

        }

    }
}
