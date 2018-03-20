import java.util.*;
public class Merge{
    public static void mergesort(int[] data){
	int[] temp = new int [data.length];
	msort(data,temp,0,data.length - 1);
    }
    private static void msort(int[] data, int[] temp, int low, int high){
	for(int i  = low;i <= high;i++){
	    temp[i] = data[i];
	}
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
	int arr[] = {12, 15, 23, 4 , 6, 10, 35, 28}; //Even number of element
	mergesort(arr);
	System.out.println(Arrays.toString(arr));
	int arr1[]={}; //Empty list
	mergesort(arr1);
	System.out.println(Arrays.toString(arr1));
	int arr2[] = {4, 6, 10, 12, 15, 23, 28, 35}; //already sorted array
	mergesort(arr2);
	System.out.println(Arrays.toString(arr2));
	int arr3[] = {12, 15, 23, 4 , 6, 10, 35}; //odd length array
	mergesort(arr3);
	System.out.println(Arrays.toString(arr3));
	int arr4[] = {35, 28, 23, 15, 12, 10, 6, 4}; //descending sorted array input
	mergesort(arr4);
	System.out.println(Arrays.toString(arr4));
	int arr5[] = {12};//one element
	mergesort(arr5);
	System.out.println(Arrays.toString(arr5));
	int arr6[] = {12, 4}; // two elements
	mergesort(arr6);
	System.out.println(Arrays.toString(arr6));
	int arr7[] = {12, 15, 23, 4 , 6, 10, 35, 28, 100, 130, 500, 1000, 235, 554, 75, 345, 800, 222, 333, 888, 444, 111, 666, 777, 60};//large list of elements
	mergesort(arr7);
	System.out.println(Arrays.toString(arr7));
	int arr8[] = {12, 15, -23, -4 , 6, 10, -35, 28}; //negative elements
	mergesort(arr8);
	System.out.println(Arrays.toString(arr8));
	int arr9[] = {12, 12, 23, 4 , 6, 6, 10, -35, 28}; //duplicate elements
	mergesort(arr9);
	System.out.println(Arrays.toString(arr9));
	int arr10[] = {12, 12, 12, 12, 12}; //Same element
	mergesort(arr10);
	System.out.println(Arrays.toString(arr10));
	
    }
}
