/**
 * Created by liorbass on 07/06/2016.
 */
public class Node {

    protected Point _point;
    private Node _left;
    private Node _right;


    public Node(){
        _point=null;
        _left=null;
        _right=null;
    }

    public Node(Node left, Node right, Point p){
        this._point=p;
        this._left=left;
        this._right=right;
    }

    public Node(Point p){
        _point=p;
        _left=null;
        _right=null;
    }

    public Point getPoint(){return _point;}
    public Node getLeft(){return _left;}
    public Node getRight(){return _right;}
    public void setLeft(Node n){_left= n;}
    public void setRight(Node n){_right=n;}
    public String toString(){return _point.getX()+" "+ _point.getY();}

}
