package 快速排序;

import java.util.Arrays;

/**
 * 75. 颜色分类(荷兰国旗问题)
 * https://leetcode.cn/problems/sort-colors/description/
 * @param args
 */

public class SortColor {

	public static void main(String[]args) {
		int[]nums = {2,0,2,1,1,0};
		sortColor(nums);
		System.out.print(Arrays.toString(nums));
		
	}
	
	public static void sortColor(int[]arr) {
		
		if(arr==null||arr.length<2) {
			return ;
		}
		
		int index=0;
		int l=-1;
		// 易错点，r的长度不是arr.length-1
		int r=arr.length;
		
		// 易错点：index<r，小于右边的边界， 不是小于arr.length
		
		while(index<=r) {
			if(arr[index]<1) {
				swap(arr,++l,index++);
			}else if(arr[index]==1) {
				index++;
			}else {
				swap(arr,--r,index);
			}
		}
		
	}
	
	public static void swap(int[]arr,int l,int r) {
		if(l==r) {
			return;
		}
		arr[l]=arr[l]^arr[r];
		arr[r]=arr[l]^arr[r];
		arr[l]=arr[l]^arr[r];
		
	}
	
	
	
	
}
