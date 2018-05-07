import java.util.*;
public class FrontierQueue implements Frontier{
  private LinkedList<Location> queue = new LinkedList<>();
  public FrontierQueue(){};
  public Location next(){
    return queue.removeFirst();
  }
  public void add(Location n){
    queue.addFirst(n);
  }
  public boolean hasNext(){
    return queue.size() >=1;
  }
}
