package Game.Board;
import Game.Game;
import Game.Player;
import gui_fields.GUI_Field;

import java.awt.*;
import java.util.HashMap;


public class GameBoard {
    protected HashMap<HouseField, Player> ownership = new HashMap<>();

    private Field[] fields;


    public GameBoard()
    {
        this.fields = this.createFields();
    }

    public Field[] getFields() {
        return this.fields;
    }

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
                new HouseField("Burgerbaren","Burgerbaren","1", new Color(65,80,30)),
                new HouseField("Pizzeriaet","Pizzeriaet","1", new Color(65,80,30)),
                new ChanceField(),
                new HouseField("Slikbutikken","Slikbutikken","1", new Color(173,216,230)),
                new HouseField("Iskiosken","Iskiosken","1", new Color(173,216,230)),
                new JailField(true),
                new HouseField("Museet","Museet","2", Color.pink),
                new HouseField("Biblioteket","Biblioteket","2", Color.pink),
                new ChanceField(),
                new HouseField("Skateparken","Skateparken","2", Color.orange),
                new HouseField("Swimmingpoolen","Swimmingpoolen","2", Color.orange),
                new ParkingField(),
                new HouseField("Spillehallen","Spillehallen","3", Color.red),
                new HouseField("Biografen","Biografen","3", Color.red),
                new ChanceField(),
                new HouseField("Legetøjsbutikken","Legetøjsbutikken","3", Color.yellow),
                new HouseField("Dyrehandlen","Dyrehandlen","3", Color.yellow),
                new JailField(),
                new HouseField("Bowlinghallen","Bowlinghallen","4", Color.green),
                new HouseField("Zoo","Zoo","4", Color.green),
                new ChanceField(),
                new HouseField("Vandlandet","Vandlandet","5", Color.blue),
                new HouseField("Strandpromenaden","Strandpromenaden","5", Color.blue),






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
    public boolean isBought (ChanceField houseField){return ownership.containsKey(houseField);}
    public void BuyBuilding(ChanceField field, Player buyer, Game game){

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
    public void PayRent(ChanceField field, Player rentPayer, Game game){
        Player owner = ownership.get(field);
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
            game.getGui().getUserButtonPressed("This building is bought. You have to pay rent","Pay rent");
            PayRent(field, buyer, game);
        }else {
            ownership.put(field, buyer);
            game.getGui().getUserButtonPressed("This building isn't bought. It's yours for free!", "Continue");
        }
    }
}
