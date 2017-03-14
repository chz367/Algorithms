package 模拟一;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
 * 答案可能有多个，我我们需要找出长度最小的那个。 例如 N = 18 L = 2： 
 * 5 + 6 + 7 = 18 3 + 4 + 5 + 6 = 18 都是满足要求的，但是我们输出更短的 5 6 7
 * 
 * 输入描述: 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
 * 
 * 输出描述: 从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
 * 
 * 输入例子: 18 2
 * 
 * 输出例子: 5 6 7
 */
public class Q1_06_序列和_网上通过 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int len = sc.nextInt();
			List<Integer> list = getSequence(n, len);
			if (list.size() == 0) {
				System.out.println("No");
			} else {
				for (int i = 0; i < list.size(); i++) {//打印出元素
					if (i == 0) {
						System.out.print(list.get(0));
					} else {
						System.out.print(" " + list.get(i));
					}
				}
			}
		}
	}

	public static List<Integer> getSequence(int n, int len) {
		List<Integer> list = new ArrayList<>();//用来存放符合条件的序列
		for (int i = len; i <= 100; i++) {//先从最短的情况判断
			//首先保证n要大于等于i * (i - 1) / 2
			//其次判断n和i * (i - 1) / 2的差是不是正好对当前元素的个数整除
			if ((n - i * (i - 1) / 2) >= 0 && (n - i * (i - 1) / 2) % i == 0) {
				int a = (n - i * (i - 1) / 2) / i;
				for (int j = 0; j < i; j++) {
					list.add(a + j);
				}
				return list;
			}
		}
		return list;
	}
}
