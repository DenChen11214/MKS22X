public class Sort{
  public static void radixsort(MyLinkedListImproved<Integer> data){
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data2 = new MyLinkedListImproved[10];
    for(int i = 0; i < data2.length; i++){
      data2[i] = new MyLinkedListImproved<Integer>();
    }
    int max = data.get(0);
    for(int i = 1; i < data.size();i++){
      int cur = data.get(i);
      if(max < cur){
        max = cur;
      }
    }
    max = (max + "").length();
    for(int k = 1; k <= max;k++){
      int len = data.size();
      for(int i = 0; i < len;i++){
        int num = data.get(i);
        if((num + "").length() >= k){
          char last = (num + "").charAt((num + "").length() - k);
          int n = last - '0';
          data2[n].add(num);
        }
        else{
          data2[0].add(num);
        }
      }
      MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<>();
      for(int i = 0; i < 10; i++){
        temp.extend(data2[i]);
      }
      data2[0].clear();
      data = temp;
    }
  }
  public static void main(String[] args){
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    l.add(0);
    l.add(100);
    l.add(132);
    l.add(5);
    l.add(44123);
    l.add(82);
    l.add(23);
    l.add(3);
    radixsort(l);
  }
}
