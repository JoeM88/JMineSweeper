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
                System.out.print(gameBoard[row][col].getFaceUp() + "|");
            }
            System.out.println();
        }
    }




}
