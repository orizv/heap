/**
 * Created by user on 09/06/2016.
 */
public class BSTNode extends Node {

    private int _sum;
    private int _size;

    public BSTNode(){
        super();
        _sum=0;
        _size=0;
    }
    public BSTNode(BSTNode left, BSTNode right, Point p){
        super (left,right,p);
        this._sum=left.getSum()+right.getSum()+p.getY();
        this._size=left.getSize()+right.getSize()+1;
    }
    public BSTNode(Point p){
        super(p);
        _sum=p.getY();
        _size=1;
    }

    public int getSize(){return _size;}
    public int getSum(){return _sum;}
    public void setLeft(BSTNode n){super.setLeft(n);}
    public void setRight(BSTNode n){super.setRight(n);}
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
}