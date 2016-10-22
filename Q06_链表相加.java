package 链表_递归_栈;

import java.util.Random;
/**
 * 随机生成两个非负整数的链表，每个节点只存储一个数字，实现两个链表的相加，返回链表头结点。
 * 例如：2——4——3和5——6——4，得到的链表时7——0——8
 * */
public class Q06_链表相加 {
	
	public static void main(String[] args){
		ListNode ls1 = getList(3);//
		ListNode ls2 = getList(5);
		
		System.out.print("链表一：");
		ListNode l1 = ls1.nextNode;
		while(l1 != null){//打印链表一
			System.out.print(l1.value + ",");
			l1 = l1.nextNode;
		}
		System.out.println();
		
		System.out.print("链表二：");
		ListNode l2 = ls2.nextNode;
		while(l2 != null){//打印链表二
			System.out.print(l2.value + ",");
			l2 = l2.nextNode;
		}
		System.out.println();
		
		System.out.print("链表相加后的结果：");
		ListNode ls3 = addList(ls1, ls2);
		while(ls3.nextNode != null){//打印相加后的链表
			System.out.print(ls3.nextNode.value + " ,");
			ls3 = ls3.nextNode;
		}
	}
	//两个链表相加。参数是两个链表的头结点，相加的过程包括四个方面：
	//1）合法性的判断；2）两个链表同时存在的结点相加；3）处理较长的链表；4）最后要防止进位位单独生成一个结点
	public static ListNode addList(ListNode h1, ListNode h2){
		if(h1 == null && h2 == null){//1）合法性的判断；
			return null;
		}
		ListNode head = new ListNode();//相加后链表的头结点
		ListNode pTail = head;
		ListNode p1 = h1.nextNode;
		ListNode p2 = h2.nextNode;
		ListNode curp;
		int carry = 0;//进位位
		int value;//结点值
		while(p1 != null && p2 != null){//2）两个链表同时存在的结点相加
			value = p1.value + p2.value + carry;//两个链表结点的和再加上进位位
			carry = value / 10;
			value = value % 10;//相加后链表的（新）结点的值
			
			curp = new ListNode(value);//以value为值建一个结点，并添加到head链表中
			pTail.nextNode = curp;
			pTail = curp;
									
			p1 = p1.nextNode;
			p2 = p2.nextNode;
		}
		
		ListNode p = (p1 != null) ? p1 : p2;//判断哪个链表比较长
		//3）处理较长的链表,将较长的链表剩余的部分添加到新链表head中
		while(p != null){
			value = p.value + carry;
			carry = value / 10;
			value = value % 10;
			
			curp = new ListNode(value);
			pTail.nextNode = curp;
			pTail = curp;
			
			p = p.nextNode;
		}
		
		//4）最后一位可能存在进位位，需要处理
		if(carry != 0){
			curp = new ListNode(carry);
			pTail.nextNode = curp;
		}
		
		return head;		
	}
	
	//随机生成链表的函数，参数length是生成链表的长度，即：结点的个数
	public static ListNode getList(int length){//length是链表的长度
		if(length < 0){
			return null;
		}
		ListNode head = new ListNode();//链表的头结点
		ListNode p1 = head;
		if(length == 0){
			return head;
		}
		Random r = new Random();
		for(int i = 0; i < length; i++){
			ListNode p = new ListNode(r.nextInt(10));//随机生成10以内的数值作为结点的value值
			p1.nextNode = p;//利用“尾插法”
			p1 = p1.nextNode;
			//System.out.print(p.value + " ");
		}
		//System.out.println();
		return head;
	}
}
