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
  public void clear(){
    first = null;
    last = null;
    length = 0;
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
  public Integer set(int index, int newValue){
    if(index <0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    int old = getNode(index).getValue();
    getNode(index).setValue(newValue);
    return old;
  }
  public Integer get(int index){
    if(index <0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }
  public int indexOf(int value){
    for(int i = 0; i < size(); i++){
	    if(getNode(i).getValue() == value){
        return i;
	    }
    }
    return -1;
  }
  public void add(int index, int value){
    if(index <0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    Node n = new Node(value);
    if(index == 0){
	    n.setNext(first);
	    first = n;
	    length++;
    }
    else if(index == size()){
	    add(value);
    }
    else{
	    Node o = getNode(index);
	    getNode(index - 1).setNext(n);
	    n.setNext(o);
	    length++;
    }
  }
  public boolean remove(Integer value){
    int index = indexOf(value);
    remove(index);
    return true;
  }
  public Integer remove(int index){
    if(index <0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    int removed = getNode(index).getValue();
    if(index == 0){
	    first = first.getNext();
	    length--;
    }
    else if(index == size() - 1){
	    last = getNode(index - 1);
	    getNode(index - 2).setNext(last);
	    length--;
    }
    else{
	    getNode(index - 1).setNext(getNode(index + 1));
	    length--;
    }
    return removed;
  }
  public static void main(String[] args){
    MyLinkedList l = new MyLinkedList();
    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3,8);
    System.out.println(l);
    l.add(0,12);
    System.out.println(l);
    l.add(1,9);
    System.out.println(l);
    l.remove(new Integer(2));
    System.out.println(l);
    System.out.println(l.get(1));

  }

}
