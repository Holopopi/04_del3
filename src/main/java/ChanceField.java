import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;

import java.awt.*;

public class ChanceField extends Field{

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
}
