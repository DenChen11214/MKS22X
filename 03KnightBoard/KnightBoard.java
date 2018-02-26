import java.util.*;
public class KnightBoard{
  private int[][] board;
  private final int[] moveSetRow = {-2,-2,-1,1,2,2,1,-1};
  private final int[] moveSetCol = {1,-1,-2,-2,-1,1,2,2};
  public KnightBoard(int startingRows, int startingCols){
    if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
  }
  public String toString(){
    String output = "";
    for(int r = 0;r < board.length; r ++){
	    for(int c = 0; c < board[0].length;c++){
        if(board[r][c] >= 10){
          output += board[r][c] + " ";
        }
        else{
          output += " " + board[r][c] + " ";
        }
	    }
	    output += "\n";
    }
    return output;
  }
  private void nonZero(){
    for(int r = 0;r < board.length; r ++){
	    for(int c = 0; c < board[0].length;c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
	    }
    }
  }
  public boolean solve(int startingRow, int startingCol){
    if(startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
    }
    nonZero();
    board[startingRow][startingCol] = 1;
    return solveHelp(startingRow,startingCol, 1);
  }
  private boolean moveKnight(int row, int col, int level, int i){
    if((row  + moveSetRow[i] < board.length) &&
       col + moveSetCol[i] < board[0].length &&
       row  + moveSetRow[i] >= 0 &&
       col + moveSetCol[i] >= 0 &&
       board[row + moveSetRow[i]][col + moveSetCol[i]] == 0){
      board[row + moveSetRow[i]][col + moveSetCol[i]] = level + 1;
      return true;
    }
    return false;
  }
  private boolean solveHelp(int row, int col, int level){
    if(col < 0 || row < 0){
	    throw new IllegalArgumentException();
    }
    if(level == board.length * board[0].length){
	    return true;
    }
    for(int i = 0;i<8;i++){
      if(moveKnight(row,col,level,i)){
        if(solveHelp(row + moveSetRow[i], col + moveSetCol[i], level + 1)){
          return true;
        }
        board[row + moveSetRow[i]][col + moveSetCol[i]] = 0;

	    }
    }
    return false;
  }
  public int countSolutions(int startingRow, int startingCol){
    return 0;
  }
  public static void main(String[] args){
    KnightBoard k = new KnightBoard(7,7);
    k.solve(1,2);
    System.out.println(k);
  }
}
