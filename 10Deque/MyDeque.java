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
	if(start - 1 == -1 && end != data.length - 1){
	    data[data.length - 1] = value;
	    start = data.length - 1;
	    if(end == 0){
		end = start;
	    }
	}
	else{
	    data[start - 1] = value;
	    start --;
	}
    }
    public void addLast(T value){
	if(end + 1 == start){
	    return;
	}
	if(value == null){
	    throw new NullPointerException();
	}
	if((end + 1) % size() == 0 && start != 0){
	    data[0] = value;
	    end = 0;
	}
	else{
	    data[end + 1] = value;
	    end++;
	    
	}
	if(start == 0 && end == 1){
	    start = end;
	}
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
	d.addLast("hi");
	System.out.println(d);
	
    }
}
