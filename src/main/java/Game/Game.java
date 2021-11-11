package Game;// Denne klasse bruges til at lave selve spillet

import Game.Board.GameBoard;
import gui_main.GUI;

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
        this.players = new Player[]{new Player(35, "Beier"), new Player(35, "Marcus"),
                new Player(35, "Jack"), new Player(35, "Joy")};
        this.dice = new Dice(6);
    }

    /**
     * Amount of players as a user selection. Adds the amount of players the user wishes.
     */
    public void newGame() {
        switch (gui.getUserSelection("How many players?", "2", "3", "4")) {
            case "2":
                addPlayers(2,gui);
                amountOfPlayers=2;
                break;
            case "3":
                addPlayers(3,gui);
                amountOfPlayers=3;
                break;
            case "4":
                addPlayers(4,gui);
                amountOfPlayers=4;
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

    /**
     * Player takes a turn.
     */
    private void takeTurn(Player player){
        this.gui.getUserButtonPressed("kast","kast");

        int dice = this.dice.kastTerning();
        this.gui.setDie(dice);
        movePlayer(player,dice);
    }

    /**
     * Player moves to new field.
     */
    private void movePlayer(Player player, int dice) {
        this.gameboard.removePlayer(player);
        int newLocation=dice+player.getLocationIndex();
        player.setLocationIndex(newLocation);
        this.gameboard.getGuiFields()[player.getLocationIndex()].setCar(player.getPlayer(),true);
    }
}
