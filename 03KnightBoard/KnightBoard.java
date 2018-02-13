public class KnightBoard{
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols){
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
    public boolean solve(int startingRow, int startingCol){
	return true;
    }
    public int countSolutions(int startingRow, int startingCol){
	return 0;
    }
    public static void main(String[] args){
	KnightBoard k = new KnightBoard(5,5);
	k.board[0][1] = 20;
	System.out.println(k);
    }
}
