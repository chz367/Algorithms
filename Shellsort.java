package 排序;

//Shell排序的伪代码
//把data分成h个数组
//    for i =1 to h
//        排序子数组data(i);
//    排序数组data
public class Shellsort {
	public void Shellsort(Object[] data){
		/*
		 * 声明涉及到的变量，其中
		 * i表示：Shell排序中的趟数，即：第i趟排序；
		 * j，k表示：数组元素；
		 * h表示：增量值；
		 * hCnt表示：变量值，用于控制每趟排序的次数；
		 * increment[]表示：每次排序时的增量值的数组。
		 * */
		int i, j, k, h, hCnt, increments[] = new int[20];
		//创建一个合适的增量值h
		for(h = 1, i = 0; h < data.length; i++){
			increments[i] = h;
			h = 3*h + 1;
		}
		//一共进行i趟排序
		for(i--; i >= 0; i--){
			h = increments[i];
			//每趟排序中执行的次数
			for(hCnt = h; hCnt < 2*h; hCnt++){
				//在每次中进行直接插入排序
				for(j = hCnt; j < data.length;){
					Comparable tmp = (Comparable)data[j];
					k = j;
					while (k-h >=0 && tmp.compareTo(data[k-h]) < 0) {
						data[k] = data[k-h];
						k -= h;
					}
					data[k] = tmp;
					j += h;
				}
			}
		}
	}
}
