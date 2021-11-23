package Game;// Denne klasse bruges til at lave selve spillet

import Game.Board.GameBoard;
import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class Game {

    GameBoard gameboard;
    GUI gui;
    Player[] players;
    Dice dice;
    int amountOfPlayers;
    int startBalance;
    /**
     * Initializes new game
     */
    public Game() {
        this.gameboard = new GameBoard();
        this.gui = new GUI(gameboard.getGuiFields());
        this.players = new Player[]{
                new Player(35, "Beier",new GUI_Car(new Color(65,80,30),Color.blue, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL)),
                new Player(35, "Marcus",new GUI_Car(Color.green,Color.blue, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL)),
                new Player(35, "Jack",new GUI_Car(Color.red,Color.blue, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL)),
                new Player(35, "Joy",new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL))};
        this.dice = new Dice(6);
    }

    /**
     * Amount of players as a user selection. Adds the amount of players the user wishes.
     */
    public void newGame() {
        switch (gui.getUserSelection("How many players?", "2", "3", "4")) {
            case "2":
                addPlayers(2,gui);
                amountOfPlayers = 2;
                startBalance(20);
                break;
            case "3":
                addPlayers(3,gui);
                amountOfPlayers=3;
                startBalance(18);
                break;
            case "4":
                addPlayers(4,gui);
                amountOfPlayers=4;
                startBalance(16);
                break;
        }
    }
    /**
     * method used to initialize an n amount of players.
     */
    private void addPlayers(int n,GUI gui){
        for(int i=0;i<n;i++){
            gui.addPlayer(players[i].getPlayer());
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
        for(int i = 0; i < amountOfPlayers; i++) {
            setPlayer(players[i], 0);
            players[i].saldoOpdatering(-1000);
            players[i].saldoOpdatering(startBalance);
            gameboard.ownership.clear();
        }
        playGame();
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
    public GUI getGui(){
        return this.gui;
    }
    public GameBoard getGameBoard(){
        return this.gameboard;
    }
    void startBalance(int startMoney){
        for(int i=0; i < amountOfPlayers; i++){
            players[i].saldoOpdatering(-100);
            players[i].saldoOpdatering(startMoney);
            startBalance = startMoney;
        }
    }

    public int getDice() {
        return dice.kastTerning();
    }
    public int getAmountOfPlayers(){
        return amountOfPlayers;
    }
}
