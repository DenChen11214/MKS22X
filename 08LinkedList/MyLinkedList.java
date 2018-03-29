public class MyLinkedList{
    private Node first,last;
    private int length;
    public MyLinkedList(){
    }
    private class Node{
	private Node next,prev;
	private int data;
	public Node(int data){
	    this.data = data;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public int getValue(){
	    return data;
	}
	public void setNext(Node n){
	    next = n;
	}
	public void setPrev(Node p){
	    prev = p;
	}
	public void setValue(int value){
	    data = value;
	}
	public String toString(){
	    return "[" + data + "]";
	}
    }
    private Node getNode(int index){
	Node n = first;
	for(int i = 0; i < index;i++){
	    n = n.getNext();
	}
	return n;
    }
    public boolean add(int value){
	Node n = new Node(value);
	if(length == 0){
	    first = n;
	    last = n;
	    length++;
	}
	else if(length == 1){
	    last.setNext(n);
	    last = last.getNext();
	    first.setNext(last);
	    length++;
	}
	else{
	    last.setNext(n);
	    last = last.getNext();
	    length++;

	}
	return true;
    }

    public int size(){
	return length;
    }
    public String toString(){
	String s = "[";
	for(int i = 0;i < length;i++){
	    s += getNode(i).getValue() + ",";
	}
	return s.substring(0,s.length() - 1) + "]";
    }
    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	l.add(1);
	System.out.println(l);
	l.add(2);
	System.out.println(l);
	l.add(4);
	System.out.println(l);
	l.add(4);
	System.out.println(l);
	l.add(4);
	System.out.println(l);
    }
}
