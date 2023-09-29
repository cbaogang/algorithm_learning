package 归并排序;

public class SmallSum {

	public static void main(String[]args) {
		int[]arr= {1,3,4,2,5};
		int ans=smallSum(arr);
		System.out.println(ans);
	}
	
	
	public static int smallSum(int[]arr) {
		if(arr==null||arr.length<2) {
			return 0;
		}
	
		return sum(arr,0,arr.length-1);
	}
	
	public static int sum(int[]arr,int left,int right) {
		if(left==right) {
			return 0;
		}
		int mid=(left+right)/2;
		return sum(arr,left,mid)
				+sum(arr,mid+1,right)
				+merge(arr,left,mid,right);
	}
	
	public static int merge(int[]arr,int left,int mid,int right) {
		
		int [] help=new int [right-left+1];
		int leftIndex=left;
		int rightIndex=mid+1;
		int helpIndex=0;
		int ans=0;
		
		while(leftIndex<=mid&rightIndex<=right) {
			if(arr[leftIndex]<arr[rightIndex]) {
				
				// 不要把right写成rightIndex
				// 不要把rightIndex 写成leftIndex
				ans+=arr[leftIndex]*(right-rightIndex+1);
				help[helpIndex++]=arr[leftIndex++];
			}else {
				help[helpIndex++]=arr[rightIndex++];
			}
		}
		
		while(leftIndex<=mid) {
			help[helpIndex++]=arr[leftIndex++];
		}
		
		// 不要把rightIndex写成right
		
		while(rightIndex<=right) {
			help[helpIndex++]=arr[rightIndex++];
		}
		
		for(int i=0;i<help.length;i++) {
			arr[i+left]=help[i];
		}
		
		return ans;
	}
}
