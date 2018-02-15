public class KnightBoard{
    private int[][] board;
    private final int[] moveSetRow = {-2,-2,-1,1,2,2,1,-1};
    private final int[] moveSetCol = {1,-1,-2,-2,-1,1,2,-2};
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
	return solveHelp(startingRow,startingCol, 0);
    }
    private boolean solveHelp(int row, int col, int level){
	if(col < 0 || row < 0){
	    throw new IllegalArgumentException();
	}

	if(level > board.length * board[0].length){
	    return true;
	}
	board[row][col] = level + 1;
	for(int i = 0; i < 8;i++){
	    System.out.println(i);
	    System.out.println(moveSetRow[i]);
	    //row + a neg could be less or sth
	    if(row  + moveSetRow[i] < board.length &&
	       col + moveSetCol[i] < board[0].length &&
	       row  + moveSetRow[i] >= 0 &&
	       col + moveSetCol[i] >= 0 &&
	       board[row + moveSetRow[i]][col + moveSetRow[i]] == 0){
		if(solveHelp(row + moveSetRow[i], col + moveSetCol[i], level + 1)){
		    return true;
		}
	    }
	}
	return true;
    }
    public int countSolutions(int startingRow, int startingCol){
	return 0;
    }
    public static void main(String[] args){
	KnightBoard k = new KnightBoard(5,5);
	k.solve(1,1);
	System.out.println(k);
    }
}
