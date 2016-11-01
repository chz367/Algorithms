package 树;

/**
 * 平衡二叉树的一系列操作：
 * 1、计算树的高度height(AvlNode<T> t)
 * 2、四种旋转实现（LL，LR，RL，RR）
 * 3、AVL树中插入节点的操作，返回插入后的结点
 * 4、AVL树的删除结点操作
 * 5、AVL树中删除key值的结点
 * 6、非递归实现查找tree中的key值
 * 7、寻找最大节点&结点的最大值
 * 8、寻找最小节点&结点的最小值
 * 9、前序遍历Avl树---“根--左--右”（递归）
 * 10、中序遍历Avl树---“左--根--右”（递归）
 * 11、后序遍历Avl树---“左--右--根”（递归）
 * */
public class AVL<T extends Comparable<T>> {
	//计算树的高度
	public int height(AvlNode<T> t){
		return t == null ? -1 : t.height;
	}
	
	//LL：单选转
	public AvlNode<T> leftLeftRotate(AvlNode<T> k2){
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height);	
		
		return k1;
	}
	
	//RR:单旋转
	public AvlNode<T> rightRightRotate(AvlNode<T> k1){
		AvlNode<T> k2;
		k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		
		k1.height = Math.max(height(k1.left), height(k2.left)) + 1;
		k2.height = Math.max(k1.height, height(k2.right)) + 1;
		
		return k1;
	}
	
	//LR:双旋转-----先RR后LL
	public AvlNode<T> leftRightRotate(AvlNode<T> k3){
		k3.left = rightRightRotate(k3.left);
				
		return leftLeftRotate(k3);
	}
	
	//RL:双旋转-----先LL后RR
	public AvlNode<T> rightLeftRotate(AvlNode<T> k1){
		k1.left = leftLeftRotate(k1.left);
		
		return rightRightRotate(k1);
	}
	
	//AVL树中插入节点的操作，返回插入后的结点
	public AvlNode<T> insert(T key, AvlNode<T> tree){
		//创建一个新的结点
		if(tree == null){
			return new AvlNode<T>(key,null,null);
		}
		
		int cmp = key.compareTo(tree.data);
		
		//在tree的左结点上插入
		if(cmp < 0){
			tree.left = insert(key, tree.left);
			if(height(tree.left) - height(tree.right) == 2){
				if(key.compareTo(tree.left.data) < 0){
					//LL型：单旋转
					tree = leftLeftRotate(tree);
				}else{
					//LR型：双旋转
					tree = leftRightRotate(tree);
				}
			}
		}else if(cmp > 0){
			tree.right = insert(key, tree.right);
			if(height(tree.right) - height(tree.left) == 2){
				if(key.compareTo(tree.right.data) > 0){
					//RR型：单旋转
					tree = rightRightRotate(tree);
				}else{
					//RL型：双旋转
					tree = rightLeftRotate(tree);
				}
			}
		}else{
			//相等的情况
			return null;
		}
		
		// 插入后 树的高度
		tree.height = Math.max(height(tree.left), height(tree.right)) + 1; 
		
		return tree;
	}
	
	//AVL树的删除操作，其中要删除的结点是del,tee是树的根结点
	public AvlNode<T> remove(AvlNode<T> tree, AvlNode<T> del){
		if(tree == null || del == null){//合法性的判断
			return null;
		}
		
		int cmp = del.data.compareTo(tree.data);//判断要删除结点的值和根节点值的大小
		if(cmp < 0){//del在根结点的左子树上
			tree.left = remove(tree.left , del);
			//删除结点del后，要判断tree的高度是否平衡，不平衡要调整
			if(height(tree.right) - height(tree.left) == 2){//tree的left删除结点后，高度有可能小于right的高度，故是用tree.right-tree.left==2来判断
				AvlNode<T> temR = tree.right;
				if(height(temR.left) > height(temR.right)){//针对tree来说是RL
					tree = rightLeftRotate(tree);
				}else{
					tree = rightRightRotate(tree);
				}
				
			}
		}else if(cmp > 0){//要删除的结点在树根的右子树上
			tree.right = remove(tree.right, del);
			//删除结点del后，要判断tree的高度是否平衡，不平衡要调整
			if(height(tree.left) - height(tree.right) == 2){//tree的right删除结点后，高度有可能是left大于right，若是则调整
				AvlNode<T> temL = tree.left;//要调整的是左子树
				if(height(temL.right) > height(temL.left)){//LR
					tree = leftRightRotate(tree);
				}else{
					tree = leftLeftRotate(tree);
				}
			}
		}else{//tree是对应要删除的结点
			//1.tree的左右子树都为非空
			if(tree.left != null && tree.right != null){
				if(height(tree.left) > height(tree.right)){
					AvlNode<T> max = maxNode(tree.left);//找出左子树的最大值
					tree.data = max.data;
					tree.left = remove(tree.left, max);
				}else{
					AvlNode<T> min = minNode(tree.right);//找出右子树的最小值替换tree
					tree.data = min.data;
					tree.right = remove(tree.right, min);
				}
			}else{
				AvlNode<T> temp = tree;
				tree = (tree.left != null) ? tree.left : tree.right;
				temp = null;
			}
		}
		return tree;
	}
	
	//删除tree中值为key的结点
	public void remove(AvlNode<T> tree, T key){
		AvlNode<T> temp;
		
		if((temp = search(tree, key)) != null){
			tree = remove(tree, temp);
		}
	}
	
	/*
	 * 非递归实现查找tree中的key值
	 * */
	public AvlNode<T> search(AvlNode<T> tree, T key){
		if(tree == null){
			return null;
		}
		
		while(tree != null){
			int cmp = key.compareTo(tree.data);
			
			if(cmp < 0){//在tree的左子树上
				tree = tree.left;
			}else if(cmp > 0){//在tree的右子树上
				tree = tree.right;
			}else{
				return tree;
			}
		}
		return null;
	}
	
	
	//寻找最大节点
	public AvlNode<T> maxNode(AvlNode<T> tree){
		if(tree == null){
			return null;
		}
		while(tree.right != null){
			tree = tree.right;
		}
		return tree;
	}
	//最大节点的value值
	public T maxValue(AvlNode<T> tree){
		AvlNode<T> p = maxNode(tree);
		if(p != null){
			return p.data;
		}
		return null;
	}
	
	//寻找最小结点
	public AvlNode<T> minNode(AvlNode tree){
		if(tree == null){
			return null;
		}
		while(tree.left != null){
			tree = tree.left;
		}
		return tree;
	}
	//最小结点的value值
	public T minValue(AvlNode<T> tree){
		AvlNode<T> p = minNode(tree);
		if(p != null){
			return p.data;
		}
		return null;
	}
	
	//前序遍历Avl树---“根--左--右”
	public void preOrder(AvlNode<T> tree){
		if(tree != null){
			System.out.print(tree.data + ",");
			preOrder(tree.left);
			preOrder(tree.right);
		}		
	}
	
	//中序遍历Avl树---“左--根--右”
	public void inOrder(AvlNode<T> tree){
		if(tree != null){
			inOrder(tree.left);
			System.out.print(tree.data + ",");
			inOrder(tree.right);
		}
	}
	
	//后序遍历Avl树---“左--右--根”
	public void postOrder(AvlNode<T> tree){
		if(tree != null){
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.data + ",");
		}
	}	
}


