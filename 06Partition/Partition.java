import java.util.*;
public class Partition{
  public static int part(int[] data){
    Random a = new Random();
    int in = a.nextInt(data.length);
    int i1 = data[in];
    int small = 1;
    int large = data.length - 1;
    int temp  = data[0];
    data[0] = i1;
    data[in] = temp;
    for(int i = 1;i < data.length && small <= large;i++){
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
    data[0] = temp;
    System.out.println(i1);
    System.out.println(Arrays.toString(data));
    return large;
  }
  public static void main(String[] args){
    int[] dat = {5,8,7,2,4,9,2,6};
    System.out.println(part(dat));
  }
}
