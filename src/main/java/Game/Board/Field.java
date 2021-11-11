package Game.Board;

import Game.Game;
import Game.Player;
import gui_fields.GUI_Field;
import java.awt.Color;

public abstract class Field {


    private String title;
    private String description;
    private String subText;
    protected GUI_Field guiField;

    /**
     * Constructor for Field
     */
    public Field(String title, String description, String subText, Color backgroundColor, Color foregroundColor){
        this.guiField=createGUIField();
        this.setTitle(title);
        this.setDescription(description);
        this.setSubText(subText);
        this.setBackgroundColor(backgroundColor);
        this.setForegroundColor(foregroundColor);
    }

    /**
     * Setter for feltets navn
     */
    protected Field setTitle(String title){
        this.guiField.setTitle(title);
        return this;
    }

    /**
     * Setter for feltets beskrivelse
     */
    protected Field setDescription(String description){
        this.guiField.setDescription(description);
        return this;
    }

    /**
     * Setter for feltets sub tekst
     */
    protected Field setSubText(String subText){
        this.guiField.setSubText(subText);
        return this;
    }

    /**
     * Setter for baggrundsfarven
     */
    public Field setBackgroundColor(Color backgroundColor){
        this.guiField.setBackGroundColor(backgroundColor);
        return this;
    }

    /**
     * Setter for feltets baggrundsfarve
     */
    public Field setForegroundColor(Color foregroundColor){
        this.guiField.setForeGroundColor(foregroundColor);
        return this;
    }

    /**
     * Getter for feltets titel
     */
    protected String getTitle(){
        return this.guiField.getTitle();
    }

    /**
     * Getter for feltets beskrivelse
     */
    protected String getDescription(){
        return this.guiField.getDescription();
    }

    /**
     * Getter for feltets sub tekst
     */
    public String getSubText(){
        return this.guiField.getSubText();
    }


    /**
     * Abstrakt metode for oprettelse af et GUI felt
     */
    abstract protected GUI_Field createGUIField();

    /**
     * Abstrakt getter for feltets GUI felt
     */
    abstract public GUI_Field getGuiField();

    abstract public void runAction(Player player, Game game);

}
