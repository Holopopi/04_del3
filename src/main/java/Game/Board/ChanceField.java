package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class ChanceField extends Field{
    int ChanceCardNumber = 1;
    boolean moveOrTakeCard;


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


        switch (ChanceCardNumber) {
            case 1:
                game.getGui().displayChanceCard("Move to start and recive 2M");
                game.setPlayer(player, 0);
                player.saldoOpdatering(2);
                ChanceCardNumber++;
                break;
            case 2:
                game.getGui().displayChanceCard("Move between one to five fields");
                switch (game.getGui().getUserButtonPressed("", "1", "2", "3", "4", "5")) {
                    case "1":
                        game.getGui().showMessage("You move one field");
                        game.movePlayer(player, 1);
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "2":
                        game.getGui().showMessage("You move two fields");
                        game.movePlayer(player, 2);
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "3":
                        game.getGui().showMessage("You move three fields");
                        game.movePlayer(player, 3);
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "4":
                        game.getGui().showMessage("You move four fields");
                        game.movePlayer(player, 4);
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "5":
                        game.getGui().showMessage("You move five fields");
                        game.movePlayer(player, 5);
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            case 3:
                game.getGui().displayChanceCard("Move to either Skateparken or Swimmingpoolen and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skaterparken", "Swimmingpoolen")) {
                    case "Skaterparken":
                        player.setLocationIndex(10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Swimmingpoolen":
                        player.setLocationIndex(11);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            case 4:
                game.getGui().displayChanceCard("Move one or take a new chance card ");
                moveOrTakeCard = game.getGui().getUserLeftButtonPressed("", "Move one", "Take another chance card" + "");
                if (moveOrTakeCard) {
                    game.movePlayer(player, 1);
                    gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                    ChanceCardNumber++;
                } else if (!moveOrTakeCard) {
                    ChanceCardNumber++;
                    gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                }
                break;

            case 5:
                game.getGui().displayChanceCard("You have eaten to much candy pay 2m to the bank");
                player.saldoOpdatering(-2);
                ChanceCardNumber++;
                break;
            case 6:
                game.getGui().displayChanceCard("Move to either Skateparken, Swimmingpoolen, Bowlinghallen or the zoo and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skaterparken", "Swimmingpoolen", "Bowlinghallen", "Zoo")) {
                    case "Skaterparken":
                        player.setLocationIndex(10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        ChanceCardNumber++;
                        break;
                    case "Swimmingpoolen":
                        player.setLocationIndex(11);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        ChanceCardNumber++;
                        break;
                    case"Bowlinghallen":
                        player.setLocationIndex(19);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        ChanceCardNumber++;
                    case "Zoo":
                        player.setLocationIndex(20);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        ChanceCardNumber++;

                }
                break;
            case 7: game.getGui().displayChanceCard("Move to either Slikbutikken or Iskiosken  and if the field isn't owned you get it for free"); game.getGui().getUserButtonPressed("", "Slikbutikken","Iskiosken");
                break;
            case 8: game.getGui().displayChanceCard("get a get out of jail card");
            player.setGetOutOfJail(player.getOutOfJail++);
                ChanceCardNumber++;
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

        //gameBoard.chanceFreeBuilding(field, player, game);
    }
}
