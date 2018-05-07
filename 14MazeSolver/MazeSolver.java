public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
  private boolean animate = true;

  public MazeSolver(String mazeText){
    maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    if(mode == 0){
      frontier = new FrontierQueue();
      
    }
    if(mode == 1){
      frontier = new FrontierStack();
      Location current = maze.getStart();
      frontier.add(current);
      while(frontier.hasNext()){
        if(animate){
          clearTerminal();
          System.out.println(this);
          wait(20);
        }
        Location[] neigh = maze.getNeighbors(current);
        for(int i = 0; i < neigh.length;i++){
          frontier.add(neigh[i]);
          maze.set(neigh[i].getX(),neigh[i].getY(),'?');
        }
        maze.set(current.getX(),current.getY(), '.');
        current = frontier.next();
        if(current.getX() == maze.getEnd().getX() && current.getY() == maze.getEnd().getY()){
          while(current.getPrevious() != null){
            maze.set(current.getX(),current.getY(), '@');
            current = current.getPrevious();
          }
          maze.set(maze.getStart().getX(),maze.getStart().getY(),'@');
          return true;
          
        }
      }
    }
    return false;
  }
  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
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
  public String toString(){
    return maze.toString();
  }
  public static void main(String[] args){
    MazeSolver s = new MazeSolver("data1.txt");
    s.solve(1);
    System.out.println(s);
  }
}

