
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by josephmolina on 6/13/17.
 */
public class GameBoard {

    /*
    TO DO:
        Create method to show the rest of the bombs when the user loses.
     */
    private Tile[][] gameBoard;
    private int xdim = 8;
    private int ydim = 8;
    private List<Pair> listOfBombs = new ArrayList<>();

    public GameBoard(){
        gameBoard = new Tile[xdim][ydim];
        for(int row = 0; row < xdim; row++){
            for(int col = 0; col < ydim; col++){
                gameBoard[row][col] = new Tile();
            }
        }
    }

    public Tile[][] getGameBoard(){
        return gameBoard;
    }
    public void gameOver(Tile[][] gameBoard){
        for(int bomb = 0; bomb < listOfBombs.size();bomb++){
            Pair temp = listOfBombs.get(bomb);
            gameBoard[temp.getX()][temp.getY()].setFaceUp("*");
        }
        displaygameBoard();
    }

    public void displaygameBoard(){
        for(int row = 0; row < xdim; row++){
            for(int col = 0; col < ydim; col++){
                System.out.print(gameBoard[row][col].getFaceUp() + "|");
            }
            System.out.println();
        }
    }

    public int generateRandomNumber(){

        Random rn = new Random();
        int range = 7 - 0+ 1;
        int randomNum =  rn.nextInt(range) + 0;
        return randomNum;
    }

    public void fillBoardBombs(){
        int row, col = 0;
        for(int i = 0; i < 9; i++){
            row = generateRandomNumber();
            col = generateRandomNumber();
            listOfBombs.add(new Pair(row, col));
            gameBoard[row][col].setBomb(true);
            updateNearByBombs(row, col);
        }
    }

    public boolean checkIfBomb(int x, int y){
        if(gameBoard[x][y].isBomb() == true){
            return true;
        }
        return false;
    }

    public void showTileBomb(int x, int y){
        gameBoard[x][y].setFaceUp(String.valueOf(gameBoard[x][y].getNumBombsNearBy()));
    }


    public void updateNearByBombs(int inputrow, int inputcol){

        //For (0,0)
        if(inputrow == 0 && inputcol == 0){
            for(int row = inputrow; row <= inputrow + 1; row++){
                for(int col = inputcol; col <= inputcol + 1; col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }

        //For (0, (1 - 6))
        else if(inputrow == 0 &&(inputcol >= 1 && inputcol <= 6)){
            for(int row = inputrow; row <= inputrow + 1; row++){
                for(int col = inputcol - 1; col <= inputcol + 1; col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }

        //For (0,7)
        else if(inputrow == 0 && inputcol == 7){
            for(int row = inputrow; row <= inputrow + 1; row++){
                for(int col = inputcol - 1; col <= inputcol;col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }


        //For (1 - 6), 0)
        else if((inputrow >= 1 && inputrow <= 6) && inputcol == 0){
            for(int  row = inputrow - 1; row <= inputrow + 1; row++){
                for(int col = inputcol; col <= inputcol + 1; col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }

        //For (7,0)
        else if(inputrow == 7 && inputcol == 0){
            for(int  row = inputrow - 1; row<= inputrow;row++){
                for(int col = inputcol; col <= inputcol + 1;col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }

        //For (7, (1 - 6))
        else if(inputrow == 7 && (inputcol >= 1 && inputcol <= 6)){
            for(int row = inputrow - 1; row <= inputrow; row++){
                for(int col = inputcol - 1; col <= inputcol + 1; col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }

        //For (7,7)
        else if(inputrow == 7 && inputcol == 7){
            for(int row = inputrow - 1; row <= inputrow; row++){
                for(int col = inputcol - 1; col <= inputcol; col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }


        //For (1 - 6), 7)
        else if((inputrow >= 1 && inputrow <= 6) && inputcol == 7){
            for(int row = inputrow - 1; row<= inputrow + 1; row++){
                for(int col = inputcol - 1; col <= inputcol;col++){
                    gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
            }
        }


        //for the rest
           else for(int row = inputrow - 1; row <= inputrow + 1; row++){
                for(int col = inputcol - 1; col<= inputcol + 1;col++){
                        gameBoard[row][col].setNumBombsNearBy(gameBoard[row][col].getNumBombsNearBy() + 1);
                }
        }




    }

}
