/**
 * 
 */
public class Node {
    /**
     * The data or value that the Node contains
     */
    int data;
    /**
     * Pointer to the left Node - which is smaller or equal to the parent
     */
    Node left;
    /**
     * Pointer to the right Node - which is greater than or equal to the parent
     */
    Node right;
    /**
     * Constructor that takes in data as a parameter and sets it to the
     * instance variable
     * @param data the int data that should be set
     */
    public Node(int data){
        super();
        this.data = data;
    }
}