package 排序;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
//quicksort(Object[] array)
//    选择数轴tmp
//    将元素进行两侧划分成子数组suba1和suba2
//    对子数组在进行快速排序
public class quicksort {
	public static void main(String[] args){
		int[] a = {8,5,4,7,6,1,6,3,8,12,10};
		if(a.length <= 0){
			return;
		}
		System.out.println("排序之前：\n"+Arrays.toString(a));
		quicksort(a, 0, a.length-1);
		System.out.println("排序之后：\n"+Arrays.toString(a));
	}
	public static int getMiddle(int[] array, int low, int high){
		int tmp = array[low];//数组的第一个作为数轴
		while(low < high){
			//满足右侧元素大于数轴，则high下标减1;否则的话（比数轴要小）则将其放在元素左侧
			while(low < high && array[high] >= tmp){
				high--;
			}
			array[low] = array[high];//比数轴小的记录移动到左侧
			//满足左侧的元素小于数轴，则low下标加1；否则的话（比数轴要大）则将其放在元素的右侧
			while( low < high && array[low] <=tmp){
				low++;
			}
			array[high] = array[low];//比数轴大的元素放在右侧
		}
		array[low] = tmp;//数轴记录到最后
		return low;//返回数轴的位置
	}
	public static void quicksort(int[] array, int low, int high){
		if(low < high){
			int middle = getMiddle(array, low, high);//将list数组一分为二
			quicksort(array, low, middle-1);
			quicksort(array, middle+1, high);
		}
	}
}
