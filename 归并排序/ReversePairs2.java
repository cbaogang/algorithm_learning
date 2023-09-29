package 归并排序;

import java.util.Arrays;

public class ReversePairs2 {

	public static void main(String[]args) {
		int[]arr= {9, 7, 5, 4, 6};
		 ReversePairs2 solution = new ReversePairs2();
		
		int ans=solution.reversePairs(arr);
		System.out.println(ans);
		
	}
	

	

	    public int reversePairs(int[] record) {
	        if(record==null||record.length<2){
	            return 0;
	        }
	        int ans=0;
	        return ans=reverse(record,0,record.length-1);
	    }

	    public int reverse(int[]arr,int left,int right){
	        if(left>=right){
	            return 0;
	        }

	        int mid=left+((right-left)>>1);

	        return reverse(arr,left,mid)+reverse(arr,mid+1,right)+merge(arr,left,mid,right);
	    }


	    public int merge(int[]arr,int left,int mid,int right){
	        int[] temp=new int[right-left+1];
	        int leftIndex=left;
	        int rightIndex=mid+1;
	        int index=0;
	        int ans=0;

	        while(leftIndex<=mid&&rightIndex<=right){
	            if(arr[leftIndex]>arr[rightIndex]){
	                ans+=(mid-leftIndex+1);
	                temp[index++]=arr[rightIndex++];
	            }else{
	                temp[index++]=arr[leftIndex++];
	            }
	        }

	        while(leftIndex<=mid){
	            temp[index++]=arr[leftIndex++];
	        }

	        while(rightIndex<=right){
	            temp[index++]=arr[rightIndex++];
	        }

	        // use temp length, not arr, second times error
	        for(int i=0;i<temp.length;i++){
	            arr[i+left]=temp[i];
	        }

	        return ans;
	    }

	
}
