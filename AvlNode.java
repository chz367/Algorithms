package 树;

//定义平衡二叉树Avl的结构
public class AvlNode<T extends Comparable<T>> {
	public AvlNode(T value){
		this(value, null, null);
	}
	
	public AvlNode(T value, AvlNode lt, AvlNode rt){
		data = value;
		left = lt;
		right = rt;
		height = 0;
	}
	
	T data;				//键值
	AvlNode<T> left;	//左孩子结点
	AvlNode<T> right;	//右孩子结点
	int height;			//树的高度
}
