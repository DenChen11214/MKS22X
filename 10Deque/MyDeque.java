public class MyDeque{
    private int start;
    private int end;
    private String[] data;
    public MyDeque(){
	data = new String[10];
	start = 0;
	end = 0;
    }
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
	start = 0;
	end = 0;
    }
    public int size(){
	return data.length;
    }
    public void addFirst(String value){
	if(value == null){
	    throw new NullPointerException();
	}
	if(start - 1 == -1 && end != data.length - 1){
	    start = data.length - 1;
	    data[start] = value;
	}
	else{
	    data[start - 1] = value;
	    start--;
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
	MyDeque d= new MyDeque();
	d.addFirst("123");
	System.out.println(d);
    }
}
