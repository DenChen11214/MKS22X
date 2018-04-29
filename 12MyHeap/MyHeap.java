public class MyHeap<String extends Comparable<String>>{
  private int length;
  private boolean isMax;
  private String[] data = new String[0];
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
  public void add(String s){
    resize();
  }
  public String getParent(int i){
    return data[(i - 1)/2];
  }
  public boolean hasParent(int i){
    return ((i - 1) / 2) > 0;
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
  public boolean hasChildL(int i){
    return (i * 2 + 2) < size();
  }
  public String peek(){
    return data.get(0);
  }
  private void resize(){
    if(data.length - 1 == size()){
      String[] newArray = new String[size * 2   ];
      for(int i = 0;i < size(); i++){
        newArray[i] = data[i];
      }
      data = newArray;
    }
  }

}
