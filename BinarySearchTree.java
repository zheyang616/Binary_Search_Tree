public class BinarySearchTree {

    private Node root;

    public void Insert(int data){
        Node newNode = new Node(data);
        root = RecursiveInsert(root, newNode);
    }

    private Node RecursiveInsert(Node root, Node newNode){
        if(root == null){
            root = newNode;
            return root;
        }else if(newNode.data >= root.data){
            root.right = RecursiveInsert(root.right, newNode);
        }else{
            root.left = RecursiveInsert(root.left, newNode);
        }

        return root;
    }

    public void Display(){
        RecursiveDisplay(root);
        System.out.println();
    }

    private void RecursiveDisplay(Node root){
        if (root != null) {

            RecursiveDisplay(root.left);
            System.out.println(root.data + " ");
            RecursiveDisplay(root.right);
        }
        
    }

    public boolean Search(int data){
        Node currentRoot = root;

        // if (root == null) {//if our BST is empty
        //     return false;
        // }
        
        while(currentRoot != null){
            if (currentRoot.data == data) {
                return true;// we found out value
            }else if(data < currentRoot.data){
                currentRoot = currentRoot.left;
            }else{
                currentRoot = currentRoot.right;
            }
        }

        return false;
    }

    public void Delete(int data){
        RecursiveDelete(root, data);

    }

    public Node RecursiveDelete(Node root, int data){
        if (root == null) {
            return root;
            
        }else if(root.data == data){
            // we found our data - need to find our sccessor/predecessor
            if (root.left == null && root.right == null) {
                root = null;
            }else if (root.right != null) {
                root.data = FindSuccessor(root.right).data;
                root.right = RecursiveDelete(root.right, root.data);
            }else{
                root.data = FindPredecessor(root.right).data;
                root.right = RecursiveDelete(root.left, root.data);
            }
        }else if(data < root.data){
            root.left = RecursiveDelete(root.left, data);
        }else{
            root.right = RecursiveDelete(root.right, data);
        }
        return root;
    }

    // public void Delete(int data){
    //     Node parentNode = null;
    //     Node currentNode = root;

    //     if (!Search(data)) {
    //         System.out.println("Unable to delete node that doesn't exist");
    //         return;
    //     }

    //     while (currentNode != null) {
            
    //         if (currentNode.data == data) {
    //             //found the node we want to delete

    //             if (currentNode.left == null && currentNode.right == null) {
    //                 if (parentNode.left.data == currentNode.data) {
    //                     parentNode.left = null;
    //                 }else{
    //                     parentNode.right = null;
    //                 }
    //             }
    //             if (currentNode.right != null) {
                    
    //                 //we need to find the smallest node that we can use as a replacement
    //                 Node node = FindSuccessor(currentNode.right);

    //             }else{
                    
    //                 //we need to find the largest node that we can use as a replacement
    //                 Node node = FindPredecessor(currentNode.left);
    //             }

    //         }else if (data < currentNode.data) {
    //             //didn't find our value - need to head to the left
    //             parentNode = currentNode;
    //             currentNode = currentNode.left;
    //         }else{
    //             //didn't find our value - need to head to the right
    //             parentNode = currentNode;
    //             currentNode = currentNode.right;
    //         }
    //     }
    // }
    //left hand side - find the largest value available
    public Node FindPredecessor(Node root){
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }
    // right hand side - find the smallest value available
    public Node FindSuccessor(Node root){
        Node currentNode = root;
        while (currentNode != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public int countNumberOfNodes(){
        return RecursiveCountNumberOfNodes(root);
    }

    public int RecursiveCountNumberOfLeaves(Node root){
        if (root == null) {
            return 0;
        }
        return 1 + RecursiveCountNumberOfNodes(root.left) + RecursiveCountNumberOfNodes(root.right);
    }

    public int CountNumberOfLeaves(){
        return RecursiveCountNumberOfLeaves(root);
    }

    private int RecursiveCountNumberOfNodes(Node root){
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return RecursiveCountNumberOfLeaves(root.left) + RecursiveCountNumberOfLeaves(root.right);
    }
}
