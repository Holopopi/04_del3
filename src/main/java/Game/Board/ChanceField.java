package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class ChanceField extends Field{
    public static int ChanceCardNumber =1;
    boolean moveOrTakeCard;

    public ChanceField() {
        super("Chance", "Take a chance card", "", Color.lightGray, Color.black);
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
//Chance card Switch
        switch (ChanceCardNumber) {
            //Player move to start and get 2m
            case 1:
                game.getGui().displayChanceCard("Move to start and receive 2M");
                game.setPlayer(player, 0);
                player.collectStart();
                ChanceCardNumber++;
                break;
            //player choose jumping between 1 and 5 fields
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
            // Player either moves to field 10 or 11 and if it is not bought player gets it for free otherwise the player pays rent
            case 3:
                game.getGui().displayChanceCard("Move to either the Skate Park or the Swimming Pool and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skate Park", "Swimming Pool")) {
                    case "Skate park":
                        game.setPlayer(player, 10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case"Swimming Pool" :
                        game.setPlayer(player, 11);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            //The player moves one field or takes another chance card
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
            //Player pays 2m to the bank
            case 5:
                game.getGui().displayChanceCard("You have eaten too much candy, pay 2m to the bank");
                player.saldoOpdatering(-2);
                ChanceCardNumber++;
                break;
            //Player either moves to field 10, 11, 19 or 20 and if it is not bought player gets it for free otherwise the player pays rent
            case 6:
                game.getGui().displayChanceCard("Move to either the Skate Park, the Swimming Pool, the Bowling Alley or the Zoo and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skate Park", "Swimming Pool", "Bowling Alley", "Zoo")) {
                    case "Skate Park":
                        game.setPlayer(player, 10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Swimming Pool":
                        game.setPlayer(player, 11);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Bowling Alley":
                        game.setPlayer(player, 19);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Zoo":
                        game.setPlayer(player, 20);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            //Player either moves to field 4 or 5 and if it is not bought player gets it for free otherwise the player pays rent
            case 7:
                game.getGui().displayChanceCard("Move to either the Candy Store or the Ice Cream Parlor and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Candy Store", "Ice Cream Parlor")) {
                    case "Candy Store":
                        game.setPlayer(player, 4);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Ice Cream Parlor":
                        game.setPlayer(player, 5);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }ChanceCardNumber++;
                break;
            // Player gets a get out of jail card
            case 8:
                game.getGui().displayChanceCard("Get a get out of jail card");
                player.setGetOutOfJail(player.getOutOfJail++);
                ChanceCardNumber++;
                break;
            //Player moves to field 23
            case 9:
                game.getGui().displayChanceCard("Move to the Boardwalk");
                game.setPlayer(player, 23);
                gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                ChanceCardNumber++;
                break;
            //Player either moves to field 10, 11, 19 or 20 and if it is not bought player gets it for free otherwise the player pays rent
            case 10:
                game.getGui().displayChanceCard("Move to either the Museum, the Library, the Water Park or the Boardwalk and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Museum", "Library", "Water Park", "Boardwalk")) {
                    case "Museum":
                        game.setPlayer(player, 7);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Library":
                        game.setPlayer(player, 8);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Water Park":
                        game.setPlayer(player, 22);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Boardwalk":
                        game.setPlayer(player, 23);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                break;
                //players get paid 2m by the bank

            case 11:
                game.getGui().displayChanceCard("You have done your homework, gain 2m from the bank");
                player.saldoOpdatering(2);
                ChanceCardNumber++;
                break;
            //Player either moves to field 13 or 14
            case 12:
                game.getGui().displayChanceCard("Move to either the Arcade or the Cinema and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Arcade", "Cinema")) {
                    case "Arcade":
                        game.setPlayer(player, 13);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Cinema":
                        game.setPlayer(player, 14);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            //Player either moves to field 10
            case 13:
                game.getGui().displayChanceCard("Move to Skate Park");
                game.setPlayer(player, 10);
                gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                ChanceCardNumber++;
                break;
            //Player either moves to field 4, 5, 13 or 14 and if it is not bought player gets it for free otherwise the player pays rent
            case 14:
                game.getGui().displayChanceCard("Move to either the Candy Store, Ice Cream Parlor, Arcade or the Cinema and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Candy Store", "Ice Cream Parlor", "Arcade", "Cinema")) {
                    case "Candy Store":
                        game.setPlayer(player, 4);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Ice Cream Parlor":
                        game.setPlayer(player, 5);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Arcade":
                        game.setPlayer(player, 13);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Cinema":
                        game.setPlayer(player, 14);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            //Player either moves to field 1, 2, 16 or 17 and if it is not bought player gets it for free otherwise the player pays rent
            case 15:
                game.getGui().displayChanceCard("Move to either the Burger Joint, Pizzeria, Toy Store or the Pet Shop and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Burger Joint", "Pizzeria", "Toy Store", "Pet Shop")) {
                    case "Burger Joint":
                        game.setPlayer(player, 1);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Pizzeria":
                        game.setPlayer(player, 2);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Toy Store":
                        game.setPlayer(player, 16);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Pet Shop":
                        game.setPlayer(player, 17);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }ChanceCardNumber++;
                break;
        }
        if (ChanceCardNumber>15)
            ChanceCardNumber=1;

        }
    }
