/**
 * import Scanner and ArrayList classes to be used for getting input and storing the initial starting values
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class contains the 'main' function which runs the methods for the program.
 * The user can create a @BinaryTree and insert, delete, find predecessors, and find successors.
 * @author Daniel Le
 *
 */
public class BinarySearchTree{
	/**
	 * This member creates a @Scanner for general input throughout the class.
	 */
	private static Scanner kb;

	public static void main(String [] args){
		BinaryTree tree = addStartValues();
		preorderTraversal(tree);
		inorderTraversal(tree);
		postorderTraversal(tree);
		startMenu(tree);
	}
	/**
	 * This function contains the loop for the menu for the user to interact with the @BinaryTree.
	 * @param tree is the @BinaryTree being worked on
	 */
	private static void startMenu(BinaryTree tree){
		printMenu();
		boolean loop = true;
		kb = new Scanner(System.in);
		char input;
		while(loop){
			System.out.print("Command? ");
			input = kb.next().charAt(0);
			switch(input){
				case 'i':
				case 'I':
					if(tree.add(kb.nextInt()))
						inorderTraversal(tree);
					break;
				case 'd':
				case 'D':
					if(tree.searchForDelete(kb.nextInt()))
						inorderTraversal(tree);
					break;
				case 's':
				case 'S':
					tree.findSuccessor(tree.getRoot(), new BinaryNode(), kb.nextInt());
					break;
				case 'p':
				case 'P':
					tree.findPredecessor(tree.getRoot(), new BinaryNode(), kb.nextInt());
					break;
				case 'E':
				case 'e':
					loop = false;
					System.out.println("Thank you for using my program!");
					break;
				case 'h':
				case 'H':
					printMenu();
					break;
			}
		}
	}
	/**
	 * This function prints out the menu when called.
	 */
	private static void printMenu(){
		System.out.println("  I Insert a value\n"
						  +"  D Delete a value\n"
						  +"  P Find predecessor\n"
						  +"  S Find successor\n"
						  +"  E Exit the program\n"
						  +"  H Display this message");
	}
	/**
	 * This function gets user's input and allows user to interact with tree
	 * @return the @BinaryTree created from the starting values
	 */
	private static BinaryTree addStartValues(){
		System.out.println("Please enter the initial sequence of values: (separated by spaces)");
		kb = new Scanner(System.in);
		Scanner kbInt = new Scanner(kb.nextLine());
		
		ArrayList<Integer> startValues = new ArrayList<Integer>();
		boolean finishInput = false;
		
		do{
			if(kbInt.hasNextInt())
				startValues.add(kbInt.nextInt());
			else
				finishInput = true;
		}while(!finishInput);
		
		BinaryTree tree = new BinaryTree();
		for(int i=0;i<startValues.size();i++){
			tree.add(startValues.get(i));
		}
		
		kbInt.close();
		return tree;
	}
	/**
	 * This function calls the @BinaryTree to do a preorder traversal.
	 * @param tree is the @BinaryTree being used
	 */
	private static void preorderTraversal(BinaryTree tree){
		System.out.print("Pre-order: ");
		tree.preorderTraversal();
	}
	/**
	 * This function calls the @BinaryTree to do a inorder traversal.
	 * @param tree is the @BinaryTree being used
	 */
	private static void inorderTraversal(BinaryTree tree){
		System.out.print("In-order: ");
		tree.inorderTraversal();
	}
	/**
	 * This function calls the @BinaryTree to do a postorder traversal.
	 * @param tree is the @BinaryTree being used
	 */
	private static void postorderTraversal(BinaryTree tree){
		System.out.print("Post-order: ");
		tree.postorderTraversal();
	}
}