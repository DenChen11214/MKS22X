import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  private String[][] mazeBoard;
  public Maze(){
    mazeBoard = new String[9][35];
  }
  public void readMaze(String maze){
    try{
      int r = 0;
      File f = new File(maze);
      Scanner inf = new Scanner(f);
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        for(int c = 0; c < 35; c ++){
          mazeBoard[r][c] = line.substring(c, c + 1);
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
    Maze m = new Maze();
    m.readMaze("Maze1.txt");
    System.out.println(m);
  }
}
