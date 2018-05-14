public class HeapSort{
  public static void Heapsort(Integer[] data){
    MyHeap<Integer> heap = new MyHeap<>();
    for(int i = 0;i< data.length;i++){
      heap.add(data[i]);
    }
    for(int i = data.length - 1;i >= 0;i--){
      data[i] = heap.remove();
    }
  }
  public static void main(String[] args){
    Integer[] data = {0,2,4,1,134,12,32,12,44,32,1};
    Heapsort(data);
    for(int i = 0; i < data.length;i++){
      System.out.println(data[i]);
    }
  }
}
