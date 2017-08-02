/**
 * This class is the skeleton for a Binary Tree.
 * The Binary Tree only contains one private member which is its root.
 * The class also contains multiple constructors, a getRoot method, and methods for add, delete, traversals,
 * and finding successors and predecessors, along with other useful functions.
 * @author Daniel Le
 *
 */
class BinaryTree {
	/**
	 * This member is the root node of the tree.
	 */
	private BinaryNode root;
	
	/**
	 * This method returns the root member
	 * @return root of the tree
	 */
	public BinaryNode getRoot(){
		return root;
	}
	//constructors
	/**
	 * This is the default constructor.
	 */
	public BinaryTree(){
		root = null;
	}
	/**
	 * This constructor takes in data to be used for its root.
	 */
	public BinaryTree(int rootData){
		root = new BinaryNode(rootData);
	}
	//etc
	/**
	 * This function checks if the tree is empty.
	 * @return true if tree is empty, or else false.
	 */
	private boolean isEmpty(){
		return root==null;
	}
	//add,remove
	/**
	 * This function calls a another function which adds a node into the tree 
	 * @param data is the data being added into the tree
	 * @return true if data is added, or else false
	 */
	public boolean add(int data){
		if(isEmpty()){
			root = new BinaryNode(data);
			return true;
		}
		else{
			BinaryNode node = root;
			return add(node,data);
		}
	}
	/**
	 * This function adds a node with data into a tree.
	 * @param node is the root node of the tree
	 * @param data is the data of the node being added to the tree
	 * @return true if data is added, or else false
	 */
	private boolean add(BinaryNode node, int data){
		if(data > node.getData()){
			if(node.hasRightChild()){
				return add(node.getRightChild(), data);
			}
			else{
				node.setRightChild(new BinaryNode(data));
			}
		}
		else if(data < node.getData()){
			if(node.hasLeftChild()){
				return add(node.getLeftChild(),data);
			}
			else{
				node.setLeftChild(new BinaryNode(data));
			}
		}
		else{
			System.out.println(data+" already exists, ignore.");
			return false;
		}
		return true;
	}
	/**
	 * This function calls another function which searches for a node to delete
	 * from the tree and then updates the original tree. The old number of nodes is saved to compare
	 * to the new number of nodes to return a boolean value.
	 * @param data is the data of the node being searched for
	 * @return whether number of nodes in root has changed
	 */
	public boolean searchForDelete(int data){
		int oldHeight = root.numberOfNodes();
		root = searchForDelete(root,data);
		return oldHeight!=root.numberOfNodes();
	}
	/**
	 * This function searches for a node from the tree with root 'node'.
	 * If a node with the data doesn't exist, a message is printed out.
	 * @param node is an instance of the root of the tree
	 * @param data is the data of the node being searched for
	 * @param change is the boolean value that shows whether a node has been deleted
	 * @return the instance of the root of the tree that the node is deleted from
	 */
	private BinaryNode searchForDelete(BinaryNode node, int data){
		if(node!=null){
			if(data == node.getData()){
				node = delete(node);
			}
			else if(data < node.getData()){
				BinaryNode newLeft = node.getLeftChild();
				node.setLeftChild(searchForDelete(newLeft, data));
			}
			else{
				BinaryNode newRight = node.getRightChild();
				node.setRightChild(searchForDelete(newRight, data));
			}
		}
		else{
			System.out.println(data+" doesn't exist!");
		}
		return node;
	}
	/**
	 * This function deletes a node from the tree with root 'node'.
	 * @param node is the node being deleted from the tree
	 * @return parent node of the node being deleted
	 */
	private BinaryNode delete(BinaryNode node){
		if(node.isLeaf()){
			node = null;
		}
		else{
			if(node.hasLeftChild() && node.hasRightChild()){
				BinaryNode leftTree = node.getLeftChild();
				BinaryNode largestNode = leftTree.getRightmostNode();
				node.setData(largestNode.getData());
				node.setLeftChild(leftTree.removeRightmost());
			}
			else if(node.hasRightChild()){
				node = node.getRightChild();
			}
			else{
				node = node.getLeftChild();
			}
		}
		return node;
	}
	//traversals
	/**
	 * This function calls the preorderTraverse function of the node
	 */
	public void preorderTraversal(){
		if(root!=null){
			root.preorderTraverse();
		}
		System.out.println();
	}
	/**
	 * This function calls the inorderTraverse function of the node
	 */
	public void inorderTraversal(){
		if(root!=null){
			root.inorderTraverse();
		}
		System.out.println();
	}
	/**
	 * This function calls the postorderTraverse function of the node
	 */
	public void postorderTraversal(){
		if(root!=null){
			root.postorderTraverse();
		}
		System.out.println();
	}
	//successor predecessor
	/**
	 * This function finds a successor of a node in the tree and outputs the successor's data.
	 * If the successor is not found, a message is output to the screen.
	 * @param node is the root node of the tree
	 * @param successor is a possible parent successor node
	 * @param data is the data whose successor is being searched for
	 */
	public void findSuccessor(BinaryNode node, BinaryNode successor, int data){
		if(node!=null){
			if(data == node.getData()){
				if(node.hasRightChild()){
					System.out.println(node.getRightChild().getLeftmostData());
				}
				else{
					if(node.getData()!=root.getRightmostData()){
						System.out.println(successor.getData());
					}
					else{
						System.out.println("No Successor.");
					}
				}
			}
			else if(data < node.getData()){
				successor = node;
				if(node.hasLeftChild()){
					findSuccessor(node.getLeftChild(), successor, data);
				}
				else{
					System.out.println(data+" doesn't exist!");
				}
			}
			else{//data > node.getData()
				if(node.hasRightChild()){
					findSuccessor(node.getRightChild(), successor, data);
				}
				else{
					System.out.println(data+" doesn't exist!");
				}
			}
		}
	}
	/**
	 * This function finds a predecessor of a node in the tree and outputs the predecessor's data.
	 * If the predecessor is not found, a message is output to the screen.
	 * @param node is the root node of the tree
	 * @param predecessor is a possible parent predecessor node
	 * @param data is the data whose predecessor is being searched for
	 */
	public void findPredecessor(BinaryNode node, BinaryNode predecessor, int data){
		if(node!=null){
			if(data == node.getData()){
				if(node.hasLeftChild()){
					System.out.println(node.getLeftChild().getRightmostData());
				}
				else{
					if(node.getData()!=root.getLeftmostData()){
						System.out.println(predecessor.getData());
					}
					else{
						System.out.println("No Predecessor.");
					}
				}
			}
			else if(data < node.getData()){
				if(node.hasLeftChild()){
					findPredecessor(node.getLeftChild(), predecessor, data);
				}
				else{
					System.out.println(data+" doesn't exist!");
				}
			}
			else{//data > node.getData()
				predecessor = node;
				if(node.hasRightChild()){
					findPredecessor(node.getRightChild(), predecessor, data);
				}
				else{
					System.out.println(data+" doesn't exist!");
				}
			}
		}
	}
}