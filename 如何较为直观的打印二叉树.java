package 第三章;

public class 如何较为直观的打印二叉树 {
	//1、先考虑采用什么顺序来遍历二叉树（这里采用先右节点，再根节点，最后遍历左节点）
	//2、仍然采用的是递归来遍历二叉树
	//3、访问一个节点时的格式：定义len字符的长度，其中不足的地方添加空格补全
		//头结点的样式为:H12H    右结点的样式：v12v  左节点的样式:^12^
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
		directPrintNode(node1, 0, "H", 10);
	}
	
	
	public static void directPrintNode(Node h, int height, String to, int len){
		if(h == null){
			return ;
		}
		//首先是右结点
		directPrintNode(h.right, height+1, "v", len);
		//根节点
		String hString = to + h.value + to;
		int length = hString.length();
		int preSpace = (len - length);
		int posSpace = len - preSpace - length;
		String printStr = getSpace(preSpace) + hString + getSpace(posSpace);
		System.out.println(getSpace(height*len)+printStr);
		//最后为左节点
		directPrintNode(h.left, height+1, "^", len);
	}
	public static String getSpace(int len){
		String spaceStr = "";
		if(len == 0){
			return spaceStr;
		}
		for(int i = 0; i < len; i++){
			spaceStr += " ";
		}
				
		return spaceStr;
	}
}
