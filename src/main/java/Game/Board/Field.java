package Game.Board;

import gui_fields.GUI_Field;
import java.awt.Color;

public abstract class Field {


    private String title;
    private String description;
    private String subText;
    protected GUI_Field guiField;


    public Field(String title, String description, String subText, Color backgroundColor, Color foregroundColor){
        this.guiField=createGUIField();
        this.setTitle(title);
        this.setDescription(description);
        this.setSubText(subText);
        this.setBackgroundColor(backgroundColor);
        this.setForegroundColor(foregroundColor);
    }

    protected Field setTitle(String title){
        this.guiField.setTitle(title);
        return this;
    }
    protected Field setDescription(String description){
        this.guiField.setDescription(description);
        return this;
    }
    protected Field setSubText(String subText){
        this.guiField.setSubText(subText);
        return this;
    }
    public Field setBackgroundColor(Color backgroundColor){
        this.guiField.setBackGroundColor(backgroundColor);

        return this;
    }
    public Field setForegroundColor(Color foregroundColor){
        this.guiField.setForeGroundColor(foregroundColor);
        return this;
    }

    protected String getTitle(){
        return this.guiField.getTitle();
    }
    protected String getDescription(){
        return this.guiField.getDescription();
    }
    protected String getSubText(){
        return this.guiField.getSubText();
    }

    abstract protected GUI_Field createGUIField();

    abstract public GUI_Field getGuiField();

}
