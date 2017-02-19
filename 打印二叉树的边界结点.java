package 第三章;

public class 打印二叉树的边界结点 {
	
	/**
	 * 题目：
	 * 给定一颗二叉树的头结点head,按照如下标实现二叉树边节点的逆时针打印
    	1、头节点为边界节点
    	2、叶结点为边界节点
    	3、如果节点在其所在的层中是最左边或最右边，那么也是边界节点。
	 * */
	/**
	 * 思路：打印边界点
	 * 1首先对输入的二叉树的合法性进行判断
	 * 2获取二叉树的高度（层次数）--利用递归获取
	 * 3获取每一层的最左和最右结点，并将结点保存到Node[level][2]数组中。并打印最左结点
	 * 4获取非最左和最右结点，并且是叶子结点，（判断的依据是：head.left == null && head.right == null && head != edgeMap[level][0] && head != edgeMap[level][1]）并打印
	 * 5打印最右结点，此处注意：保证最左和最右的结点不一样才打印，否则可能会重复打印
	 * */
	
	public static void main(String[] args){
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
		//1合法性
		if(head == null){
			return;
		}
		//2递归求出二叉树的层次数
		int height = getLevel(head, 0);
		//3获取每一层的最右和最左结点，并打印最左，记录最右
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		//打印最左结点
		for(int i = 0; i < edgeMap.length; i++){
			System.out.print(edgeMap[i][0].value + " ");
		}
		
		//4打印非最左和最右的叶子结点
		printLeftNodeInMap(head, 0, edgeMap);
		
		//5打印最右边界点
		for(int i = edgeMap.length - 1; i!= -1; i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.print(edgeMap[i][1].value + " ");
			}
		}
		
	}
	public static void printLeftNodeInMap(Node head, int level, Node[][] edgeMap){
		if(head == null){
			return ;
		}
		//非最左和最右的叶子结点满足的条件（该结点没有孩子结点，left和right都为null，并且该结点不包含在edgeMap中）
		if(head.left == null && head.right == null && head != edgeMap[level][0] && head != edgeMap[level][1]){
			System.out.print(head.value + " ");
		}
		printLeftNodeInMap(head.left, level + 1, edgeMap);
		printLeftNodeInMap(head.right, level + 1, edgeMap);
	}
	
	public static void setEdgeMap(Node h,int level, Node[][] edgeMap){
		if(h == null){
			return ;
		}
		//下句话：先赋值，再判断是否为null，最后再赋值
		edgeMap[level][0] = edgeMap[level][0] == null ? h : edgeMap[level][0];
		edgeMap[level][1] = h;
		setEdgeMap(h.left, level + 1, edgeMap);
		setEdgeMap(h.right, level + 1, edgeMap);
		
	}
	
	public static int getLevel(Node head, int level){
		if(head == null){
			return level;
		}
		
		return Math.max(getLevel(head.left, level + 1), getLevel(head.right, level + 1));
	}
	
}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int data){
		this.value = data;
	}
}
