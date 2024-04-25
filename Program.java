public class Program {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.Insert(8);
        bst.Insert(20);
        bst.Insert(1);
        bst.Insert(5);
        bst.Insert(80);
        bst.Insert(27);
        bst.Insert(13);
        bst.Insert(50);
        bst.Insert(1);
        bst.Display();
        bst.Insert(9);
        bst.Delete((3));
        bst.Display();
        System.out.println("count #" + bst.countNumberOfNodes());
        System.out.println("5 " + bst.Search(5));
        System.out.println("0 " + bst.Search(0));
        System.out.println(bst.CountNumberOfLeaves());
    }
}
