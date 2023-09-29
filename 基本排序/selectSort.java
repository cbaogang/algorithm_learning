package 基本排序;

import java.util.Arrays;

public class selectSort {

	public static void main(String[]args) {
		int[] nums= {2,3,4,1,9,8};
		
		selectSort.selectSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	static void selectSort(int[]nums){
		if(nums==null || nums.length<1) {
			return;
		}
		for(int i=0;i<nums.length;i++) {
			int minIndex=i;
			
			for(int j=i+1;j<nums.length;j++) {
				minIndex= nums[j]<nums[i]?j:minIndex;
			}
			swap(nums,i,minIndex);
		}

	}
	
	static void swap(int []nums,int i, int minIndex) {
		int temp = nums[i];
		nums[i]=nums[minIndex];
		nums[minIndex]=temp;
	}
}
