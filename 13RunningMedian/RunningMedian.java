import java.util.*;
public class RunningMedian{
    private int length;
    private MyHeap min;
    private MyHeap max;
    public RunningMedian(){
	length = 0;
	min = new MyHeap(false);
	max = new MyHeap();
    }
    public void add(double value){
	
    }
    public double getMedian(){
	if(min.size() == max.size()){
	    return (min.peek() + max.peek()) / 2;
	}
	if(max.size() > min.size()){
	    return max.peek();
	}
	else{
	    return min.peek();
	}
    }
    public int size(){
	return length;
    }
}
