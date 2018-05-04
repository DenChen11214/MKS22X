import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> queue = new LinkedList<>();
    public Location next(){
	return queue.get(1);
    }
    public void add(Location n){
	queue.addFirst(n);
    }
    public boolean hasNext(){
	return queue.size() > 1;
    }
}
