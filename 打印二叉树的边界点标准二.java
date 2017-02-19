package 第三章;

public class 打印二叉树的边界点标准二 {
	
	/**
	 * 题目：给定一棵二叉树的头结点head，按照如下标准逆时针打印边界节点
	 * 1、头结点为边界节点
	 * 2、叶节点为边界结点
	 * 3、树左边界延伸下去的路径为边界节点
	 * 4、树右边界延伸下去的路径为边界节点
	 * */
	/**
	 * 思路：
	 * 1、头结点，打印
	 * 2、叶节点，打印
	 * 3、中间结点要判断
	 *   3.1以head为中间，将树分为左右两侧
	 *   3.2左侧树中间结点要看父结点是不是边界节点，是的话，继续判断该节点的左兄弟是不是存在，是的话不打印，不是的话打印；
	 *                                    不是的话，不打印。（排除叶子节点的判断）
	 *      遍历顺序：前序遍历。
	 *   3.3右侧树中间结点要看父结点是不是边界节点，是的话，继续判断该节点的右兄弟是不是存在，是的话不打印，不是的话打印；
	 *                                    不是的话，不打印。（排除叶子节点的判断）
	 *      便利顺序：后序遍历。
	 *   说明：两侧顺的遍历方式不一致的目的是保证顺时针打印。
	 * */
	
	public static void main(String[] args) {
		Node node1 = new Node(1);  
		Node node2 = new Node(2);  
		Node node3 = new Node(3);  
		Node node4 = new Node(4);  
		Node node5 = new Node(5);  
		Node node6 = new Node(6);  
		Node node7 = new Node(7);  
		Node node8 = new Node(8);  
		Node node9 = new Node(9);  
		Node node10 = new Node(10);  
		Node node11 = new Node(11);  
		Node node12 = new Node(12);  
		Node node13 = new Node(13);  
		Node node14 = new Node(14);  
		Node node15 = new Node(15);  
		Node node16 = new Node(16);  
		node1.left = node2;  
		node1.right = node3;  
		node2.right = node4;  
		node3.left = node5;  
		node3.right = node6;  
		node4.left = node7;  
		node4.right = node8;  
		node5.left = node9;  
		node5.right = node10;  
		node8.right = node11;  
		node9.left = node12;  
		node11.left = node13;  
		node11.right = node14;  
		node12.left = node15;  
		node12.right = node16;  
		printEdge(node1); 
	}
	
	public static void printEdge(Node head){
		if(head == null){
			return ;
		}
		
		System.out.print(head.value + " ");
		if(head.left != null && head.right != null){
			printLeftEdge(head.left, true);
			printRightEdge(head.right, true);
		}else{
			printEdge(head.left == null ? head.left : head.right);
		}
	}
	public static void printLeftEdge(Node h, boolean print){
		if(h == null){
			return ;
		}
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		printLeftEdge(h.left, print);
		printLeftEdge(h.right, print && h.left == null ? true : false);
	}
		
	public static void printRightEdge(Node h, boolean print){
		if(h == null){
			return ;
		}
		printRightEdge(h.left, print && h.right == null ? true : false);
		printRightEdge(h.right, print);
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
	}
}

//class Node{
//	int value;
//	Node left;
//	Node right;
//	
//	public Node(int data){
//		this.value = data;
//	}
//}
