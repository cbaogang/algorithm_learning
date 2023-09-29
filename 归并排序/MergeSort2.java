package 归并排序;

import java.util.Arrays;

public class MergeSort2 {
	
	
	public static void main(String[]args) {
		
	int[]arr= {2,1,5,4,3,6,8,7,10,9};	
	mergeSort2(arr);
	System.out.print(Arrays.toString(arr));
	}


	// 非递归方法实现
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		// 步长
		int mergeSize = 1;
		while (mergeSize < N) { // log N
			// L 来到每个左组的第一个位置，越界就要停
			int L = 0;
			while (L < N) {
				// 左组来到的位置可能不足一个步长
				if (mergeSize >= N - L) {
					break;
				}
				
				//M 是左组最后一个位置
				int M = L + mergeSize - 1;
				
				// 右组M+1开始，右组可以到的位置：M+步长（右组够），M+(N-（M+1）)右组不够
				int R = M + Math.min(mergeSize, N - M - 1);
				merge(arr, L, M, R);
				L = R + 1;
			}
			// 防止溢出
			if (mergeSize > N / 2) {
				break;
			}
			mergeSize <<= 1;
		}
	}
	
	
	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 要么p1越界了，要么p2越界了
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}
}
