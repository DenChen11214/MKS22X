public class KnightBoard{
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
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
    private boolean
    public boolean solve(int startingRow, int startingCol){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	nonZero();
	return solveHelp(int startingRow, int startingCol, 0);
    }
    private boolean solveHelp(int row, int col, int level){
	int[][] moves = new int[8][8];
	
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	nonZero();
	
	return true;
    }
    public int countSolutions(int startingRow, int startingCol){
	return 0;
    }
    public static void main(String[] args){
	KnightBoard k = new KnightBoard(5,5);
	System.out.println(k);
    }
}
