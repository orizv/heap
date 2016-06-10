/**
 * Created by liorbass on 05/06/2016.
 */
public abstract class Heap {

    private int _size;

    protected Node[] _nodes;
    public Heap(int n){
        _size=0;
        _nodes=new Node[n+10*(int)Math.log(n)+1];
    }
    public Heap(Point[] parr){

        int n=parr.length;

        _nodes=new Node[n+10*(int)Math.log(n)+1];

        for (int i=0;i<parr.length;i++){
            insert(parr[i]);
        }
    }
    public int get_size(){return _size;}

    public void insert(Point p) {
        _nodes[_size]= new Node(p);
        heapify(_size);
        _size++;
    }
    public void insert(Node n){
        _nodes[_size]= n;
        if(_nodes[getParentInd(_size)].getLeft()==null) {
            _nodes[getParentInd(_size)].setLeft(n);
        }
        else{
            _nodes[getParentInd(_size)].setRight(n);
        }
        heapify(_size);
        _size++;
    }
    public abstract void heapify(int curr);


    public Node extract(){
        if(_size==0) return null;
        Node ans=_nodes[0];
        _size--;
        _nodes[0]=_nodes[_size];
        heapify(0);
        return ans;
    }

    public Node getTop(){
        if(_size==0)
            return null;
        return _nodes[0];
    }
    /**
     * switches the values in the point array of n1 and n2
     * @param n1 first index
     * @param n2 second index
     */
    protected void switchvals(int n1,int n2){
        //swtich val
        Node t=_nodes[n1];
        _nodes[n1]=_nodes[n2];
        _nodes[n2]=t;
        //switch sons
        t=_nodes[n1].getLeft();
        _nodes[n1].setLeft(_nodes[n2].getLeft());
        _nodes[n2].setLeft(t);
        t=_nodes[n1].getRight();
        _nodes[n1].setRight(_nodes[n2].getRight());
        _nodes[n2].setRight(t);
    }

    /**
     * returns the parent of given point
     * @param ind index of point to look for
     * @return index of the parrent of ind
     */
    protected int getParentInd(int ind){
        return ind/2;
    }

    /**
     * returns the right son of given point
     * @param ind index of point to look for
     * @return index of the right son of ind
     */
    protected int getRightInd(int ind){
        return ind*2+1;
    }

    /**
     * returns the left son of given point
     * @param ind index of point to look for
     * @return index of the left son of ind
     */
    protected int getLeftInd(int ind){
        return 2*ind;
    }

}
