import java.util.*;
public class MyStack{
  private LinkedList<Double> data;
  public MyStack(){
    data = new LinkedList<Double>();
  }
  public void push(double i){
    data.add(i);
  }
  public double pop(){
    double last = data.getLast();
    data.removeLast();
    return last;
  }
  public String toString(){
    String s = "[ ";
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
