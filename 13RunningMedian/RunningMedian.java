import java.util.*;
public class RunningMedian{
  private int length;
  private MyHeap<Double> min;
  private MyHeap<Double> max;
  public RunningMedian(){
    length = 0;
    min = new MyHeap<Double>(false);
    max = new MyHeap<Double>();
  }
  public void add(Double value){
    if(length == 0){
	    min.add(value);
	    length++;
	    return;
    }
    if(value < getMedian()){
	    max.add(value);
	    length++;
    }
    else if(value >= getMedian()){
	    min.add(value);
	    length++;
    }
    if(max.size() - min.size() == 2){
	    min.add(max.remove());
    }
    if(min.size() - max.size() == 2){
	    max.add(min.remove());
    }
  }
  public Double getMedian(){
    if(size() == 0){
	    throw new NoSuchElementException();
    }
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
  public static void main(String[] args){
    RunningMedian med = new RunningMedian();
    med.add(2.0);
    System.out.println(med.getMedian());
    med.add(1.0);
    System.out.println(med.getMedian());
    med.add(6.0);
    System.out.println(med.getMedian());
    med.add(4.0);
    System.out.println(med.getMedian());
    med.add(2.0);
    System.out.println(med.getMedian());
    med.add(9.0);
    System.out.println(med.getMedian());
    med.add(109.0);
    System.out.println(med.getMedian());
    med.add(29.0);
    System.out.println(med.getMedian());
    med.add(0.0);
    System.out.println(med.getMedian());
	
  }
    
}
