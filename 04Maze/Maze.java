import java.io.*;
import java.util.*;
public class Maze{
    private char[][] mazeBoard;
    private boolean animate;
    private int eRow;
    private int eCol;
    private int numA;
    private int[] rows = {-1,0,1,0};
    private int[] cols = {0,-1,0,1};
    public Maze(String filename) throws FileNotFoundException{
	int s = 0;
	int e = 0;
	int r = 0;
	int c = 0;
	File f = new File(filename);
	Scanner inf = new Scanner(f);
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    c = line.length();
	    for(int i = 0; i < line.length(); i++){
		if(line.charAt(i) == 'S'){
		    s++;
		}
		if(line.charAt(i) == 'E'){
		    e++;
		    eRow = r;
		    eCol = c;
		}
	    }
	    r++;
	}
	if(s != 1 || e != 1){
	    throw new IllegalStateException();
	}
	mazeBoard = new char[r][c];
	this.readMaze(filename);
	
    }
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public void setAnimate(boolean b){
        animate = b;
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
  
    private void readMaze(String maze){
	try{
	    int r = 0;
	    File f = new File(maze);
	    Scanner inf = new Scanner(f);
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int c = 0; c < line.length(); c ++){
		    mazeBoard[r][c] = line.charAt(c);
		}
		r +=1;
	    }
	}
	catch(FileNotFoundException e){
	}
    }
    
    public String toString(){
	String str = "";
	for(int r = 0; r < mazeBoard.length;r++){
	    for(int c = 0;c < mazeBoard[0].length;c++){
		str += mazeBoard[r][c];
	    }
	    str += "\n";
	}
	return str;
    }
    public int solve(){
	for(int r = 0;r < mazeBoard.length;r++){
	    for(int c = 0; c < mazeBoard[0].length;c ++){
		if(mazeBoard[r][c] == 'S'){
		    mazeBoard[r][c] = ' ';
		    return solve(r,c);
		}
	    }
	}
	return 0;
    }
    private boolean canMove(int row, int col,int i){
	if(row + rows[i] > mazeBoard.length ||
	   row + rows[i] <= 0 ||
	   col + cols[i] > mazeBoard[0].length ||
	   col + cols[i] <= 0){
	    return false;
	}
	if(mazeBoard[row + rows[i]][col + rows[i]] == '#' ||
	   mazeBoard[row + rows[i]][col + rows[i]] == '@' ||
	   mazeBoard[row + rows[i]][col + rows[i]] == '.'){
	    return false;
	}
	return true;
    }
    private int solve(int row, int col){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}	 
	if(row == eRow && col == eCol){
	    return numA;
	}
	for(int i = 0; i < 4;i++){
	    if(canMove(row,col,i)){
		mazeBoard[row][col] = '@';
		numA ++;
		solve(row + rows[i], col + cols[i]);
	    }
	}
	mazeBoard[row][col] = '.';
	numA --;
	return 0;
    }
    public static void main(String args[]){
	try{
	    Maze m = new Maze("Maze1.txt");
	    m.solve();
	    System.out.println(m);
	}
	catch(FileNotFoundException e){
	    
	}
	
    }
	
}
