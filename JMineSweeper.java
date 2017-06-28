import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by josephmolina on 6/13/17.
 */
public class JMineSweeper {

    final static String regex = "^[0-7]\\s+[0-7]$";
    private static List<Pair> previousInput = new ArrayList<>();

    public static String askForUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x and y coordinates starting at 0 and ending at 7, separated by a space: ");
        return input.nextLine();
    }

    public static boolean isCorrectInput(String input){
        return input.matches(regex);
    }

    public static Pair convertUserInput(String input){
        String [] splitted = input.split("\\s+");
        return new Pair(Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1]));
    }

    public static boolean isPreviousInput(Pair pair){
       return previousInput.contains(pair);
    }

    public static void main(String[] args) {
        Boolean gameOver = false;
        GameBoard gameBoard = new GameBoard();
        gameBoard.fillBoardBombs();


        while(!gameOver){
            try{
                gameBoard.displaygameBoard();
                String userInput = askForUserInput();
                if(isCorrectInput(userInput)){
                    Pair coordinates = convertUserInput(userInput);
                    if(gameBoard.checkIfBomb(coordinates.getX(), coordinates.getY())){
                        System.out.println("You lose, tile is a bomb");
                        gameBoard.gameOver(gameBoard.getGameBoard());
                        gameOver = true;
                    }
                    else{
                        gameBoard.showTileBomb(coordinates.getX(), coordinates.getY());
                    }
                }
            }catch (Exception e){
                System.out.println("Incorrect input");
            }
        }





    }
}
