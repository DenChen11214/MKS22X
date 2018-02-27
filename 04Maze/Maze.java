import java.io.*;
import java.util.*;
public class Maze{
    private char[][] mazeBoard;
    private boolean animate;
    public Maze(String filename) throws FileNotFoundException{
	try{
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
	catch(FileNotFoundException e){
	    System.out.println("No such file exists");
	}
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
    private int solve(int row, int col){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}	 
	return -1; 
    }
    public void readMaze(String maze){
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
    public static void main(String args[]){
	Maze m = new Maze("Maze1.txt");
    }
}
