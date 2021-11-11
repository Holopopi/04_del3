package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Street;

import java.awt.*;

public class ParkingField extends Field{

    public ParkingField() {
        super("Gratis Parkering", "Gratis Parkering", "", new Color(10 ,125,255), Color.black);
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

    }
}
