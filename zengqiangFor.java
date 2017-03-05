package 排序;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zengqiangFor {
	/**
	 * 增强for循环的应用实例。
	 * 其中使用范围主要是：一维数组、二维数组和List
	 */
	public static void main(String[] args) {
		//1、一维数组（普通数组）中的使用
		int array[] = {1,2,3,4,5,6,7};
		
		//增强for循环
		for(int arritem : array){
			System.out.println(arritem);
		}
		//普通的for循环
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		
		//2、二维数组中的使用
		int array2[][] = {{1,2,3},{4,5,6},{7,8,9}};
		//增强的for循环
		for(int arrayitem[] : array2){
			for(int item : arrayitem){
				System.out.println(item);
			}
		}
		//普遍的二维数组的for循环
		for(int i = 0; i < array2.length; i++){
			for(int j = 0; j < array2[i].length; j++){
				System.out.println(array2[i][j]);
			}
		}
		
		//在List中的使用
		List<String> list = new ArrayList<String>();
		list.add("xxx");
		list.add("yyy");
		list.add("zzz");
		//增强for的使用
		for(String item : list){
			System.out.println(item);
		}
		//一般情况下的for循环
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		//迭代器遍历
		for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}
