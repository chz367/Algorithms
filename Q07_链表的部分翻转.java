package 链表_递归_栈;
import java.util.Random;
/*
 * 给定一个链表，翻转该链表从m到n的位置。要求：直接翻转而非申请新空间
 * 以第四个和第八个结点为范围：翻转前的链表：13,96,31,66,71,16,43,78,71,1,翻转后的链表：13,96,31,78,43,16,71,66,71,1,
 * */
public class Q07_链表的部分翻转 {

	public static void main(String[] args) throws Exception {
		ListNode h1 = getList(10);
		
		System.out.print("翻转前的链表：");
		ListNode l1 = h1.nextNode;
		while(l1 != null){
			System.out.print(l1.value + ",");
			l1 = l1.nextNode;
		}
		System.out.println();
		
		System.out.print("翻转后的链表：");	
		ListNode headList = reverse(h1, 4, 8);
		ListNode l2 = headList.nextNode;
		while(l2 != null){
			System.out.print(l2.value + ",");
			l2 = l2.nextNode;
		}
	}
	
	//翻转链表
	public static ListNode reverse(ListNode head, int m, int n) throws Exception{
		if(m > n){
			throw new  Exception("输入的翻转的范围有误!");
		}
		ListNode Head = head;
		ListNode cur = head.nextNode;
		int i;
		for(i = 0; i < m - 1; i++){//空循环找到m-1处
			//System.out.println(cur.value + ".");
			head = cur;
			cur =  cur.nextNode;
		}
		
		ListNode pre = cur;//pre指向第m-1个结点的位置
		cur = cur.nextNode ;//第m个结点
		ListNode pnext;
		for(; i < n - 1; i++){//结合链表图来分析
			pnext = cur.nextNode;
			cur.nextNode = head.nextNode;
			head.nextNode = cur;
			pre.nextNode = pnext;
			cur = pnext;
		}
		return Head;
	}
	
	//随机生成一个链表，其中参数length是链表结点的个数
	public static ListNode getList(int length){
		Random r = new Random();
		if(length < 0){
			return null;
		}
		ListNode head = new ListNode();
		ListNode point = head;
		if(length == 0){
			return head;
		}
		
		for(int i = 0; i < length; i++){
			ListNode p = new ListNode(r.nextInt(100));
			point.nextNode = p;
			point = point.nextNode;
			//System.out.println(point.value + ",");
		}
		return head;
	}
}
