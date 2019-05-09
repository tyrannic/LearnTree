import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTree {
    private BinTree leftChild;
    private BinTree rightChild;
    private BinTree root;
    private Object data;
    private List<BinTree> datas;

    public BinTree(BinTree leftChild, BinTree rightChild, Object data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
    public BinTree(Object data){
        this(null,null,data);
    }

    public BinTree() {
    }
    public void createTree(Object[] objects){
        datas=new ArrayList<BinTree>();
        for(Object object:objects){
            datas.add(new BinTree(object));
        }
        root=datas.get(0);
        for(int i=0;i<objects.length/2;i++){
            datas.get(i).leftChild=datas.get(i*2+1);
            if(i*2+2<objects.length){
                datas.get(i).rightChild=datas.get(i*2+2);
            }
        }
    }
    public void preOrder(BinTree root){
        if(root!=null){
            visit(root.getData());
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void preOrder2(BinTree root){
        Stack<BinTree> stack=new Stack<BinTree>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                visit(root.getData());
                stack.push(root);
                root=root.leftChild;
            }
            else {
                root=stack.pop();
                root=root.rightChild;
            }
        }

    }

    public void inOrder(BinTree root){
        if(root!=null){
            inOrder(root.leftChild);
            visit(root.getData());
            inOrder(root.rightChild);
        }
    }

    public void inOrder2(BinTree root){
        Stack<BinTree> stack=new Stack<BinTree>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.leftChild;
            }
            else{
                root=stack.pop();
                visit(root.getData());
                root=root.rightChild;

            }
        }
    }
    public void afterOrder(BinTree root){
        if(root!=null){
            afterOrder(root.leftChild);
            afterOrder(root.rightChild);
            visit(root.getData());
        }
    }

    public void afterOrder2(BinTree root){
        int left=1;
        int right=2;
        Stack<BinTree> stack=new Stack<BinTree>();
        Stack<Integer> stack1=new Stack<Integer>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                stack1.push(left);
                root=root.leftChild;
            }
            else {
                if(stack1.peek()==right){
                    stack1.pop();
                    visit(stack.pop().getData());
                }
                else if(stack1.peek()==left){
                    stack1.pop();
                    stack1.push(right);
                    root=stack.peek().rightChild;
                }
            }
        }
    }

    public void visit(Object obj){
        System.out.print(obj+" ");
    }

    public BinTree getRoot() {
        return root;
    }

    public void setRoot(BinTree root) {
        this.root = root;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
