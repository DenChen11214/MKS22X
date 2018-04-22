import java.util.*;
public class MyDeque<T>{
  private int start;
  private int end;
  private T[] data;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (T[])new Object[10];
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
	    throw new IllegalArgumentException();
    }
    data = (T[])new Object[initialCapacity];
    start = 0;
    end = 0;
  }
  public int size(){
    return data.length;
  }
  public void addFirst(T value){
    if(start - 1 == end || (end == data.length - 1 && start == 0)){
	    return;
    }
    if(value == null){
	    throw new NullPointerException();
    }
    boolean equal = false;
    if(end == start && data[start] == null){
      equal = true;
    }
    if(start - 1 == -1 && end != data.length - 1){
	    data[data.length - 1] = value;
	    start = data.length - 1;
    }
    else{
	    data[start - 1] = value;
	    start --;
    }
    if(equal){
        end = start;
    }
    System.out.println(start);
    System.out.println(end);
  }
  public void addLast(T value){
    if(end + 1 == start){
	    return;
    }
    if(value == null){
	    throw new NullPointerException();
    }
    boolean equal = false;
    if(end == start && data[end] == null){
      equal = true;
    }
    if((end + 1) % size() == 0 && start != 0){
	    data[0] = value;
	    end = 0;
    }
    else{
	    data[end + 1] = value;
	    end++;	    
    }
    if(equal){
        start = end;
    }
    System.out.println(start);
    System.out.println(end);
  }
  public T removeFirst(){
    if(data[start] == null){
      throw new NoSuchElementException();
    }
    T value = data[start];
    data[start] = null;
    if(start == end){
      return value;
    }
    if(start + 1 == data.length){
      start = 0;
    }
    else{
      start++;
    }
    System.out.println(start);
    System.out.println(end);
    return value;
  }
  public T removeLast(){
    if(data[end] == null){
      throw new NoSuchElementException();
    }
    T value = data[end];
    data[end] = null;
    if(start == end){
      return value;
    }
    if(end - 1 == -1){
      end = data.length - 1;
    }
    else{
      end--;
    }
    System.out.println(start);
    System.out.println(end);
    return value;
  }
  public T getFirst(){
    if(data[start] == null){
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public T getLast(){
    if(data[end] == null){
      throw new NoSuchElementException();
    }
    return data[end];
  }
  public String toString(){
    String s = "[";
    for(int i = 0;i < data.length;i++){
	    s += data[i] + " ";
    }
    return s + "]";
  }
  public static void main(String[] args){
    MyDeque<String> d = new MyDeque<>();
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.addLast("hi");
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.removeLast();
    System.out.println(d);
    d.removeLast();
    System.out.println(d);
    d.removeLast();
    System.out.println(d);
    d.removeLast();
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.removeFirst();
    System.out.println(d);
    d.addFirst("asdasd");
    System.out.println(d);
    d.addFirst("asdasdas");
    System.out.println(d);
    d.addFirst("opop");
    System.out.println(d);
    System.out.println(d.getFirst());
    System.out.println(d.getLast());
  }
}
