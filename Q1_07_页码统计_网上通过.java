package 模拟一;

import java.util.Scanner;

/**
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：
 * 在这本算法书页码中0~9每个数字分别出现了多少次？
 * 输入描述:输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 * 
 * 输出描述: 输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格。
 * 
 * 输入例子: 999
 * 
 * 输出例子: 189 300 300 300 300 300 300 300 300 300
 */
public class Q1_07_页码统计_网上通过 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();

			// long[] k = new long[10];
			long[] k = getNum(n);
			System.out.println(k[0] + " " + k[1] + " " + k[2] + " " + k[3] + " " + k[4] + " " + k[5] + " " + k[6] + " "
					+ k[7] + " " + k[8] + " " + k[9]);
		}
	}

	public static long[] getNum(long n) {
		// long iNum = 0;
		long[] lon = new long[10];
		if (n == 0) {
			return lon;
		}
		if (n % 10 < 9) {
			lon = getNum(n - 1);
			while (n != 0) {
				lon[(int) (n % 10)]++;
				n = n / 10;
			}
			return lon;
		}
		//n%10==9的情况
		lon = getNum(n / 10);
		for (int i = 0; i < 10; i++) {
			if (i > 0) {
				lon[i] = lon[i] * 10 + n / 10 + 1;// (int)(i>0)
			} else {
				lon[i] = lon[i] * 10 + n / 10 + 0;// (int)(i>0)
			}
		}

		return lon;
	}
}
