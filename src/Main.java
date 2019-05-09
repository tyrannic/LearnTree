public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BinTree binTree=new BinTree();
        Integer a[]={1,2,3,4,5,6,7,8};
        binTree.createTree(a);
        binTree.preOrder(binTree.getRoot());
        System.out.println();
        binTree.inOrder(binTree.getRoot());
        System.out.println();
        binTree.afterOrder(binTree.getRoot());
        System.out.println();
        binTree.preOrder2(binTree.getRoot());
        System.out.println();
        binTree.inOrder2(binTree.getRoot());
        System.out.println();
        binTree.afterOrder2(binTree.getRoot());
    }
}
