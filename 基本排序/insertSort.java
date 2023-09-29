package 基本排序;

import java.util.Arrays;

class insertSort{

public static void main(String[]args){

int[] arr= {7,8,2,3,0,1,6,5};
insertSort.insertSort(arr);
System.out.print(Arrays.toString(arr));

}
    
static void insertSort(int[]arr){
    if(arr==null||arr.length<2){
        return;
    }
    
    for(int i=1;i<arr.length;i++){
        int tmp= arr[i];
        int j=i-1;
        while(j>=0&&arr[j]>tmp){
            arr[j+1]=arr[j];
            j--;
		}
        
        arr[j+1]=tmp;
    }
}



}
