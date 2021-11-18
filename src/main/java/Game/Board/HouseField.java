package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Street;
import Game.Board.GameBoard;

import java.awt.*;

public class HouseField extends Field{



    //private Player owner;
    public HouseField(String name,String description,String subText,Color color) {
        super(name, description, subText, color, Color.black);
    }

    @Override
    protected GUI_Street createGUIField(){
        return new GUI_Street();
    }

    @Override
    public GUI_Street getGuiField() {
        return (GUI_Street) this.guiField;
    }

    @Override
    public void runAction(Player player, Game game) {
        GameBoard gameBoard = game.getGameBoard();

        if(gameBoard.isBought(this)){
            gameBoard.PayRent(this,player, game);
            System.out.println("Betalt husleje");
        } else{
            System.out.println(player);
            if(game.getGui().getUserLeftButtonPressed("Building isn't bought. Do you want to buy the building?", "Yes", "No")){
                gameBoard.BuyBuilding(this, player);
            } else{
                System.out.println("Det virker - Betaler ikke for bygning");
            }

        }


    }
}
