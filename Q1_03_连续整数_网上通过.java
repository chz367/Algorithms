package 模拟一;

import java.util.Scanner;

/**
 * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
 * 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 * 10 7 12 8 11 那么抹除掉的整数只可能是9 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 * 
 * 输入描述: 输入包括2行：
 * 第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
 * 第二行为n个整数num[i] (1 <= num[i] <= 1000000000)
 * 
 * 输出描述: 在一行中输出所有可能是抹除掉的数,从小到大输出,用空格分割,行末无空格。如果没有可能的数，则输出mistake
 * 
 * 输入例子: 2 3 6
 * 
 * 输出例子: mistake
 */
public class Q1_03_连续整数_网上通过 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.nextLine();//输入整数n
			int n = Integer.parseInt(str1);

			String string = sc.nextLine();//输入数字序列
			String[] strings = string.split(" ");
			int[] num = new int[n];

			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(strings[i]);//将数字序列保存为数组
			}

			for (int i = 0; i < n - 1; i++) {//利用冒泡排序将数组中的元素进行排序
				for (int j = 0; j < n - 1; j++) {
					if (num[j] > num[j + 1]) {
						int temp = num[j];
						num[j] = num[j + 1];
						num[j + 1] = temp;
					}
				}
			}
			int k = -1;
			int p = 0;
			int q = 0;
			int t = 0;
			for (int i = 0; i < n - 1; i++) {
				if (num[i + 1] - num[i] == 1) {//序列是否连续递增
					q++;
				} else if (num[i + 1] - num[i] > 2) {//统计序列中连续缺少三个数字及以上的情况
					// System.out.println("mistake");
					t++;
					break;
				} else if (num[i + 1] - num[i] == 2) {//统计序列中连续缺少两个数字的情况
					k = (num[i + 1] + num[i]) / 2;//若只缺少一个，则缺少的数字为k
					p++;

				}
			}
			if (k == -1 && q == n - 1 && t == 0) {
				if (n == 1) {//只有输入一个数字时
					if (num[0] == 1) {//这个数字为1时，只能输出2
						System.out.println(2);
					} else {//否则输出两端的值
						System.out.println((num[0] - 1) + " " + (num[0] + 1));
					}

				} else {//输入的序列中元素个数大于1个
					if (num[0] == 1) {//且第一个元素的值为1时，只能输出最后一个元素加1的值
						System.out.println(num[n - 1] + 1);
					} else {//否则输出两端的值
						System.out.println((num[0] - 1) + " " + (num[n - 1] + 1));
					}

				}

			} else if (k != -1 && p == 1 && t == 0) {//序列中间只缺少一个数，k
				System.out.println(k);
			} else if (t != 0 || p != 1) {//不存在
				System.out.println("mistake");
			}

		}
	}

}
