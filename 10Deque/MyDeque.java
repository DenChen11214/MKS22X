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
	return length;
    }
    public void addFirst(T value){
	resize();
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
	length++;
    }
    public void addLast(T value){
	resize();
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
	if((end + 1) % data.length == 0 && start != 0){
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
	length++;
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
	if(data.length - 1 == size()){
	    T[] newArray = (T[])new Comparable[size() * 2];
	    for(int i = 0;i < size(); i++){
		newArray[i] = data[i];
	    }
	    data = newArray;
	}
    }
    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

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
	//	for (String x : b){
	//  if (!(x.equals(a.getFirst()))){
	//  	System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
		//    }
		//if (!(x.equals(a.removeFirst()))){
		//System.out.println("There is an error at index " + index);
		//errorEvaluation += index + ", ";
		//hasError = true;
		//}
		//index++;
		//}


	if(hasError){
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
