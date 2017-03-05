package 排序;

import java.util.Collection;
import java.util.Queue;

import javax.management.Query;

import org.omg.CORBA.PUBLIC_MEMBER;

public class RadixSort {
//	基数排序的伪代码
//	RadixSort()
//	    for d = 1 to 最长数字的最左边数字所在的位置
//	        根据第d位数字将所有的数字分别分配到堆0至堆9中；
//	        将所有证书放进一个数组中；
	public static void radixsort(int[] data){
		int d, j, k, factor;
		int radix = 10;
		int digits = 10;
		Queue[] queues = new Queue[radix];
		for(d = 0; d < radix; d++)
			queues[d] = new Queue();
		for(d = 1, factor = 1; d <= digits; factor *=radix, j++){
		    for(j=0; j < data.length; j++){
		    	queues[(data[j]/factor)%radix].enqueue(new Integer(data[j]));
		    }
		    for(j = k = 0; j < radix; j++){
		    	while(!queues[j].isEmpty()){
		    		data[k++] = ((Integer)queues[j].dequeue()).intValue();
		    	}
		    }
		}

	}
	
	

}
