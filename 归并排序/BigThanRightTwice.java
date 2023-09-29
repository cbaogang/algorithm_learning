package 归并排序;

public class BigThanRightTwice {
	public static void main(String[]args) {
		int[]arr= {23, 11, 3};
		BigThanRightTwice solution = new BigThanRightTwice();
		
		int ans=solution.bigThanRightTwice(arr);
		System.out.println(ans);
		
	}
	

	

	    public int bigThanRightTwice(int[] record) {
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
	               
	            if ((long) arr[leftIndex] <= (long) arr[rightIndex] * 2) {
	                // This element from the left subarray doesn't create a reverse pair.
	                temp[index++] = arr[leftIndex++];
	            } else {
	                // This element from the left subarray creates reverse pairs with elements in the right subarray.
	                ans += mid - leftIndex + 1;
	                temp[index++] = arr[rightIndex++];
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
