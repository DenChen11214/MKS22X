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
	int index = small;
	int temp  = data[start];
	data[start] = i1;
	data[in] = temp;
	while(index <= large){
	    if(data[index] == i1){
		index++;
	    }
	    else if(data[index] > i1){
		temp = data[index];
		data[index] = data[large];
		data[large] = temp;
		large--;
	    }
	    else{
		temp = data[index];
		data[index] = data[small];
		data[small] = temp;
		small++;
		index++;
	    }
	}
	temp = data[small - 1];
	data[small - 1] = i1;
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
	int[] dat = {1,2,0,0,1,2,3,4,5,6,1,2,5,2,63,41,0,0,2,3};
	System.out.println(part(dat,0,19));
	System.out.println(Arrays.toString(dat));
    }
}
