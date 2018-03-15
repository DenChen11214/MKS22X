import java.util.*;
public class Quick{
  public static int part(int[] data,int start, int end){
    Random a = new Random();
    int in = 0;
    if(end - start == 0){
      in = start;
    }
    else{
      in = a.nextInt(end - start) + start;
    }
    int i1 = data[in];
    int small = start + 1;
    int large = end;
    int temp  = data[start];
    data[start] = i1;
    data[in] = temp;
    while(small <= large){
      if(data[small] < i1){
        small++;
      }
      else{
        temp = data[small];
        data[small] = data[large];
        data[large] = temp;
        large--;
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
  public static void quickSort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }
  public static void quickSortHelp(int[] ary, int start, int end){
    if(start != end + 1){
      int v1 =  part(ary, start, end);
      quickSortHelp(ary,start,v1 - 1);
      quickSortHelp(ary,v1 + 1, end);
    }
  }
  public static void main(String[] args){
    int[] dat = {2,1,4,61,75,4234,3753,32,11,1,1,1,1};
    quickSort(dat);
    System.out.println(Arrays.toString(dat));
  }
}
