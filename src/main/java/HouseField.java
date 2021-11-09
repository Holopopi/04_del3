import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;

public class HouseField extends Field{

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
}
