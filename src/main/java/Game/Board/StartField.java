package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Start;

import java.awt.*;

public class StartField extends Field{

    protected GUI_Start guiStart;

    public StartField() {
        super("Start", "Start: Collect 2 when you pass.", "Collect 2", Color.white, Color.black);
    }

    @Override
    protected GUI_Start createGUIField(){
        return new GUI_Start();
    }

    @Override
    public GUI_Start getGuiField() {
        return (GUI_Start) this.guiField;
    }

    @Override
    public void runAction(Player player, Game game) {

    }
}
