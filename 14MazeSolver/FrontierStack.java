import java.util.*;
public class FrontierStack implements Frontier{
    private LinkedList<Location> queue = new LinkedList<>();
    public Location next(){
	return queue.get(queue.size() - 2);
    }
    public void add(Location n){
	queue.addLast(n);
    }
    public boolean hasNext(){
	return queue.size() > 1;
    }
}
