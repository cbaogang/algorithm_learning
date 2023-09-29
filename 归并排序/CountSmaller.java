package 归并排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
	
	
	int[] index;
	int[] count;
	List<Integer>ans=new ArrayList<>();

	public static void main(String[]args) {
	
		int []arr={5,2,6,1};
		
		CountSmaller cm=new CountSmaller(); 
		List<Integer>ans=cm.countSmaller(arr);
		
		
		System.out.println(ans);
		
	}
	
	public List<Integer> countSmaller(int[]nums) {
		
		
		index=new int[nums.length];
		count=new int[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			index[i]=i;
		}
		
		mergeSort(nums,0,nums.length-1);

		for(int num:count) {
			ans.add(num);
		}
		
		return ans;
		
	}
	
	
	private void mergeSort(int[]arr,int left,int right){
		if(left>=right) {
			return;
		}
		
		int mid=left+((right-left)>>1);
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		merge(arr,left,mid,right);
	}
	
	private void merge(int[]arr,int left,int mid, int right) {
		

		
		int[]temp=new int[right-left+1];
		int[]tempIndex=new int[right-left+1];
		
		int cur=temp.length-1;
		int leftIndex=mid;
		int rightIndex=right;
		
		
		while(leftIndex>=left&&rightIndex>mid) {
			if(arr[leftIndex]>arr[rightIndex]) {
				count[index[leftIndex]]+=rightIndex-mid;
				tempIndex[cur]=index[leftIndex];
				temp[cur]=arr[leftIndex];
				leftIndex--;
			}else {
				tempIndex[cur]=index[rightIndex];
				temp[cur]=arr[rightIndex];
				rightIndex--;
			}
			
			cur--;
		}
		
		while(leftIndex>=left) {
			tempIndex[cur]=index[leftIndex];
			temp[cur]=arr[leftIndex];
			leftIndex--;
			cur--;
		}
		
		while(rightIndex>mid) {
			temp[cur]=arr[rightIndex];
			tempIndex[cur]=index[rightIndex];
			rightIndex--;
			cur--;
		}
		
		for(int i=0;i<temp.length;i++) {
			arr[i+left]=temp[i];
			index[i+left]=tempIndex[i];
		}
		
		
		
	}
}
