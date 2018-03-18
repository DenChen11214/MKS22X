import java.util.*;
public class Quick{
  public static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  public static int[] partition(int[] data,int start, int end){
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
    int index = small;
    swap(data,start,in);
    int[] range = new int[2];
    while(index <= large){
	    if(data[index] == i1){
        index++;
	    }
	    else if(data[index] > i1){
        swap(data,index,large);
        large--;
	    }
	    else{
        swap(data,index,small);
        small++;
        index++;
	    }
    }
    swap(data,small - 1, start);
    range[0] = small - 1;
    range[1] = large;
    return range;
  }
  public static int quickselect(int[] data, int k){
    int[] range = partition(data,0,data.length - 1);
    int v1 = range[0];
    int v2 = range[1];
    int s = 0;
    int e = data.length - 1;
    while(v1 >= k || v2 + 2 <= k){
	    if(v1 >= k){
        e = v1 - 1;
        range = partition(data,s,e);
        v1 = range[0];
        v2 = range[1];
	    }
	    else if(v2 + 2 <= k){
        s = v2 + 1;
        range = partition(data,s,e);
        v1 = range[0];
        v2 = range[1];
	    }
    }
    return data[k - 1];
  }
  public static void quicksort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }
  public static void quickSortHelp(int[] ary, int start, int end){
    if(start != end + 1){
      int range[] = partition(ary,start,end);
	    int v1 = range[0];
      int v2 = range[1];
	    quickSortHelp(ary,start,v1 - 1);
	    quickSortHelp(ary,v2 + 1, end);
    }
  }
  public static void main(String[]args){
    int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
    System.out.println(quickselect(ary,6) + " <- Should be 0");
    System.out.println(Arrays.toString(ary));
    int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
    System.out.println(quickselect(ary1,20) + " <- Should be 7");
    System.out.println(quickselect(ary1,14) + " <- Should be 5");
    System.out.println(Arrays.toString(ary1));
    System.out.println(quickselect(ary1,1) + " <- Should be -3");
    System.out.println(quickselect(ary1,ary1.length) + " <- Should be 9");
    int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
    quicksort(ary2);
    System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
    System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");
  }
}
