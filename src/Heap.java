/**
 * Created by liorbass on 05/06/2016.
 */
public abstract class Heap {

    private int _size;
    protected Point[] _parr;
    public Heap(int n){
        _size=0;
        _parr=new Point[n+10*(int)Math.log(2)];
    }
    public Heap(Point[] parr){
        int n=parr.length;
        _parr=new Point[n+10*(int)Math.log(n)+1];
        for (int i=0;i<parr.length;i++){
            insert(parr[i]);
        }
    }
    public int get_size(){return _size;}
    public void insert(Point p) {
        _parr[_size]=new Point(p);
        heapify(_size);
        _size++;
    }
    public abstract void heapify(int curr);

    public Point extract(){
        if(_size==0)
            return null;
        Point ans=_parr[0];
        _size--;
        _parr[0]=_parr[_size];
        heapify(0);
        return ans;
    }


    /**
     * switches the values in the point array of n1 and n2
     * @param n1 first index
     * @param n2 second index
     */
    protected void switchvals(int n1,int n2){
        Point temp=_parr[n1];
        _parr[n1]=_parr[n2];
        _parr[n2]=_parr[n1];
    }

    /**
     * returns the parrent of given point
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
