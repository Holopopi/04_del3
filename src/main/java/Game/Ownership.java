package Game;

import Game.Board.Field;
import Game.Board.GameBoard;

import java.util.HashMap;
//Psuedokode
public class Ownership {

    public Ownership(){
    }

    private HashMap<Integer, Player> playerOwnership = new HashMap<Integer, Player>();
    private GameBoard gameBoard = new GameBoard();
    private int currentFieldValue;
    private Field houseField;

    public void PayRent(int field, Player rentPayer){
        Player owner = playerOwnership.get(field);
        currentFieldValue = Integer.parseInt(gameBoard.getFields()[field].getSubText());
        owner.saldoOpdatering(currentFieldValue);
        rentPayer.saldoOpdatering(-(currentFieldValue));
    }
    public void BuyBuilding(int field, Player buyer){
        playerOwnership.put(field, buyer);
        currentFieldValue = Integer.parseInt(gameBoard.getFields()[field].getSubText());
        buyer.saldoOpdatering(-(currentFieldValue));
    }
    public boolean CheckIfBought(int field){
        boolean bought = playerOwnership.containsKey(field);
        return bought;
    }
}
