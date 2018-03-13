import java.util.*;
public class Quick{
  public static int part(int[] data,int start, int end){
    Random a = new Random();
    int in = a.nextInt(data.length);
    int i1 = data[in];
    int small = start + 1;
    int large = end;
    int temp  = data[start];
    data[0] = i1;
    data[in] = temp;
    for(int i = start + 1;i <= end && small <= large;i++){
        if(data[i] <= i1){
          temp = data[i];
          data[i] = data[small];
          data[small] = temp;
          small++;
        }
        if(data[i] > i1){
          temp = data[i];
          data[i] = data[large];
          data[large] = temp;
          large--;
          i--;
        }
    }
    temp = data[large];
    data[large] = i1;
    data[start] = temp;
    return large;
  }
  public static int quickSelect(int[] data, int k){
    int v1 = part(data,0,data.length - 1);
    int s = 0;
    int e = data.length - 1;
    while(v1 + 1 != k){
      if(v1 + 1 > k){
        e = v1 - 1;
        v1 = part(data,s,e);
      }
      if(v1 + 1 < k){
        s = v1 + 1;
        v1 = part(data,s,e);
      }
    }
    return data[v1];
  }
  public static void main(String[] args){
    int[] dat = {5,8,7,2,4,9,2,6};
    System.out.println(quickSelect(dat,1));
    System.out.println(quickSelect(dat,2));
    System.out.println(quickSelect(dat,3));
    System.out.println(quickSelect(dat,4));
    System.out.println(quickSelect(dat,5));
    System.out.println(quickSelect(dat,6));
    System.out.println(quickSelect(dat,7));
    System.out.println(quickSelect(dat,8));
  }
}
