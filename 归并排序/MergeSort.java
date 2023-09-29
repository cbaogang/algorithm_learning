package 归并排序;

import java.util.Arrays;

public class MergeSort {

	
	public static void main(String[]args) {
		 int[] arr = {12, 11, 13, 5, 6, 7};
		 System.out.println("Original Array:"+Arrays.toString(arr));
	     mergeSort(arr);
	     System.out.println("\nSorted Array:"+Arrays.toString(arr));
	}
	
	public static void mergeSort(int[]arr) {
		if(arr==null ||arr.length<2) {
			return;
		}
		sort(arr,0,arr.length-1);
	}
	
	public static void sort(int[]arr,int left, int right) {
		
		if(left<right) {
			int mid=(left+right)/2;
			sort(arr,left,mid);
			// mid 不要忘记加 1
			sort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	
	public static void merge(int[]arr,int left,int mid, int right) {
		int [] sorted = new int [right-left+1];
		int leftIndex=left;
		// 不要把rightIndex设置错误成right
		int rightIndex=mid+1;
		int sortedIndex=0;
		
		while(leftIndex<=mid&&rightIndex<=right) {	
			sorted[sortedIndex++]= arr[leftIndex]<=arr[rightIndex]?arr[leftIndex++]:arr[rightIndex++];
		}
		
		while(leftIndex<=mid) {
			sorted[sortedIndex++]=arr[leftIndex++];
		}
		
		while(rightIndex<=right) {
			sorted[sortedIndex++]=arr[rightIndex++];
		}
		
		for (int i = 0; i < sorted.length; i++) {
			arr[left + i] = sorted[i];
		}
	}
	
	
	
}
