package 模拟一;

import java.util.Scanner;
/**
 * 如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。
 * 现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。
 * 
 * 输入：27
 * 输出：3 3
 * */

public class Q1_05_超级素数幂_网上通过 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long n = sc.nextLong();
			function(n);
		}
	}
	public static void function(long n){
		long p = (long)(Math.sqrt(n)+1);
		long q = 2;
		for(;p>=2;p--){
			long tmp = myPow(p, q);
			long flag = tmp-n;
			if(flag == 0){
				if(!isPrime((int)p)) continue;
				System.out.println(p + " " + q);
				return;
			}else if(flag<0){
				q++;
				p=(long)(Math.pow(n, 1.0/q)+1);//对应指数增加时，底数是n^(1.0/q),即q次根号下n,
			}
		}
		System.out.println("No");
	}
	
	public static boolean isPrime(int n){//判断一个数是否为素数
		if(n<1){
			return false;
		}
		for(int i = 2; i*i <= n; i++){
			if(n%i ==0){
				return false;
			}			
		}		
		return true;
	}
	public static long myPow(long p, long q){//自定义的求幂级数运算
		return q == 0? 1:myPow(p, q-1)*p;
	}	
}
