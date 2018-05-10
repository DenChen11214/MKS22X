import java.util.*;
public class FrontierPQ implements Frontier{
    private MyHeap<Location> heap = new MyHeap<>(false);
    public FrontierPQ(){}
    public Location next(){
	return heap.remove();
    }
    public void add(Location n){
	heap.add(n);
    }
    public boolean hasNext(){
	return heap.size() >= 1;
    }
}
