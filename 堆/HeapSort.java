package 堆;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[]args) {
		int [] arr= {2,7,3,8,6,5,1,9};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	
	
	public static void heapSort(int []arr) {
		
		if(arr==null|arr.length<2) {
			return;
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			heapify(arr,i,arr.length);	
		}
		
		int heapSize=arr.length;
		swap(arr,0,--heapSize);
		
		
		while(heapSize>0) {
			heapify(arr,0,heapSize);
			swap(arr,0,--heapSize);
		}
		
	}

	
	public static void heapify(int[]arr,int index,int heapSize) {
		
		int left=index*2+1;
		
		while(left<heapSize) {
			
			int largest = left+1<heapSize && arr[left+1]>arr[left]?left+1:left;
			largest = arr[largest]>arr[index]?largest:index;
			if(largest==index) {
				break;
			}
			
			swap(arr,index,largest);
			index=largest;
			left=index*2+1;
		}
	}
	
	public static void swap(int[]arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
