package 异或运算;

public class printRightOne {
	
	
	public static void main(String[]args) {
		
		int a= 6; // 000110
		int ans=a&(-a);// -a=111010, a^(-a)=000010
		System.out.print(ans);
	}

	
}
