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
    board[r][c] = 0;
    if(c  < board[0].length -1){
	    for(int col = c + 1; col < board[0].length;col++){
        board[r][col] -= 1;
	    }
	    if(r < board.length){
        int row = r - 1;
        int col = c + 1;
        while(row  >= 0 && col < board[0].length){
          board[row][col] -= 1;
          row--;
          col++;
        }
      }
      if(r >= 0){
        int ro = r + 1;
        int co = c + 1;
        while(ro  < board.length && co  < board[0].length){
          board[ro][co] -=1;
          ro++;
          co++;
        }
      }
    }
    
    return false;
  }
  public String toString(){
    String output =  "";
    for(int r = 0;r < board.length;r++){
      for(int c = 0; c< board[0].length;c++){
        if(board[r][c] == -1){
          output += "Q ";
        }
        else{
          output += "_ ";
        }
      }
      output += "\n";
    }
    return output;
  }

  public boolean solve(){
    for(int r = 0;r < board.length;r++){
      for(int c = 0;c < board.length;c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveHelp(0);
  }
  public boolean solveHelp(int col){
    if(col >= board.length){
      return true;
    }
    for(int r = 0;r < board[0].length; r++){
      if(addQueen(r,col)){
        if(solveHelp(col + 1)){
          return true;
        }
        removeQueen(r,col);
      }
    }
  return false;
  }

  public int countSolutions(){
    for(int r = 0;r < board.length;r++){
      for(int c = 0;c < board.length;c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    int sol = countHelp(0,0);
    for(int r = 0;r < board.length;r++){
      for(int c = 0;c < board.length;c++){
        board[r][c] = 0;
      }
    }
    return sol;
  }
  public int countHelp(int col, int counter){
    for(int r = 0;r < board[0].length; r++){
      if(addQueen(r,col)){
        if(solveHelp(col + 1)){
          counter++;
        }
        removeQueen(r,col);
      }
    }
  return counter;
  }
  public static void main(String[] args){
    QueenBoard q = new QueenBoard(4);
    System.out.println(q.countSolutions());

  }
}
