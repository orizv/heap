/**
 * Created by liorbass on 14/06/2016.
 */
public class TempNode extends Node {
    Node left;
    Node right;

    public TempNode(Node n){
        super(n.getLeft(),n.getRight(),n.getPoint());
        this.left=n.getLeft();
        this.right=n.getRight();
    }
    public TempNode(TempNode n){
        super(n.getLeft(),n.getRight(),n.getPoint());
        this.left=n.getPrevLeft();
        this.right=n.getPrevRight();

    }
    public Node getPrevLeft(){
        return left;
    }
    public Node getPrevRight(){
        return  right;
    }
}
