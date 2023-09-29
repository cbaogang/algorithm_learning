package 快速排序;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[]args) {
		int[]arr= {2,1,4,3,6,5,9,8,7,0,4,3};
		quickSort(arr);
		System.out.print(Arrays.toString(arr));
		
	}
	
	public static void quickSort(int[]arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		
		partition(arr,0,arr.length-1);
		
	}
	

	
	public static void partition(int[]arr,int L,int R) {
		
		if(L>=R) {
			return;
		}
		
			int lessArea=L-1;
			int moreArea=R;
			int index=L;

			swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
	
			// 易错点：index<moreArea,不是R
			while(index<moreArea) {
				if(arr[index]>arr[R]) {
					swap(arr,index,--moreArea);
				}else if(arr[index]<arr[R]) {
					swap(arr,index++,++lessArea);
				}else {
					index++;
				}
			}
			
			swap(arr,moreArea,R);
			partition(arr,L,lessArea);
			partition(arr,moreArea+1,R);
			
		
	}
	
	
	private static void swap(int[]arr, int L,int R) {
	
		int tmp = arr[L];
		arr[L] = arr[R];
		arr[R] = tmp;
	}
	
}
