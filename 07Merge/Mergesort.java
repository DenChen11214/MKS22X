import java.util.*;
public class Mergesort{
  public static void merge(int[] data, int low, int high){
    int middle = (low + high) / 2 + 1;
    int[] temp = new int[data.length];
    int low2 = low;
    int index = low;
    int mid = middle;
    while(low < middle && mid <= high){
      if(data[low] <= data[mid]){
        temp[index] = data[low];
        low++;
        index++;
      }
      if(data[low] > data[mid]){
        temp[index] = data[mid];
        mid++;
        index++;
      }
    }
    while(low < middle){
      temp[index] = data[low];
      index++;
      low++;
    }
    while(mid <= high){
      temp[index] = data[mid];
      index++;
      mid++;
    }
    for(int i  = low2; i <= high;i++){
      data[i] = temp[i];
    }
  }
  public static void main(String[] args){
    int[] data = {1,3,6,9,1,4,2,8};
    merge(data,4,7);
    System.out.println(Arrays.toString(data));

  }
}
