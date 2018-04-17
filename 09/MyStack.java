import java.util.*;
public class MyStack{
  private LinkedList<Integer> data;
  public MyStack(){
    data = new LinkedList<Integer>();
  }
  public void push(int i){
    data.add(i);
  }
  public int pop(){
    int last = data.getLast();
    data.removeLast();
    return last;
  }
  public String toString(){
    String s = "[";
    for(int i = 0; i< data.size();i++){
      s += data.get(i) + " ";
    }
    return s + "]";
  }
  public static void main(String[] args){
    MyStack m = new MyStack();
    m.push(1);
    m.push(10);
    m.pop();
    System.out.println(m);
  }
}
