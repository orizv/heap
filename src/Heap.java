/**
 * Created by liorbass on 05/06/2016.
 */
public abstract class Heap {

    private int _size;


    protected Node[] _nodes;

    /**
     * start an empty heap
     * @param n the size of the heap
     */
    public Heap(int n){
        _size=0;
        _nodes=new Node[n+10*(int)Math.log(n)+1];
    }

    /**
     * Make Heap from array
     * @param parr array of point to heap
     */
    public Heap(Point[] parr){

        int n=parr.length;
        _size=0;
        _nodes=new Node[n+10*(int)Math.log(n)+1];

        for (int i=0;i<parr.length;i++){
            if(parr[i]!=null) {
                _nodes[i+1] = new Node(parr[i]);
                _size++;
            }
        }
        for(int i=0;i<_size+1;i++){
            heapUp(i);
        }
        for(int i=1;i<=_size/2;i++){
            _nodes[i].setRight(_nodes[getRightInd(i)]);
            _nodes[i].setLeft(_nodes[getLeftInd(i)]);
        }
    }

    /**
     *
     * @return the number of elements in the heap
     */
    public int get_size(){return _size;}

    /**
     * insert a new point to the heap
     * @param p point to add
     */
    public void insert(Point p) {
        _size++;
        _nodes[_size]= new Node(p);
        heapUp(_size);
    }

    /**
     * insert new node to the heap
     * @param n node to add
     */
    public void insert(Node n){
        _size++;
        _nodes[_size]= n;
        if(_size>1) {
            if (_nodes[getParentInd(_size)].getLeft() == null) {
                _nodes[getParentInd(_size)].setLeft(n);
            } else {
                _nodes[getParentInd(_size)].setRight(n);
            }
            heapUp(_size);
        }
    }
    public abstract void heapUp(int ind);

    /**
     * heapify should be made by the selected implementetaion
     * @param curr
     */
    public abstract void heapify(int curr);


    /**
     * remove current top of the heap
     * @return node
     */
    public Node extract(){
        if(_size==0) return null;
        switchvals(1,_size);
        Node ans=_nodes[_size];
        _nodes[_size]=null;
        _size--;
        heapify(1);
        return ans;
    }

    /**
     * return current top of the node without removing it
     * @return  the top of the heap node
     */
    public Node getTop(){
        if(_size==0)
            return null;
        return _nodes[1];
    }
    /**
     * switches the values in the point array of n1 and n2
     * @param n1 first index
     * @param n2 second index
     */
    protected void switchvals(int n1,int n2){
        Point t= _nodes[n1].getPoint();
        _nodes[n1].set_point(_nodes[n2].getPoint());
        _nodes[n2].set_point(t);
//        Node t=_nodes[n1];
//        _nodes[n1]=_nodes[n2];
//        _nodes[n2]=t;
//
//        _nodes[n1].setLeft(_nodes[getLeftInd(n2)]);
//        _nodes[n1].setRight(_nodes[getRightInd(n2)]);
//        _nodes[n2].setLeft(_nodes[getLeftInd(n1)]);
//        _nodes[n2].setRight(_nodes[getRightInd(n1)]);
//        if(n1!=1){
//            t=_nodes[getParentInd(n1)].getLeft();
//            if(t==_nodes[n1]){
//                _nodes[getParentInd(n1)].setLeft(_nodes[n2]);
//            }
//            t=_nodes[getParentInd(n1)].getRight();
//            if(t==_nodes[n1]){
//                _nodes[getParentInd(n1)].setRight(_nodes[n2]);
//            }
//        }
//        if(n2!=1){
//            t=_nodes[getParentInd(n2)].getLeft();
//            if(t==_nodes[n2]){
//                _nodes[getParentInd(n2)].setLeft(_nodes[n1]);
//            }
//            t=_nodes[getParentInd(n2)].getRight();
//            if(t==_nodes[n1]){
//                _nodes[getParentInd(n2)].setRight(_nodes[n1]);
//            }
//        }
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

    protected boolean isLeaf(int ind){
        return (ind >= _size/2) && (_size > ind);
    }

}
