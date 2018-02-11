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
    board[r][c] = -1;
    if(c  < board[0].length -1){
	    for(int col = c + 1; col < board[0].length;col++){
        board[r][col] += 1;
	    }
	    if(r < board.length){
        int row = r - 1;
        int col = c + 1;
        while(row  >= 0 && col < board[0].length){
          board[row][col] += 1;
          row--;
          col++;
        }
      }
      if(r >= 0){
        int ro = r + 1;
        int co = c + 1;
        while(ro  < board.length && co  < board[0].length){
          board[ro][co] +=1;
          ro++;
          co++;
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
    q.addQueen(2,0);
    System.out.println(q);
    q.addQueen(2,3);
    System.out.println(q);
    q.addQueen(1,2);
    System.out.println(q);
  }
}
