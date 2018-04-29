public class MyHeap{
  private int length;
  private boolean isMax;
  public MyHeap(){
    isMax = true;
    length = 0;
  }
  public MyHeap(boolean maxmin){
    isMax = maxmin;
    length = 0;
  }
  public int size(){
    return length;
  }
}
