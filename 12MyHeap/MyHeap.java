public class MyHeap{//<String extends Comparable<String>>{
  private int length;
  private boolean isMax;
  private String[] data;
  //@SuppressWarnings("unchecked")
  public MyHeap(){
    isMax = true;
    length = 0;
    data =  new String[10];
    //data = (String[])new Object[10];
  }
  // @SuppressWarnings("unchecked")
  public MyHeap(boolean maxmin){
    isMax = maxmin;
    length = 0;
    data = new String[10];
    //data = (String[])new Object[10];
  }
  public int size(){
    return length;
  }
  public String getParent(int i){
    return data[(i - 1)/2];
  }
  public boolean hasParent(int i){
    if(i == 0){
      return false;
    }
    return ((i - 1) / 2.0) >= 0;
  }
  public String getChildL(int i){
    return data[i * 2 + 1];
  }
  public String getChildR(int i){
    return data[i * 2 + 2];
  }
  public boolean hasChildL(int i){
    return (i * 2 + 1) < size();
  }
  public boolean hasChildR(int i){
    return (i * 2 + 2) < size();
  }
  public String peek(){
    return data[0];
  }
  public void pushup(int i){
    if(compares(isMax,data[i],getParent(i))){
      swap(data, i,(i - 1) / 2);
    }
  }
  public void add(String s){
    resize();
    int index = size();
    data[index] = s;
    length++;
    while(hasParent(index)){
      while(compares(isMax,data[index],getParent(index))){
        pushup(index);
        index = (index - 1) / 2;
      }
      index = (index - 1) / 2;
    }
  }
  private void swap(String[] ary,int i, int n){
    String temp = ary[i];
    ary[i] = ary[n];
    ary[n] = temp;
  }
  public boolean compares(boolean maxmin, String child, String parent){
    if(maxmin){
      return child.compareTo(parent) >= 1;
    }
    else{
      return child.compareTo(parent) <= -1;
    }
  }
  private void resize(){
    if(data.length - 1 == size()){
      String[] newArray = new String[length * 2];
      for(int i = 0;i < size(); i++){
        newArray[i] = data[i];
      }
      data = newArray;
    }
  }
  public String toString(){
    String s = "[";
    for(int i = 0;i < size() - 1; i++){
      s += data[i] + ",";
    }
    return s + data[size() - 1] + "]";
  }
  public static void main(String[] args){
    MyHeap heap = new MyHeap(true);
    heap.add("f");
    System.out.println(heap);
    heap.add("d");
    System.out.println(heap);
    heap.add("c");
    System.out.println(heap);
    heap.add("b");
    System.out.println(heap);
  }
}
