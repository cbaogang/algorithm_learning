package 异或运算;

import java.util.HashMap;

public class printKTimesNums {
	
	public static void main(String[]args) {
		int [] arr= {4,4,1,1,1,2,2,2,3,3,3};
		int k=2;
		int m=9;
		System.out.println(printKTimesNumsHashMap(arr,2,3));
	}
	
	
	public static int printKTimesNums(int[]arr, int k, int m) {
		
		int [] t = new int[32];
		
		for(int num:arr) {
			for(int i =0; i <=31;i++) {
				t[i]+=(num>>i)&1;
			}
		}
		
		int ans=0;
		for(int i=0;i<32;i++) {
			if(t[i]%m!=0) { //说明在第i位上，有1
				ans |= (1<<i);//1向左移动i位置，把第i位置上的1或进去
			}
		}
		
		return ans;
	}
	
public static int printKTimesNumsHashMap(int[]arr, int k, int m) {
		
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int num:arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
	  
		for(int num:map.keySet()) {
			if(map.get(num)==k) {
				return num;
			}
		}
		
		
		return -1;
	}

}
