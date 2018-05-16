import java.util.*;
public class MyDeque<T>{
  private int start;
  private int end;
  private T[] data;
  private int length;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (T[])new Object[10];
    start = 0;
    end = 0;
    length = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
	    throw new IllegalArgumentException();
    }
    data = (T[])new Object[initialCapacity];
    start = 0;
    end = 0;
    length = 0;
  }
  public int size(){
    return length;
  }
  public void addFirst(T value){
    if(value == null){
	    throw new NullPointerException();
    }
    resize();
    if(data[start] == null){
      data[start] = value;
    }
    else{
      if(start == 0){
        data[data.length - 1] = value;
        start = data.length - 1;
      }
      else{
        data[start - 1] = value;
        start --;
      }
    }
    length++;
  }
  public void addLast(T value){
    if(value == null){
	    throw new NullPointerException();
    }
    resize();
    if(data[end] == null){
      data[end] = value;
    }
    else{
      if(end == data.length - 1){
        data[0] = value;
        end = 0;
      }
      else{
        data[end + 1] =value;
        end++;            
      }
    }
    length++;
  }
  public T removeFirst(){
    if(data[start] == null){
	    throw new NoSuchElementException();
    }
    T value = data[start];
    data[start] = null;
    if(start + 1 == data.length){
	    start = 0;
    }
    else{
	    start++;
    }
    length--;
    return value;
  }
  public T removeLast(){
    if(data[end] == null){
	    throw new NoSuchElementException();
    }
    T value = data[end];
    data[end] = null;
    if(end == 0){
      end = data.length - 1;
    }
    else{
      end --;
    }
    length --;
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
    String ans = "[";
    if(start < end){
	    for (int i = start; i <= end; i++){
        ans += data[i] + " , ";
	    }
    }
    else{
	    for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
        ans += data[i] + ", ";
	    }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }
  @SuppressWarnings("unchecked")
  private void resize(){
    if(data.length == size()){
	    T[] newArray = (T[])new Object[size() * 2];
	    for(int i = 0;i < size(); i++){
        newArray[i] = data[(start + i) % data.length];
	    }
	    data = newArray;
      end = size() - 1;
      start = 0;
    }
  }
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();
    MyDeque<String> a2 = new MyDeque<>();
    for(int i = 0; i < 20;i++){
      System.out.println(a2);
      if(i % 2 == 0){
        a2.addLast(i + "");
      }
      else{
        a2.addFirst(i +"");
      }
      System.out.println(a2);
    }
    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
	    int temp = i;
	    if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
	    }
	    else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
	    }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    


    if(true){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
    }
    else{
	    System.out.println("Your deque is bug-free!");
    }
  }
}
