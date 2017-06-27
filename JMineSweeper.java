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


    public static String askForUserInput() {
        Scanner input = new Scanner(System.in);
        String xy = null;
        System.out.print("Enter x and y coordinates seperated by a space: ");
        return xy = input.nextLine();
    }

    public static boolean isCorrectInput(String input){
        if(input.matches(regex)){
            return true;
        }
        return false;
    }

    public static List<Integer> convertUserInput(String input){
        String [] splited = input.split("\\s+");
        List<Integer> coordinates =  new ArrayList<>();
        for(int i = 0; i < splited.length; i++){
            coordinates.add(Integer.parseInt(splited[i]));
        }
        return coordinates;
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
                    List<Integer> coordinates = convertUserInput(userInput);
                    System.out.println(coordinates.toString());
                    if(gameBoard.checkIfBomb(coordinates.get(0), coordinates.get(1))){
                        System.out.println("You lose, tile is a bomb");
                        gameBoard.gameOver(gameBoard.getGameBoard());
                        gameOver = true;
                    }else{
                        gameBoard.showTileBomb(coordinates.get(0), coordinates.get(1));
                    }
                }
            }catch (Exception e){
                System.out.println("Incorrect input");
            }
        }




    }
}
