package 拓扑排序;
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;

public class TopSort {
	public static void main(String[] args) {
		//创建结点
		Node A = new Node("A");  
	    Node B = new Node("B");  
	    Node C = new Node("C");  
	    Node D = new Node("D");  
	    Node E = new Node("E");  
	    Node F = new Node("F");  
	    
	    //创建拓扑排序图，并将结点添加到拓扑排序图中
	    topGraph graph = new topGraph(); 
	    graph.addNode(A, B);  
	    graph.addNode(B, C);  
	    graph.addNode(B, D);  
	    graph.addNode(D, C);  
	    graph.addNode(E, C);  
	    graph.addNode(C, F);  
	    
	    //根据拓扑排序图graph，调用topsort方法来获取最后的拓扑排序序列
	    SubTopSort t = new SubTopSort(graph); 
	    t.topsort();
	    for(Node temp : t.getResult()){  
	        System.out.print(temp.value.toString() + ";"); 
	    }
	}
}

//定义拓扑排序的结点类
class Node{
	public Object value;//结点值
	public int inDegree;//入度
	
	public Node(Object val){
		this.value = val;
	}
}

//拓扑序列图
class topGraph{
	//图中结点的集合
	public Set<Node> vertexSet = new HashSet<Node>();
	//边的集合，用来记录相邻的边
	public Map<Node, Set<Node>> adj = new HashMap<Node,Set<Node>>();
	
	//向拓扑排序图中添加结点
	public boolean addNode(Node start, Node end){
		if(!vertexSet.contains(start)){//点集中不含start结点，则添加
			vertexSet.add(start);
		}
		if(!vertexSet.contains(end)){//点集中不含end结点，则添加
			vertexSet.add(end);
		}
		//adj邻接表中包含start和end结点时，不添加任何结点，返回值为false
		if(adj.containsKey(start) && adj.get(start).contains(end)){
			return false;
		}
		//当邻接表中包含start结点，但是不包含end结点是，要将end结点添加到邻接表中
		if(adj.containsKey(start)){
			adj.get(start).add(end);
		}else{//邻接表中不含start时，要形成一条边，并将边添加到adj中
			Set<Node> temp = new HashSet<Node>();
			temp.add(end);
			adj.put(start, temp);
		}
		end.inDegree++;
		return true;		
	}
}

class SubTopSort{//该类的方法返回一个拓扑排序的结果集result
	public List<Node> result;//存储拓扑排序的结果
	public Queue<Node> InDegreeIsZero;//拓扑排序结点中入度为0的结点要添加进去
	public topGraph graph;
	
	public SubTopSort(topGraph g){
		this.graph = g;
		this.result = new ArrayList<Node>();
		this.InDegreeIsZero = new LinkedList<Node>();
		
		for(Node iterator : this.graph.vertexSet){
			if(iterator.inDegree == 0){
				this.InDegreeIsZero.add(iterator);
			}
		}
	}
	
	public void topsort(){
		while(!InDegreeIsZero.isEmpty()){
			Node ver = InDegreeIsZero.poll();//队首元素
			result.add(ver);
			//判断结点ver的邻接表是否为空，如果为空则跳出
			if(this.graph.adj.keySet().isEmpty()){
				return;
			}
			
			//如果不为空，则遍历与之相邻的边
			for(Node v : this.graph.adj.get(ver)){
				//通过减少边数来删除该点
				v.inDegree--;
				if(v.inDegree == 0){
					InDegreeIsZero.add(v);
				}
			}
			this.graph.vertexSet.remove(ver);//点集中删除ver
			this.graph.adj.remove(ver);//边集中删除ver
		}
		if(!this.graph.vertexSet.isEmpty()){
			throw new IllegalArgumentException("存在环路");
		}
	}
	
	public Iterable<Node> getResult(){
		return result;
	}
}







