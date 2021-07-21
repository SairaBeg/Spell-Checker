package Assignment4;



public class BinaryT<Type extends Comparable<Type>> {
    // a class for one node of the tree
    private class Node {
        public Type data;
        public Node left;
        public Node right;

        // initialize the node with the given value
        public Node(Type data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // reference to the root node of the tree
    private Node root;
    
    // set the whole tree to null
    public BinaryT() {
        root = null;
    }

    // perform inorder traversal on the tree
    private void inorderPrint(Node node) {
        if (node != null) {
            inorderPrint(node.left);
            System.out.print(node.data + " ");
            inorderPrint(node.right);
        }
    }
    
    // print the entire tree
    public void print() {
        inorderPrint(root);
        System.out.println();
    }

    // recursive function to insert at a particular node
    private Node insertAt(Type value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (node.data.compareTo(value) < 0) {
            // right
            node.right = insertAt(value, node.right);
        } else {
            // left
            node.left = insertAt(value, node.left);
        }

        return node;
    }
    
    // insert a number calls recursive function to insert at the root
    public void insert(Type value) {
        root = insertAt(value, root);
    }
    
    // perform the recursive search at a given node
    private Node searchAt(Type target, Node node) {
        if (node == null) {
            return null;
        } else if (node.data.equals(target)) {
            return node;
        } else if (node.data.compareTo(target) < 0) {
            return searchAt(target, node.right);
        } else { 
            return searchAt(target, node.left); 
        } 
    }

    // search for a value and return it, or null if not found
    public Type search(Type target) {
        Node node = searchAt(target, root);
        if (node == null) {
            return null;
        } else {
            return node.data;
        } 
    }

    // find the smallest node value in a subtree
    private Node min(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    // recursively search for a value and remove it when found
    private Node removeAt(Type value, Node node) {
        if (node == null) {
            return null;
        } else if (node.data.compareTo(value) > 0) {
            node.left = removeAt(value, node.left);
        } else if (node.data.compareTo(value) < 0) {
            node.right = removeAt(value, node.right);
        } else {
            // zero children, return null
            if (node.left == null && node.right == null) {
                return null;
            }
            // one child, return that one child
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // two children, swap nodes, and recurse
            else {
                // find smallest node in right subtree
                Node swap = min(node.right);

                // put node's data into this one
                node.data = swap.data;

                // delete that node instead
                node.right = removeAt(swap.data, node.right);
            }
        }
        return node;
    }

    // remove a given value from the tree
    public void remove(Type value) {
        root = removeAt(value, root);
    }
 //calls recursive method on root node
    public int count() {
    	return counting(root);
    	
    }
    
//recursive method
    private int counting(Node node) {
    	
    	if (node == null) {
    	int	count = 0;
    		return count;
    	}else {
    		return 1+ counting(node.left)+ counting(node.right);
    	}
    	
    }
    
    public int height() {
    	return displayHeight(root);
    	
    }
    private int displayHeight(Node node) {
    	if(node == null) {
    		int height = 0; 
    		return height;
    	}else {
    		  return 1 + Math.max(displayHeight(node.left), displayHeight(node.right));
    	}
    	
    }
}