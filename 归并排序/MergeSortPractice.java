package 归并排序;

import java.util.Arrays;

public class MergeSortPractice {

	public static void main(String[]args) {
		
	int[]arr= {2,1,5,4,3,6,8,7,10,9};	
	mergeSort(arr);
	System.out.print(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[]arr) {
		if(arr==null ||arr.length<2) {
			return;
		}
		
		sort(arr,0,arr.length-1);
	}
	
	public static void sort(int[]arr,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			sort(arr,left,mid);
			sort(arr,mid+1,right);
			merge(arr,left,mid,right);
			
		}
		
	}
	
	public static void merge(int[]arr, int left, int mid,int right) {
		int[]help=new int[right-left+1];
		int leftIndex=left;
		int rightIndex=mid+1;
		int helpIndex=0;
		
		// 注意每次赋值后，要移动Index
		while(leftIndex<=mid&&rightIndex<=right){
			help[helpIndex++]=arr[leftIndex]<=arr[rightIndex]?arr[leftIndex++]:arr[rightIndex++];
		}
		
		while(leftIndex<=mid) {
			help[helpIndex++]=arr[leftIndex++];
		}
		
		while(rightIndex<=right) {
			help[helpIndex++]=arr[rightIndex++];
		}
		
		// 易错点：长度应该为help的长度，而不是arr
		
		for(int i=0;i<help.length;i++) {
			arr[i+left]=help[i];
		}
		
	}
	
	
	
}
