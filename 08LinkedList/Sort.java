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
    System.out.println(max);
    for(int k = 1; k <= max;k++){
      for(int i = 0; i < data.size();i++){
        int num = data.get(i);
        if((num + "").length() >= k){
          char last = (num + "").charAt((num + "").length() - k);
          int n = last - '0';
          data2[n].add(num);
        }
      }
      for(int i =0;i < data2.length;i++){
        System.out.println(data2[i]);
      }
      MyLinkedListImproved<Integer> temp = data2[0];
      data2[0].clear();
      for(int i = 1; i < 10; i++){
        temp.extend(data2[i]);
        data2[i].clear();
      }
      data = temp;
    }
  }
  public static void main(String[] args){
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    l.add(0);
    l.add(0);
    l.add(1);
    l.add(5);
    l.add(4);
    l.add(82);
    l.add(23);
    l.add(3);
    radixsort(l);
  }
}
