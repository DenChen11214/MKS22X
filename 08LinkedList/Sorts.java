public class Sorts{
  public static void radixsort(MyLinkedListImproved<Integer> data){
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data2 = new MyLinkedListImproved[10];
    for(int i = 0; i < data2.length; i++){
      data2[i] = new MyLinkedListImproved<Integer>();
    }
    int max = data.get(0);
    for(int i = 1; i < data.size();i++){
      int cur = data.get(i);
      if(Math.abs(max) < Math.abs(cur)){
        max = cur;
      }
    }
    max = (max + "").length();
    for(int k = 1; k <= max;k++){
      int len = data.size();
      for(int i = 0; i < len;i++){
        int num = data.get(i);
        if(num < 0 && (num + "").substring(1,(num+ "").length()).length() >= k){
          char last = (num + "").charAt((num + "").length() - k);
          int n = last - '0';
          data2[n].add(num);
        }
        else if(num > 0 && (num + "").length() >= k){
          char last = (num + "").charAt((num + "").length() - k);
          int n = last - '0';
          data2[n].add(num);
        }
        else{
          data2[0].add(num);
        }
      }
      for(int i = 0; i < data2.length;i++){
        System.out.println(data2[i]);
      }
      int index = 0;
      for(int i = 9; i >=0; i--){
        if(data2[i].size() > 0){
          index = i;
        }
      }
      data.clear();
      for(int i = 0; i < 10; i++){
        data.extend(data2[i]);
      }
      data2[index].clear();
    }
    for(Integer n : data){
      if(n < 0){
        data.remove(n);
        data.add(0,n);
      }
    }
    System.out.println(data);
  }
  public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
  }
  public static void main(String[] args){
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    l.add(-1);
    l.add(-2311);
    l.add(-132);
    l.add(-11);
    l.add(-2);
    l.add(-10);
    l.add(1);
    l.add(1231);
    l.add(12);
    l.add(11);
    l.add(6);
    l.add(3);
    l.add(132);
    Sorts.radixsort(l);
    System.out.println(l);
  }
}
