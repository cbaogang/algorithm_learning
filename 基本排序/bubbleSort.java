package 基本排序;

import java.util.Arrays;

class bubbleSort {

	public static void main(String[]args) {
		int[] arr= {31, 41, 59, 26, 41, 58};
		
		bubbleSort.bubbleSort(arr);
		System.out.print(Arrays.toString(arr));
		
	
	}
	
	

	static void bubbleSort(int []arr) {
		
		if(arr==null&&arr.length<2) {
			return;
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
	}
}
