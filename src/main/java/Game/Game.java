package Game;// Denne klasse bruges til at lave selve spillet

import Game.Board.Field;
import Game.Board.GameBoard;
import Game.Board.HouseField;
import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class Game {

    GameBoard gameboard;
    GUI gui;
    Player[] players;
    Dice dice;
    int amountOfPlayers;

    /**
     * Initializes new game
     */
    public Game() {
        this.gameboard = new GameBoard();
        this.gui = new GUI(gameboard.getGuiFields());
        this.players = new Player[]{
                new Player(0, "Beier",new GUI_Car(new Color(65,80,30),Color.blue, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL)),
                new Player(0, "Marcus",new GUI_Car(Color.green,Color.blue, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL)),
                new Player(0, "Jack",new GUI_Car(Color.red,Color.blue, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL)),
                new Player(0, "Joy",new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL))};
        this.dice = new Dice(6);
    }

    /**
     * Amount of players as a user selection. Adds the amount of players the user wishes.
     */
    public void newGame() {
        switch (gui.getUserSelection("How many players?", "2", "3", "4")) {
            case "2":
                addPlayers(20,2,gui);
                break;
            case "3":
                addPlayers(18,3,gui);
                break;
            case "4":
                addPlayers(16,4,gui);
                break;
        }
    }
    /**
     * method used to initialize an n amount of players.
     */
    public void addPlayers(int saldo, int n,GUI gui){
        amountOfPlayers=n;
        for(int i=0;i<n;i++){
            gui.addPlayer(players[i].getPlayer());
            players[i].saldoOpdatering(saldo);
        }
    }


    /**
     * Starts the game
     */
    public void playGame(){
        int i = 0;
        int playersTurn;

        while(players[1].getSaldo()>0){
            playersTurn=i%amountOfPlayers;
            takeTurn(players[playersTurn]);
            i++;
        }


    }
    public void restartGame(){
        newGame();
        playGame();
        return;
    }
    /**
     * Player takes a turn.
     */
    private void takeTurn(Player player){
        this.gui.getUserButtonPressed("kast","kast");

        int dice = this.dice.kastTerning();
        this.gui.setDie(dice);
        movePlayer(player,dice);
        this.gameboard.getFields()[player.getLocationIndex()].runAction(player,this);
        if(player.getSaldo() <= 0){
            if(gui.getUserLeftButtonPressed( player.getNavn() + " has lost the game! Do you want to start a new game?","Yessirrr", "Noo")){
                restartGame();
            } else{
                System.exit(0);
            }
        }
    }

    /**
     * Player moves to new field.
     */
    public void movePlayer(Player player, int dice) {
        this.gameboard.removePlayer(player);
        int newLocation=dice+player.getLocationIndex();
        player.setLocationIndex(newLocation);
        this.gameboard.getGuiFields()[player.getLocationIndex()].setCar(player.getPlayer(),true);
    }
    public void setPlayer(Player player,int indexLocation) {
        this.gameboard.removePlayer(player);
        player.setLocationIndex(indexLocation);
        this.gameboard.getGuiFields()[player.getLocationIndex()].setCar(player.getPlayer(),true);
    }


    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public GUI getGui(){
        return this.gui;
    }
    public GameBoard getGameBoard(){
        return this.gameboard;
    }

}
