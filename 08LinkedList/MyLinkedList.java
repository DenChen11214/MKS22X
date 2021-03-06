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
    Node n = last;
    for(int i = size() - 1; i > index;i--){
	    n = n.getPrev();
    }
    return n;
  }
  public void clear(){
    first = null;
    last = null;
    length = 0;
  }
  public boolean add(Integer value){
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
	    last.setPrev(first);
	    length++;
    }
    else{
	    last.setNext(n);
	    n.setPrev(last);
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
    for(int i = 0;i < size();i++){
	    s += getNode(i).getValue() + ",";
    }
    if(s.length() > 1){
	    return s.substring(0,s.length() - 1) + "]";
    }
    else{
	    return "[]";
    }
  }

  public Integer set(int index, Integer newValue){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    int old = getNode(index).getValue();
    getNode(index).setValue(newValue);
    return old;
  }
  public Integer get(int index){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }
  public int indexOf(Integer value){
    Node n = first;
    for(int i = 0; i < size(); i++){
	    if(n.getValue() == value){
        return i;
	    }
	    n = n.getNext();
    }
    return -1;
  }
  public void add(int index, Integer value){
    if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
    }
    Node n = new Node(value);
    if(size() == 0){
	    add(value);
    }
    else if(index == 0){
	    n.setNext(first);
	    first.setPrev(n);
	    first = n;
	    length++;
    }
    else if(index == size()){
	    add(value);
    }
    else{
	    Node o = getNode(index);
	    getNode(index - 1).setNext(n);
	    n.setPrev(getNode(index - 1));
	    n.setNext(o);
	    o.setPrev(n);
	    length++;
    }
  }
  public boolean remove(Integer value){
    int index = indexOf(value);
    remove(index);
    return true;
  }
  public Integer remove(int index){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    int removed = getNode(index).getValue();
    if(size() == 0){
	    first = null;
    }
    else if(index == 0){
	    first = first.getNext();
	    first.setPrev(null);
	    length--;
    }
    else if(index == size() - 1){
	    last = last.getPrev();
	    last.setNext(null);
	    length--;
    }
    else{
	    
	    getNode(index - 1).setNext(getNode(index + 1));
	    getNode(index + 1).setPrev(getNode(index - 1));
	    length--;
    }
    return removed;
  }
  public static void main(String[] args){
    MyLinkedList l = new MyLinkedList();
    l.add(0,8);
    System.out.println(l);
    l.add(0,12);
    System.out.println(l);
    l.add(1,9);
    System.out.println(l);
  }

}
