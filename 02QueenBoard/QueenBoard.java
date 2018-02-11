import java.util.*;
public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  private boolean addQueen(int r, int c){
    if(board[r][c] >= 1){
	    return false;
    }
    if(board[r][c] == -1){
	    return false;
    }
    if(c  < board[0].length -1){
	    for(int col = c + 1; col < board[0].length;col++){
        board[r][col] += 1;
	    }
	    if(r < board.length - 1 && r > 0){
        int row = r - 1;
        int col = c + 1;
        while(row - 1 > 0 && col + 1 < board[0].length){
          board[row][col] += 1;
          row--;
          col++;
        }
        int ro = r + 1;
        int co = c + 1;
        while(ro + 1 < board.length && co + 1 < board[0].length){
          board[ro][co] +=1;
          ro++;
          col++;
        }
	    }
    }
    return true;
  }
	
  private boolean removeQueen(int r, int c){
    return true;
  }
  public String toString(){
    String output =  "";
    for(int r = 0;r < board.length;r++){
      for(int c = 0; c< board[0].length;c++){
        if(board[r][c] == -1){
          output += "Q ";
        }
        else{
          output += board[r][c] + " ";
        }
      }
      output += "\n";
    }
    return output;
  }
  //use helper
  public boolean solve(){
    return true;
  }
  //use helper
  public int countSolutions(){
    return 0;
  }
  public static void main(String[] args){
    QueenBoard q = new QueenBoard(4);
    System.out.println(q);
    q.addQueen(1,1);
    System.out.println(q);
    System.out.println(Arrays.deepToString(q.board));
  }
}
