package 排序;
//选择排序的伪代码
//selectionsoft(data[])
//    for i = 0 to data.length-2
//    从data[i],...,data[data.length-1]中选择取最小的元素；
//    将它和data[i]交换；
public class selectionsoft {
	public void selectionsoft (int[] data) {
		int i,j,least;
		if(data == null || data.length <= 0){
			return;
		}
		for(i = 0; i < data.length -1; i++){
			for(j = i+1, least = i; j < data.length; j++){
				//least=i;表示将当前位置的元素定义为最小值的下标
				//如果有小于当前最小值的关键字
				if(data[least] > data[j])
					//将此关键字的下标赋值给least
					least = j;
			}
			if(i != least){//如果least不等于i,说明找到最小值
				int tmp = data[least];
			    data[least] = data[i];
			    data[i] = tmp;
			}
		}
	}
}
