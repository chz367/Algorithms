package 排序;
//插入排序算法的伪代码
//insertionsort(data[]){
//	for i=1 to data.length-1
//	    temp = data[i];
//	    将所有大于temp的元素data[i]移动一个位置
//	    把temp放到正确的位置上
//}
public class insertionsort {
	public static void main(Object[] data) {
		//插入排序方法的通用实现
		for(int i=1,j;i<data.length;i++){
			Comparable temp=(Comparable)data[i];
			//将所有大于Temp的元素data[j]移动一个位置
			for (j = i; j >0 && temp.compareTo(data[j-1]) < 0; j--)
				data[j] = data[j-1];
			//把temp放到正确的位置上
			data[j] = temp;
		}
		//对整数数组的插入排序的实现
//	public static void main(int[] data) {
//		for(int i=1,j; i<data.length; i++){
//			int temp = data[i];
//			for(j=i;j > 0 && temp < data[j-1]; j--)
//				data[j] = data[j-1];
//			data[j] = temp;
//		}
	}
}

