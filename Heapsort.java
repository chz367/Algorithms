package 排序;

import java.util.Arrays;

////堆排序的伪代码
////heapsort(data[])
////    data转变成一个堆；
////    for i = data.length-1 downto 2
////        将根和i位置上的元素交换;
////        恢复树data[0],...,data[i-1]的堆属性;
//public class Heapsort {
//	public void heapsort(Object[] data){
//		//将数组转换成一个堆
//		for(int i = data.length/2-1; i >= 0; --i)
//			moveDown(data, i, data.length-1);
//		//实现位置的调整
//		for(int i = data.length-1; i >= 1; --i){
//			swap(data, 0, i);
//			moveDown(data, 0, i-1);
//		}
//	}
//	//将一个数组创建成一个堆(根元素沿着树向下移动的算法实现）
//	void moveDown(Object[] data, int first, int last){
//		int largest = 2*first +1;
//		while(largest <= last){
//			//first节点有两个孩子节点（2*first+1和2*first+2），
//			//因此Comparable比较的是两个孩子节点的元素大小
//			if(largest < last && 
//					((Comparable)data[largest]).compareTo(data[largest+1]) < 0)
//				largest++;
//			//比较根节点和最大节点处值的大小，如果满足条件，则交换值的大小，并且移动元素
//			if(((Comparable)data[first]).compareTo(data[largest]) < 0){
//				swap(data, first, last);
//				first = largest;
//				largest = 2*first +1;
//			}
//			else 
//				//不满足堆的循环时，退出循环
//				largest = last + 1;
//		}
//	}
//	//实现数组中两个元素的交换
//	void swap(Object[] a, int e1, int e2){
//		Object tmp = a[e1];
//		a[e1] = a[e2];
//		a[e2] = tmp;
//	}
//
//}

public class Heapsort {
    public static void heapSort(int[] data){
        System.out.println("开始排序");
        int arrayLength=data.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(data,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(data,0,arrayLength-1-i);
            System.out.println(Arrays.toString(data));
        }
    }
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                	//data[biggerIndex].compareTo(data[biggerIndex+1])<0
                    if(data[biggerIndex] < data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                //data[k].compareTo(data[biggerIndex])<0
                if(data[k] < data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] data={21,30,49,30,16,9};
        System.out.println("排序之前：\n"+Arrays.toString(data));
        heapSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}