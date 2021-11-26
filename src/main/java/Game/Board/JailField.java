package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Jail;

import javax.swing.*;
import java.awt.*;

public class JailField extends Field {
    boolean useGetOutOfJail;

    private boolean visit = false;

    public JailField(){
        super("Go to jail","Go to jail","Go to jail", Color.white, Color.black);
    }

    public JailField(boolean visit) {
        super("Jail","Jail","Visiting", Color.white, Color.black);
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
        // either use a getOutOfJail card or pay 1m
        if (player.getInJail()) {
            if (player.getOutOfJail > 0) {
                player.getOutOfJail--;
                game.getGui().getUserButtonPressed("You have used a get out of jail free card", "OK");
                player.setOutOfJail();
            } else {
                player.saldoOpdatering(-1);
                game.getGui().getUserButtonPressed("You paid 1m to get out of jail", "OK");
                player.setOutOfJail();
            }
        }
        //puts you into jail
            if (visit == false) {
            game.getGui().getUserButtonPressed("Go to jail", "OK");
            game.setPlayer(player, 6);
            player.setInJail();


        }
    }
}
