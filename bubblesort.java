package 排序;

//冒泡排序的伪代码
//bubblesort(data[])
//    for i to data.length-2
//        for j = data.lengt-1 downto j+1
//            如果顺序错误就交换j和j-1位置上的元素；

public class bubblesort {
	//bubblesort1()方法每次寻找最小元素放在相应位置（前边）
	public void bubblesort1(int[] data){
		int tmp = 0;
		for(int i = 0; i < data.length; i++){//外层循环从0到data.length-1
			for(int j = data.length-1; j > i; --j){//内层循环从大于i位置后的元素中选择
				if(data[j] < data[j-1]){
					tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
				}
			}
		}
	}
	//bubblesort1()方法每次寻找最大值放在相应位置（后边）
	public void bubblesort2(int[] a){
		int temp = 0;
		for(int i = a.length-1; i > 0; --i){//外层循环是从a.length-1到0的位置上
			for(int j = 0; j < i; j++){//内层循环是从0到i的位置上的元素进行选择
				if(a[j+1] < a[j]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
}
