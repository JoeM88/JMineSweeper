/**
 * Created by josephmolina on 6/13/17.
 */
public class JMineSweeper {

    public static void displayWelcomeMessage(){

        System.out.println("Welcome to JMineSweeper." + "\n"
        + "Enter and X and Y coordinate to select the square.");
    }

    public static void main(String[] args){

        displayWelcomeMessage();
        GameBoard gameBoard = new GameBoard();
        System.out.println("before");
        gameBoard.displaygameBoard();
        gameBoard.fillBoardBombs();
        System.out.println("After");
        gameBoard.displaygameBoard();

    }

}
