import java.util.Random;

/**
 * Created by josephmolina on 6/13/17.
 */
public class GameBoard {

    private Tile[][] gameBoard;

    public GameBoard(){
        gameBoard = new Tile[9][9];
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                gameBoard[row][col] = new Tile();
            }
        }
    }

    public void displaygameBoard(){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                System.out.print(gameBoard[row][col].isBomb() + "|");
            }
            System.out.println();
        }
    }

    public int generateRandomNumber(){

        Random rn = new Random();
        int range = 8 - 0+ 1;
        int randomNum =  rn.nextInt(range) + 0;
        return randomNum;
    }

    public void fillBoardBombs(){
        int row, col = 0;
        for(int i = 0; i < 9; i++){
            row = generateRandomNumber();
            col = generateRandomNumber();
            gameBoard[row][col].setBomb(true);
        }
    }




}
