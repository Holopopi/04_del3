package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class ChanceField extends Field{
    int ChanceCardNumber =1;
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



        switch (ChanceCardNumber){
            case 1: game.getGui().showMessage("Move to start and recive 2M");
            player.setLocationIndex(0);
            player.saldoOpdatering(2);
            ChanceCardNumber++;
            break;
            case 2:
            switch (game.getGui().getUserSelection("Move between one to five fields","1","2","3","4","5")){
                case"1":
                    game.getGui().showMessage("You move one field");
                    game.movePlayer(player,1);
                    break;
                case "2":
                    game.getGui().showMessage("You move two fields");
                    game.movePlayer(player,2);
                    break;
                case "3":
                    game.getGui().showMessage("You move three fields");
                    game.movePlayer(player,3);
                    break;
                case "4":
                    game.getGui().showMessage("You move four fields");
                    game.movePlayer(player,4);
                    break;
                case "5":
                    game.getGui().showMessage("You move five fields");
                    game.movePlayer(player,5);
                    break;
            }
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
