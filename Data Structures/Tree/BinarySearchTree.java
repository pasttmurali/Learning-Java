class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

class BinarySearchTreeADT{
	Node root;
	
	BinarySearchTreeADT(){
		root=null;
		
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public Node insert(Node cNode,int data){
		if(cNode==null){
			cNode=new Node(data);
			//System.out.println("1");
			return cNode;
		}
		
		if(data<cNode.data){
			cNode.left=insert(cNode.left,data);
			//System.out.println("2");
		}else if(data>cNode.data){
			cNode.right=insert(cNode.right,data);
			//System.out.println("3");
		}
		//System.out.println("4");
		return cNode;
	}
	
	public void innorderTraversal(Node cNode){
		if(cNode!=null){
			innorderTraversal(cNode.left);
			System.out.print(cNode.data+" ");
			innorderTraversal(cNode.right);
		}
	}
	
	public void preorderTraversal(Node cNode){
		if(cNode!=null){
			System.out.print(cNode.data+" ");
			preorderTraversal(cNode.left);	
			preorderTraversal(cNode.right);
		}
	}
	
	public void postorderTraversal(Node cNode){
		if(cNode!=null){
			postorderTraversal(cNode.left);
			postorderTraversal(cNode.right);
			System.out.print(cNode.data+" ");
		}
	}
	
	public boolean search(Node cNode, int data) {
		if (cNode == null) {
			return false;
		}

		if (data == cNode.data) {
			return true;
		} 
		else if (data < cNode.data) {
			return search(cNode.left, data);
		} 
		else {
			return search(cNode.right, data);
		}
	}

	
	public int findMin(Node cNode) {
		if (cNode == null) {
			return -1;
		}

		if (cNode.left == null) {
			return cNode.data;
		}

		return findMin(cNode.left);
	}
	
	public int findMax(Node cNode) {
		if (cNode == null) {
			return -1; 
		}

		if (cNode.right == null) {
			return cNode.data;
		}

		return findMax(cNode.right);
	}
	
	public Node delete(Node cNode,int data){
		if(cNode==null){
			return cNode;
		}
		
		if(data < cNode.data) {
			cNode.left=delete(cNode.left,data);
		} 
		else if(data>cNode.data){
			cNode.right=delete(cNode.right,data);
		}else{
			if(cNode.left==null && cNode.right==null){
				cNode=null;
			}else if(cNode.right==null){
				cNode=cNode.right;
			}else if(cNode.left==null){
				cNode=cNode.left;
			}else{
				int minValue=findMin(cNode.right);
				cNode.data=minValue;
				cNode.right=delete(cNode.right,minValue);
			}
		}
		return cNode;
	}
	
}

public class BinarySearchTree{
	public static void main(String args[]){
		BinarySearchTreeADT b1=new BinarySearchTreeADT();
		
		//System.out.println("first insertion");
		b1.root=b1.insert(b1.root,50);
		//System.out.println("2nd insertion");
		b1.root=b1.insert(b1.root,30);
		//System.out.println("3nd insertion");
		b1.root=b1.insert(b1.root,70);
		//System.out.println("4nd insertion");
		b1.root=b1.insert(b1.root,20);
		//System.out.println("4nd insertion");
		b1.root=b1.insert(b1.root,40);
		b1.root=b1.insert(b1.root,60);
		b1.root=b1.insert(b1.root,80);
		
		b1.innorderTraversal(b1.root);
		System.out.println("");
		System.out.println("Search element 100: "+b1.search(b1.root,100));
		System.out.println("Search element 60: "+b1.search(b1.root,60));
		System.out.println("Max element of tree: "+b1.findMax(b1.root));	
		System.out.println("Min element of tree: "+b1.findMin(b1.root));
		System.out.println("Delete 50 after replaced by: "+b1.delete(b1.root,50).data);
		
		b1.innorderTraversal(b1.root);
		System.out.println("");
	}
}