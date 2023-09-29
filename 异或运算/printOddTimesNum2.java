package 异或运算;

public class printOddTimesNum2 {
	
	public static void main(String[]args) {
		int[] arr= {2,2,2,7,3,3,4,4,4,4,5,5,5,5,5,5};
		printOddTimesNum2.printOddTimesNum2(arr);
	}
	
	
	static void printOddTimesNum2(int[]arr) {
		
		int eor=0;
		for(int i=0;i<arr.length;i++) {
			eor^=arr[i]; // eor=a^b
		}
		
		int eor2=0;
		int rightOne= eor &(~eor+1); // 提取出最右侧的1
		
		for(int j=0;j<arr.length;j++) {
			if((arr[j]&rightOne)!=0) { 
			// 提取出最右侧有1的数组
			eor2^=arr[j]; // eor2=a
			}
		}
		
		System.out.printf("The first odd number: %d, the second odd number : %d ",eor2,eor2^eor);
		
	}

}
