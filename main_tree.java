public class main_tree{


	public static class Node
	{
		int data;
		Node left;
		Node right;

		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	
	}


	public Node root;


	public main_tree()
	{
		root = null;
	}

	public void insert(int data)
	{
		Node newNode = new Node(data);

		//Check if tree is empty
		if(root == null)
		{
			root = newNode;
			return;
		}

		else
		{
			Node current = root;
			Node parent = null;

			while(true)
			{
				parent = current;

				//If data < current, node will be inserted on left
				if(data < current.data)
				{
					current = current.left;

					if(current == null)
					{
						parent.left = newNode;
						return;
					}
				}

				else
				{
					current = current.right;

					if(current == null)
					{
						parent.right = newNode;

						return;
					}
				}
			}

		}
	}

	//returns the minimum node of the tree
	public Node minNode(Node root)
	{
		if(root.left != null)
		{
			return minNode(root.left);
		}
		else
		{
			return root;
		}
	}

	public Node deleteNode(Node node, int value)
	{
		if(node == null)
		{
			System.out.println("\ninteger "+value+" NOT found - NOT deleted");
			return null;
		}

		else
		{
			//Value is less than nodes data, search value in left subtree
			if(value < node.data)
			{
				node.left = deleteNode(node.left, value);
			}

			//Value is greater than nodes data, search value in right subtree
			else if(value > node.data)
			{
				node.right = deleteNode(node.right, value);
			}

			//Value is equal to nodes data, node to be deleted found
			else
			{
				//if node has no children, set node to null
				if(node.left == null && node.right == null)
				{
					node = null;
				}

				//if node has only one right child
				else if(node.left == null)
				{
					node = node.right;
				}

				//if node has only one left child
				else if(node.right == null)
				{
					node = node.left;
				}

				//if node has two children
				else
				{
					//find min node from right subtree
					Node temp = minNode(node.right);

					//Exchange the data between node and temp
					node.data = temp.data;

					//delete the node duplicate node from right subtree
					node.right = deleteNode(node.right, temp.data);
				}
			}

			return node;
		}
	}

	public void print_tree(Node node)
	{
		//check if tree is empty
		if(node == null)
		{
			System.out.println("TREE IS EMPTY, FEED ME");
			return;
		}

		else
		{
			/*recursively traverse through the tree
			and print each node we pass through
			until there are no more nodes in the tree*/
			if(node.left != null)
			{
				print_tree(node.left);
			}

			System.out.print(node.data + " ");

			if(node.right != null)
			{
				print_tree(node.right);
			}

		}
	}

	public Node search_tree(Node node, int target)
	{
		//if tree is empty/target not found
		if(node == null)
		{
			System.out.println("\ninterger "+target+" NOT found");
			return null;
		}

		else
		{
			/*find out if the target is larger than the current node
			then branch off accordingly by recursively moving through
			the tree. If the target matches the current node 
			then its been found */
			if(target < node.data)
			{
				node.left = search_tree(node.left, target);
			}

			else if(target > node.data)
			{
				node.right = search_tree(node.right, target);
			}

			else
			{
				System.out.println("\ninteger "+target+" FOUND");

			}

			return node;
		}
	}

	public int countChildren(Node root)
	{
		//if tree is empty return 0, no children

		if(root == null) return 0;

		/*counter to keep track of children, since we are splitting the tree into
		the left and right branch and counting seperately, we call the function twice.
		Once for the node directly to the left of the root (root.left) 
		and once for the right (root.right)
		We start the counter at 1 because the "root" we are originally passing is actually
		a child of the actual root */

		int counter = 1; 
		
		/*recursively call the function and add to counter 
		each time there is a child on the left or right 
		of the current root*/
		counter += ((root.left == null) ? 0 : countChildren(root.left)) + ((root.right == null) ? 0 : countChildren(root.right));

		return counter;
	}

	public int getDepth(Node root)
	{
		//tree is empty return 0
		if(root == null) return 0;

		//Recursively call to get the depth from the right and left subtrees
		else
		{
			int tree_DepthL = getDepth(root.left);
			int tree_DepthR = getDepth(root.right);

			//Return the largest depth between both subtrees (right and left)
			// add 1 for the level of the current node
			return ((tree_DepthL > tree_DepthR) ? (tree_DepthL + 1) : (tree_DepthR + 1));
		}
		


	}

	public void complexityIndicator()
	{
		System.out.println("696969;2.5;10");
	}


	public static void main(String[] args){

		main_tree bt = new main_tree();
		int count_Children, count_Depth;

		//adding nodes..
		bt.insert(888);

		bt.insert(77);

		bt.insert(90);

		bt.insert(990);

		bt.insert(120);

		bt.insert(450);

		bt.insert(7900);

		bt.insert(7000);

		bt.insert(500);

		bt.insert(65);

		System.out.println("Binary search tree after insertion:");

		//Display the binary tree
		bt.print_tree(bt.root);

		//Count children on left..

		count_Children = bt.countChildren(bt.root.left);
	
		System.out.println("\nleft children:\t"+count_Children);

		//Get depth of left subtree..
		
		count_Depth = bt.getDepth(bt.root.left);

		System.out.println("left depth:\t"+count_Depth);

		//Count children on right..

		count_Children = bt.countChildren(bt.root.right);

		System.out.println("right children:\t"+count_Children);

		//Get depth of right subtree..


		count_Depth = bt.getDepth(bt.root.right);

		System.out.println("right depth:\t"+count_Depth);

		bt.complexityIndicator();




	}

}
