import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;

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
}
