import gui_main.GUI;

public class MarcusTester {
    public static void main(String[] args) {
        GameBoard gameboard = new GameBoard();


        GUI gui = new GUI(gameboard.getGuiFields());

    }
}
