package 异或运算;

public class printOddTimesNum1 {
	public static void main(String[]args) {
		int[] arr= {2,2,2,3,3,4,4,4,4,5,5,5,5,5,5};
		printOddTimesNum1.printOddTimesNum1(arr);
	}
	
	static void printOddTimesNum1(int[]arr) {
		
		int eor=0;
		for(int i=0;i<arr.length;i++) {
			eor^=arr[i];
		}
		
		System.out.println(eor);
	}
	
}
