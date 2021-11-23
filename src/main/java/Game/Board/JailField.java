package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Jail;

import javax.swing.*;
import java.awt.*;

public class JailField extends Field{
    boolean useGetOutOfJail;
    boolean inJail;

    private boolean visit=false;

    public JailField(){
        super("Gå i fængsel","Gå i Fængsel","Gå i Fængsel", Color.white, Color.black);
    }

    public JailField(boolean visit) {
        super("Fængsel","Fængsel","På besøg", Color.white, Color.black);
        this.visit=visit;
    }



    @Override
    protected GUI_Jail createGUIField(){
        return new GUI_Jail();
    }

    @Override
    public GUI_Jail getGuiField() {
        return (GUI_Jail) this.guiField;
    }

    @Override
    public void runAction(Player player, Game game) {
        int k = game.getDice();
        if(visit==false) {
            game.setPlayer(player, 6);
            if (player.getOutOfJail > 0) {
                inJail =false;
                player.getOutOfJail--;
            } else if (!useGetOutOfJail && k != 6)
                inJail = true;
            else
                game.movePlayer(player, 1);
        }
        if (inJail==true){

        }



                }
        }
