/**
 * This class is the blueprint for a Node in a @BinaryTree
 * @author Daniel Le
 *
 */
class BinaryNode {
	/**
	 * @data is the data of the node
	 * @leftChild is the left child of the node
	 * @rightChild is the right child of the node
	 */
	private int data;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	//constructors
	/**
	 * default constructor
	 */
	public BinaryNode(){
		this(0,null,null);
	}
	/**
	 * This constructor takes in data for the node
	 * @param newData is the data to be taken in
	 */
	public BinaryNode(int newData){
		this(newData,null,null);
	}
	/**
	 * This constructor takes in data, and a right and left child for the node
	 * @param newData is the data
	 * @param newLeft is the left child
	 * @param newRight is the right child
	 */
	public BinaryNode(int newData, BinaryNode newLeft, BinaryNode newRight){
		data = newData;
		leftChild = newLeft;
		rightChild = newRight;
	}
	//set and get methods
	/**
	 * This function sets the node's data
	 * @param newData is the data
	 */
	public void setData(int newData){
		data = newData;
	}
	/**
	 * This function sets the node's left child
	 * @param newLeft is the left child
	 */
	public void setLeftChild(BinaryNode newLeft){
		leftChild = newLeft;
	}
	/**
	 * This function sets the node's right child
	 * @param newRight is the right child
	 */
	public void setRightChild(BinaryNode newRight){
		rightChild = newRight;
	}
	/**
	 * This function returns the node's data
	 * @return data of the node
	 */
	public int getData(){
		return data;
	}
	/**
	 * This function returns the node's left child
	 * @return the left child node
	 */
	public BinaryNode getLeftChild(){
		return leftChild;
	}
	/**
	 * This function returns the node's right child
	 * @return the right child node
	 */
	public BinaryNode getRightChild(){
		return rightChild;
	}
	//boolean methods
	/**
	 * This function tells whether the node has a left child
	 * @return true if the node has a left child
	 */
	public boolean hasLeftChild(){
		return leftChild != null;
	}
	/**
	 * This function tells whether the node has a right child
	 * @return true if the node has a right child
	 */
	public boolean hasRightChild(){
		return rightChild != null;
	}
	/**
	 * This function checks if the node is a leaf
	 * @return true if the node has no left or right children
	 */
	public boolean isLeaf(){
		return (leftChild == null) && (rightChild == null);
	}
	//traversals
	/**
	 * This function calls another function to traverse all of the node in pre-order
	 */
	public void preorderTraverse(){
		preorderTraverse(this);
	}
	/**
	 * This function traverses a node and its descendants in pre-order
	 * @param node is the node to be traversed
	 */
	public void preorderTraverse(BinaryNode node){
		if(node!=null){
			System.out.print(node.getData()+" ");
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		}
	}
	/**
	 * This function calls another function to traverse all of the node in in-order
	 */
	public void inorderTraverse(){
		inorderTraverse(this);
	}
	/**
	 * This function traverses a node and its descendants in in-order
	 * @param node is the node to be traversed
	 */
	public void inorderTraverse(BinaryNode node){
		if(node!=null){
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData()+" ");
			inorderTraverse(node.getRightChild());
		}
	}
	/**
	 * This function calls another function to traverse all of the node in post-order
	 */
	public void postorderTraverse(){
		postorderTraverse(this);
	}
	/**
	 * This function traverses a node and its descendants in post-order
	 * @param node is the node to be traversed
	 */
	public void postorderTraverse(BinaryNode node){
		if(node!=null){
			postorderTraverse(node.getLeftChild());
			postorderTraverse(node.getRightChild());
			System.out.print(node.getData()+" ");
		}
	}
	//other methods
	/**
	 * This function makes a copy of the node and returns it
	 * @return a copy of the node
	 */
	public BinaryNode copy(){
		BinaryNode newNode = new BinaryNode(data);
		if(leftChild!=null)
			newNode.setLeftChild(leftChild.copy());
		if(rightChild!=null)
			newNode.setRightChild(rightChild.copy());
		return newNode;
	}
	/**
	 * This function calls a function to return the height of the node
	 * @return an integer of the height
	 */
	public int getHeight(){
		return getHeight(this);
	}
	/**
	 * This functions returns the height of a node
	 * @param node to find the height of
	 * @return the height of the node as an integer
	 */
	public int getHeight(BinaryNode node){
		int height = 0;
		if(node!=null){
			height = 1 + Math.max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()));
		}
		return height;
	}
	/**
	 * This function calls a function find the number of nodes and a node and its descendants
	 * @return an integer of the number of nodes
	 */
	public int numberOfNodes(){
		return numberOfNodes(this);
	}
	/**
	 * This function calls a function find the number of nodes and a node and its descendants
	 * @param node is the node
	 * @return an integer of the number of nodes
	 */
	public int numberOfNodes(BinaryNode node){
		int leftNum = 0;
		int rightNum = 0;
		if(node!=null){
			if(node.hasLeftChild())
				leftNum = leftChild.numberOfNodes();
			if(node.hasRightChild())
				rightNum = rightChild.numberOfNodes();
		}
		return 1 + leftNum + rightNum;
	}
	/**
	 * This functions returns the data of the node's leftmost data
	 * @return data of leftmost data as integer
	 */
	public int getLeftmostData(){
		if(leftChild==null)
			return data;
		else
			return leftChild.getLeftmostData();
	}
	/**
	 * This functions returns the data of the node's rightmost data
	 * @return data of rightmost data as integer
	 */
	public int getRightmostData(){
		if(rightChild==null)
			return data;
		else
			return rightChild.getRightmostData();
	}
	/**
	 * This functions returns the node's leftmost node
	 * @return leftmost node
	 */
	public BinaryNode getLeftmostNode(){
		if(leftChild==null)
			return this;
		else
			return leftChild.getLeftmostNode();
	}
	/**
	 * This functions returns the node's rightmost node
	 * @return rightmost node
	 */
	public BinaryNode getRightmostNode(){
		if(rightChild==null)
			return this;
		else
			return rightChild.getRightmostNode();
	}
	/**
	 * This functions removes the node's leftmost node
	 * @return right child node is no left child, null if no children, or left tree with leftmost node removed
	 */
	public BinaryNode removeLeftmost(){
		if(leftChild==null)
			return rightChild;
		else{
			leftChild = leftChild.removeLeftmost();
			return this;
		}
	}
	/**
	 * This functions removes the node's rightmost node
	 * @return left child node is no right child, null if no children, or right tree with rightmost node removed
	 */
	public BinaryNode removeRightmost(){
		if(rightChild==null)
			return leftChild;
		else{
			rightChild = rightChild.removeRightmost();
			return this;
		}
	}
}