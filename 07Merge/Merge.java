import java.util.*;
public class Merge{
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	for(int i = 0; i < data.length ; i ++){
	    temp[i] = data[i];
	}
	msort(data,temp,0,data.length - 1);
    }
    private static void msort(int[] data, int[] temp, int low, int high){
	if(low >= high){
	    return;
	}
	int mid = (low + high) / 2;
	msort(temp,data,low, mid);
	msort(temp,data,mid + 1, high);
	merge(data,temp,low, high);
    }
    public static void merge(int[] data, int[] temp, int low, int high){
	int middle = (low + high) / 2 + 1;
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
        
	int arr11[] = new int[10000000];
	mergesort(arr11);
	
    }
}
