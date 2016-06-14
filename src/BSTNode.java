/**
 * Created by user on 09/06/2016.
 */
public class BSTNode extends Node {

    private int _sum;
    private int _size;
    private boolean _isLeaf;
    private BSTNode _parent;

    public BSTNode(){
        super();
        _sum=0;
        _size=0;
    }
    public BSTNode(BSTNode left, BSTNode right, Point p){
        super (left,right,p);
        this._sum=left.getSum()+right.getSum()+p.getY();
        this._size=left.getSize()+right.getSize()+1;
        _isLeaf=false;
    }
    public BSTNode(Point p){
        super(p);
        _sum=p.getY();
        _size=1;
        _parent=null;
    }

    public int getSize(){return _size;}
    public int getSum(){return _sum;}
    public void setLeft(BSTNode n){super.setLeft(n);_isLeaf=false;}
    public void setRight(BSTNode n){super.setRight(n);_isLeaf=false;}
    public void addToSize(int add){_size=_size+add;}
    public void descreseSize (int des){
        if (_size>des)
            _size=_size-des;
        else throw new RuntimeException("this is bulshit not enough nodes in the subtree");
    }
    public void addToSum(int add){_sum=_sum+add;}
    public void descreseSum (int des){
        if (_sum>des)
            _sum=_sum-des;
        else throw new RuntimeException("this is bullshit the sum isnt big enough");
    }
    public void setSum(int sum){_sum=sum;}
    public void setSize(int size){_size=size;}
    public int compareToPoint (Point p){
        if (this.getPoint().getX()>p.getX()){return 1;}
        else if (this.getPoint().getX()<p.getX()){return -1;}
        else return 0;
    }
    public void makeLeaf(boolean t){_isLeaf=t;}
    public void setParent(BSTNode p){_parent=p;}
    public BSTNode getParent(){return _parent;}
    public boolean isLeaf(){return _isLeaf;}
    public void setPoint(Point p){this._point=p;}

    public String toString(){
        return _point.getX()+" "+_point.getY()+" size="+_size;
    }
}