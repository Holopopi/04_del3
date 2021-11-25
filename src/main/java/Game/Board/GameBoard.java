package Game.Board;
import Game.Game;
import Game.Player;
import gui_fields.GUI_Field;

import java.awt.*;
import java.util.HashMap;


public class GameBoard {
    public HashMap<HouseField, Player> ownership = new HashMap<>();

    private Field[] fields;

    public GameBoard()
    {
        this.fields = this.createFields();
    }

    public Field[] getFields() {
        return this.fields;
    }
    public boolean freeBuilding;
    public GUI_Field[] getGuiFields(){
        GUI_Field[] fields = new GUI_Field[this.fields.length];
        for (int i=0; i<this.fields.length; i++) {
            fields[i] = this.fields[i].getGuiField();

        }
        return fields;
    }

    private Field[] createFields() {
        return new Field[]{
                new StartField(),
                new HouseField("Burger Joint","Burger Joint","1", new Color(65,80,30)),
                new HouseField("Pizzeria","Pizzeria","1", new Color(65,80,30)),
                new ChanceField(),
                new HouseField("Candy Store","Candy Store","1", new Color(173,216,230)),
                new HouseField("Ice Cream Parlor","Ice Cream Parlor","1", new Color(173,216,230)),
                new JailField(true),
                new HouseField("Museum","Museum","2", Color.pink),
                new HouseField("Library","Library","2", Color.pink),
                new ChanceField(),
                new HouseField("Skate Park","Skate Park","2", Color.orange),
                new HouseField("Swimming Pool","Swimming Pool","2", Color.orange),
                new ParkingField(),
                new HouseField("Arcade","Arcade","3", Color.red),
                new HouseField("Cinema","Cinema","3", Color.red),
                new ChanceField(),
                new HouseField("Toy Store","Toy Store","3", Color.yellow),
                new HouseField("Pet Shop","Pet Shop","3", Color.yellow),
                new JailField(),
                new HouseField("Bowling Alley","Bowling Alley","4", Color.green),
                new HouseField("Zoo","Zoo","4", Color.green),
                new ChanceField(),
                new HouseField("Water Park","Water Park","5", Color.blue),
                new HouseField("The Boardwalk","The Boardwalk","5", Color.blue),
        };
    }
    private int currentFieldValue;
    public void removePlayer(Player player) {
        for (int i=0; i<this.fields.length; i++) {
            this.fields[i].getGuiField().setCar(player.getPlayer(),false);
        }
    }
    public boolean isBought(HouseField houseField){
        return ownership.containsKey(houseField);
    }


    public void BuyBuilding(HouseField field, Player buyer, Game game){
        currentFieldValue = Integer.parseInt(field.getSubText());
        if(currentFieldValue < buyer.getSaldo()) {
            game.getGui().getUserButtonPressed("This building isn't bought. You have enough money to buy it!", "Buy");
            ownership.put(field, buyer);
            buyer.saldoOpdatering(-(currentFieldValue));
        }else {
            game.getGui().getUserButtonPressed("This building isn't bought. You don't have enough money to buy it", "Continue");
        }
    }
    public void PayRent(HouseField field, Player rentPayer, Game game){
            Player owner = ownership.get(field);
            if(owner!=rentPayer) {
                currentFieldValue = Integer.parseInt(field.getSubText());
                String str = "This building is owned. You have to pay " + currentFieldValue + "M to "+ owner.getNavn();
                game.getGui().getUserButtonPressed(str, "Okay");
                owner.saldoOpdatering(currentFieldValue);
                rentPayer.saldoOpdatering(-(currentFieldValue));
            }
    }
    public void chanceFreeBuilding(HouseField field, Player buyer, Game game){
        currentFieldValue = Integer.parseInt(field.getSubText());
        if(isBought(field)) {
            game.getGui().getUserButtonPressed("The free building is already claimed, you have to pay rent","Pay rent");
            Player owner = ownership.get(field);
            if(owner!=buyer) {
                currentFieldValue = Integer.parseInt(field.getSubText());
                owner.saldoOpdatering(currentFieldValue);
                buyer.saldoOpdatering(-(currentFieldValue));
            }
        }else {
            ownership.put(field, buyer);
            game.getGui().getUserButtonPressed("This free building isn't claimed. It's yours for free!", "Claim");
        }
    }
}
