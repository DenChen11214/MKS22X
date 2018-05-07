import java.util.*;
public class FrontierStack implements Frontier{
  private LinkedList<Location> stack = new LinkedList<>();
  public FrontierStack(){
  }
  public Location next(){
    return stack.removeLast();
  }
  public void add(Location n){
    stack.addLast(n);
  }
  public boolean hasNext(){
    return stack.size() >= 1;
  }
}
