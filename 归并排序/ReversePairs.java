package 归并排序;

public class ReversePairs {
	
	public static void main(String[]args) {
		int[]arr= {9, 7, 5, 4, 6};
		 ReversePairs solution = new ReversePairs();
		
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
        if(left==right){
            return 0;
        }

        int mid=left+((right-left)>>1);

        return reverse(arr,left,mid)+reverse(arr,mid+1,right)+merge(arr,left,mid,right);
    }


    public int merge(int[]arr,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int leftIndex=mid;
        int rightIndex=right;
        // 易错点：tempIndex从temp数组的最后一个数开始，而不是right
        int tempIndex=temp.length-1;
        int ans=0;

        while(leftIndex>=left&&rightIndex>mid){
            if(arr[leftIndex]>arr[rightIndex]){
                ans+=(rightIndex-mid);
                temp[tempIndex--]=arr[leftIndex--];
            }else{
                temp[tempIndex--]=arr[rightIndex--];
            }
        }

        while(leftIndex>=left){
            temp[tempIndex--]=arr[leftIndex--];
        }

        // 易错点：righIndex忘记--
        while(rightIndex>mid){
            temp[tempIndex--]=arr[rightIndex--];
        }

        // 易错点： use temp length, not arr, second times error
        for(int i=0;i<temp.length;i++){
        	// 易错点：use left not leftIndex
            arr[i+left]=temp[i];
        }

        return ans;
    }
}
