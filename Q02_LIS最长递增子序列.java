package 字符串;

import java.util.Arrays;
import java.util.Stack;
/**
 * 问题：LIS最长递增子序列。给出一个数组，找出其最长的递增的子序列。
 * 解决思路：原数组arr的子序列顺序保持不变，而且排序后的array本身是递增的。这样得到的两个序列的子序列一定是递增的序列。
 * 		      要求出数组arr的最长递增子序列，其实就是求数组arr和它的排序数组array的最长公共子序列。
 * */
public class Q02_LIS最长递增子序列 {

	public static void main(String[] args) {
		int[] arr = {5,6,7,1,2,3,8};
		int len = arr.length;
		int[] array = new int[len];
		//将arr复制给array
		for(int j = 0; j < arr.length; j++){
			array[j] = arr[j];
		}
		
		//此处可以使用Java中自带的排序方法Arrays.sort(arr);为了练习自写了一个快速排序
		quickSort(array,0,array.length-1);
		
		System.out.print("排序前的数组：");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		System.out.print("排序后的数组：");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.println();
				
		getLCS(arr, array);
	}
	//hinge---枢纽
	public static int findHinge(int[] array, int left, int right){
		int key;
		key = array[left];//记录left,此时array[left]为空
		
		while(left < right){
			while(left < right && array[right] > key){
				right --;
			}
			array[left] = array[right];//此时array[right]为空
			
			while(left < right && array[left] < key){
				left ++;
			}
			array[right] = array[left];//此时array[left]为空
		}
		
		array[left] = key;
		return left;
	}
	//回忆一遍快速排序的算法
	public static void quickSort(int[] array, int left, int right){
		int mid;
		if(left < right){
			mid = findHinge(array, left, right);
			quickSort(array, left, mid -1);
			quickSort(array, mid +1, right);
		}
	}
	
	public static void getLCS(int[] array, int[] data){//两个数组获取最长公共子序列
		int len1 = array.length;
		int len2 = data.length;
		
		int[][] newArr = new int[len1+1][len2+1];
		//设置第0行和第0列为0
		for(int i = 0; i < newArr.length; i++){
			newArr[i][0] = 0;
		}
		for(int j = 0; j < newArr[0].length; j++){
			newArr[0][j] = 0;
		}
		
		//二维数组填写，记录相同的字符序列
		for(int i = 1; i < newArr.length; i++){
			for(int j = 1; j < newArr[i].length; j++){
				if(array[i - 1] == data[j - 1]){
					//动规公式一：LCS(Xm, Yn) = LCS(Xm-1, Yn-1) +Xm
					newArr[i][j] = newArr[i-1][j-1] + 1;
				}else{
					//动规公式二：LCS(Xm, Yn) = MAX{LCS(Xm-1, Yn), LCS(Xm, Yn-1)}
					newArr[i][j] = max(newArr[i-1][j],newArr[i][j-1]);
				}
			}
		}
		
//		//测试数据：将棋盘赋满值,这样可以从右下角开始遍历找出最大公共子序列
//		for(int m = 0; m < newArr.length; m++){
//			for(int n = 0; n < newArr[m].length; n++){
//				System.out.print(newArr[m][n]);
//			}
//			System.out.println();
//		}
		
		Stack<Integer> stack = new Stack();
		int m = array.length - 1;
		int n = data.length - 1;
		while(n >= 0 && m >= 0){//数组从后向前遍历
			if(array[m] == data[n]){//字符相同则入栈
				stack.push(array[m]);
				m--;
				n--;
			}else{
				if(newArr[m+1][n] > newArr[m][n+1]){//字符不同时，根据打印出的二维矩阵（测试数据）查找上一个相同的字符
					n--;
				}else{
					m--;
				}
			}
		}
		
		while(!stack.isEmpty()){//打印出最长的递增子序列
			System.out.print(stack.pop() + ",");
		}
	}
	
	public static int max(int a, int b){
		return (a > b) ? a : b;
	}
	

}
