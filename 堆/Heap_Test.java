package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_Test {
	
	

	public static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	}

	
	public static void main(String[]args) {
		MyMaxHeap heap=new MyMaxHeap(100);
		heap.push(2);
		heap.push(7);
		heap.push(3);
		heap.push(8);
		heap.push(6);
		heap.push(5);
		heap.push(1);
		heap.push(9);
		
		while(!heap.isEmpty()) {
			System.out.println(heap.pop());
		}
		
		
		System.out.println("---------------------------------------------");
		
		PriorityQueue<Integer> heap2 = new PriorityQueue<>(new MyComparator());
		heap2.add(2);
		heap2.add(7);
		heap2.add(3);
		heap2.add(8);
		heap2.add(6);
		heap2.add(5);
		heap2.add(1);
		heap2.add(9);

		while (!heap2.isEmpty()) {
			System.out.println(heap2.poll());
		}
	}

}
