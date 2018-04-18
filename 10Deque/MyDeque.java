public class MyDeque{
    private int start;
    private int end;
    private String[] data;
    public MyDeque(){
	data = new String[10];
	start = 0;
	end = 1;
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
	data[start] = value;
	if(start - 1 == -1 && end != data.length - 1){
	    start = data.length - 1;
	}
	else{
	    start--;
	}   
    }
    public void addLast(String value){
	if(value == null){
	    throw new NullPointerException();
	}
	data[end] = value;
	if(end + 1 % data.length == 0 && start != 0){
	    end = 0;
	}
	else{
	    end++;
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
	d.addLast("ab");
	System.out.println(d);
	d.addLast("231");
	System.out.println(d);
	d.addFirst("hi");
	System.out.println(d);
    }
}
