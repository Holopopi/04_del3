package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class ChanceField extends Field{
    static int ChanceCardNumber =1;
    boolean moveOrTakeCard;
    boolean birthday;



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
//Chance card Switch
        switch (ChanceCardNumber) {
            //Player move to start and get 2m
            case 1:
                game.getGui().displayChanceCard("Move to start and recive 2M");
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
                game.getGui().displayChanceCard("Move to either Skateparken or Swimmingpoolen and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skaterparken", "Swimmingpoolen")) {
                    case "Skaterparken":
                        game.setPlayer(player, 10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Swimmingpoolen":
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
                game.getGui().displayChanceCard("You have eaten to much candy pay 2m to the bank");
                player.saldoOpdatering(-2);
                ChanceCardNumber++;
                break;
            //Player either moves to field 10, 11, 19 or 20 and if it is not bought player gets it for free otherwise the player pays rent
            case 6:
                game.getGui().displayChanceCard("Move to either Skateparken, Swimmingpoolen, Bowlinghallen or the zoo and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Skaterparken", "Swimmingpoolen", "Bowlinghallen", "Zoo")) {
                    case "Skaterparken":
                        game.setPlayer(player, 10);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Swimmingpoolen":
                        game.setPlayer(player, 11);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Bowlinghallen":
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
                game.getGui().displayChanceCard("Move to either Slikbutikken or Iskiosken  and if the field isn't owned you get it for free");
                ;
                switch (game.getGui().getUserButtonPressed("", "Slikbutikken", "Iskiosken")) {
                    case "Slikbutikken":
                        game.setPlayer(player, 4);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Iskiosken":
                        game.setPlayer(player, 5);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                }
                ChanceCardNumber++;
                break;
            // Player gets a get out of jail card
            case 8:
                game.getGui().displayChanceCard("Get a get out of jail card");
                player.setGetOutOfJail(player.getOutOfJail++);
                ChanceCardNumber++;
                break;
            //Player moves to field 23
            case 9:
                game.getGui().displayChanceCard("Move to Strandpromennaden ");
                game.setPlayer(player, 23);
                gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                ChanceCardNumber++;
                break;
            //Player either moves to field 10, 11, 19 or 20 and if it is not bought player gets it for free otherwise the player pays rent
            case 11:
                game.getGui().displayChanceCard("Move to either Museet, Biblioteket, Bowlinghallen or the zoo and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Museet", "Biblioteket", "Vandlandet", "Strandpromenaden")) {
                    case "Museet":
                        game.setPlayer(player, 7);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Biblioteket":
                        game.setPlayer(player, 8);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Vandlandet":
                        game.setPlayer(player, 22);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Strandpromenaden":
                        game.setPlayer(player, 23);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;

            case 12:
                game.getGui().displayChanceCard("You have made your homework gain 2m from the bank");
                player.saldoOpdatering(2);
                break;
            case 13:
                game.getGui().displayChanceCard("Move to either Spillehallen or Biografen  and if the field isn't owned you get it for free");
                ;
                switch (game.getGui().getUserButtonPressed("", "Spillehallen", "Biografen")) {
                    case "Spillehallen":
                        game.setPlayer(player, 13);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Biografen":
                        game.setPlayer(player, 14);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            case 14:
                game.getGui().displayChanceCard("Move to Skaterparken ");
                game.setPlayer(player, 10);
                gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                ChanceCardNumber++;
                break;
            case 15:
                game.getGui().displayChanceCard("Move to either Slikbutikken, Iskiosken, Spillehallen  or Biografen and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Slikbutikken", "Iskiosken", "Spillehallen", "Biografen")) {
                    case "Slikbutikken":
                        game.setPlayer(player, 4);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Iskiosken":
                        game.setPlayer(player, 5);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Spillehallen":
                        game.setPlayer(player, 13);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Biografen":
                        game.setPlayer(player, 14);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
            case 16:
                game.getGui().displayChanceCard("Move to either Burgerbaren, Pizzertiaet, Legetøjsbutikken  or Dyrehandlen and if the field isn't owned you get it for free");
                switch (game.getGui().getUserButtonPressed("", "Burgerbaren", "Pizzertiaet", "Legetøjsbutikken", "Dyrehandlen")) {
                    case "Burgerbaren":
                        game.setPlayer(player, 1);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Pizzertiaet":
                        game.setPlayer(player, 2);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Legetøjsbutikken":
                        game.setPlayer(player, 16);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                    case "Dyrehandlen":
                        game.setPlayer(player, 17);
                        gameBoard.freeBuilding = true;
                        gameBoard.getFields()[player.getLocationIndex()].runAction(player, game);
                        break;
                }
                ChanceCardNumber++;
                break;
        }
        if (ChanceCardNumber>16)
            ChanceCardNumber=1;
        }
    }
