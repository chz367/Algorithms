package 模拟一;

import java.util.Scanner;

/**
 * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
 * 碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，
 * 那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，允许在其中一条上做替换操作：
 * 把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 * 
 * 输入描述: 输入包括一行： 包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50。
 * 
 * 输出描述: 输出一个整数，即最少需要多少次让两条碱基链配对成功
 * 
 * 输入例子: ACGT TGCA
 * 
 * 输出例子: 0
 */
public class Q1_04_DNA合成_网上通过 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			String[] strings = string.split(" ");
			String a = strings[0];
			String b = strings[1];

			if (a.length() != b.length()) {
				return;
			}
			int j = 0;
			for (int i = 0; i < a.length(); i++) {
				//注意配对的过程是：A--T，T--A,G--C,C--G，双向的过程
				if (a.charAt(i) == 'A' && b.charAt(i) == 'T' || a.charAt(i) == 'T' && b.charAt(i) == 'A'
						|| a.charAt(i) == 'G' && b.charAt(i) == 'C' || a.charAt(i) == 'C' && b.charAt(i) == 'G') {
					j++;
				}
			}

			System.out.println(a.length() - j);
		}
	}
}
