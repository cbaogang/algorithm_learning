package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;



public class MaxCover {

	
	public static void main(String[]args) {
		int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
	
		int  max=maxCover(intervals);
		
		System.out.println(max);
		
	}
	
	
	public static int maxCover(int[][]m) {
		if(m==null||m.length==0) {
			return 0;
		}
		
		Arrays.sort(m,(m1,m2)->m1[0]-m2[0]);
		PriorityQueue<Integer> heap= new PriorityQueue<>();
		int max=0;
		
		for(int[]n:m) {
			int start=n[0];
			int end=n[1];
			
			while(!heap.isEmpty()&&start>=heap.peek()) {
				heap.poll();
			}
			
			heap.add(end);
			
			max=Math.max(max, heap.size());
		}
		
		return max;
	}
}
