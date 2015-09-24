package com.bern.algorithm;

/**
 * 快速排序
 * @author Bern
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = {5,4,8,9,3,6,1,2,7};
		System.out.println("排序前：");
		for(int e : array) {
			System.out.print(e+",");
		}
		System.out.println();
		
		quickSort(array, 0, array.length-1);
		
		System.out.println("排序后：");
		for(int e : array) {
			System.out.print(e+",");
		}
		
	}
	
	/**
	 * 快速排序的实现
	 * @param a 待排序的数组
	 * @param low 数组头位置
	 * @param high 数组尾的位置
	 */
	public static void quickSort(int[] a, int low, int high) {
		int m = low, n = high;	
		int key = a[low];	//每一次比较时的基准元素
		
		while(low < high) {
			while(low<high && a[high]>key) {	//基准元素在low
				high--;
			}
			a[low] = a[high];
			
			while(low<high && a[low]<key) {		//基准元素在high
				low++;
			}
			a[high] = a[low];
		}
		
		a[low] = key;
		
		//对基准元素两边的元素进行排序
		if(m < low-1) {
			quickSort(a, m, low-1);
		}
		if(low+1 < n) {
			quickSort(a, low+1, n);
		}
	}
}
