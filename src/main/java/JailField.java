import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Start;

import java.awt.*;

public class JailField extends Field{

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
}
