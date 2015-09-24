package com.bern.algorithm;

/**
 * 归并排序
 * @author Bern
 *
 */
public class MergerSort {
	public static void main(String[] args) {
		int[] array = {5,4,8,9,3,6,1,2,7};
		System.out.println("排序前：");
		for(int e : array) {
			System.out.print(e+",");
		}
		
		System.out.println("\n merge sort");
		
		divide(array, 0, array.length-1);
		
		System.out.println("排序后：");
		for(int e : array) {
			System.out.print(e+",");
		}
	}
	
	/**
	 * 切分一个数组为两个
	 * @param a 待切分的数组
	 * @param left 第一个数组的位置
	 * @param right 第二个数组的位置
	 */
	public static void divide(int[] a, int left, int right) {
		int middle = (left+right)/2;
		if(left < right) {
			divide(a, left, middle);
			divide(a, middle+1, right);
			merge(a, left, middle, right);
		}
	}
	
	/**
	 * 合并两个数组
	 * @param a 待合并的数组
	 * @param left 第一个数组的位置
	 * @param middle 两个数组的分隔线（第一个数组尾元素的位置）
	 * @param right 第二个数组的位置
	 */
	public static void merge(int[] a, int left, int middle, int right) {
		int[] temp = new int[a.length];
		int x = 0;		//temp的游标
		int m = left;		//第一个数组的游标
		int n = middle+1;		//第二个数组的游标
		
		//区两个分数组的元素比较 并 放入temp
		while(m<=middle && n<=right) {
			if(a[m] <= a[n]) {
				temp[x] = a[m];
				m++;
			}else {
				temp[x] = a[n];
				n++;
			}
			x++;
		}
		
		//将分数组的元素全部添加到temp
		while(m <= middle) {
			temp[x++] = a[m++];
		}
		while(n <= left) {
			temp[x++] = a[n++];
		}
		
		//将合并后的数组放入原数组中
		for(int i=0; i<x; i++) {
			a[left+i] = temp[i];
		}
		
	}
}
