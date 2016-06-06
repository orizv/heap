/**
 * Created by liorbass on 05/06/2016.
 */
public abstract class Heap {

    private int _size;
    protected Point[] _parr;
    public Heap(Point[] parr){
        int n=parr.length;
        _parr=new Point[n+10*(int)Math.log(n)+1];
        for (int i=0;i<parr.length;i++){
            insert(parr[i]);
        }
    }
    public void insert(Point p) {
        _parr[_size]=new Point(p);
        heapify(_size);
        _size++;
    }
    public abstract void heapify(int curr);

    public Point extract(){
        return new Point(_parr[0]);
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
     * returns the index of given point in the point array
     * @param p point to look for
     * @return the index of the given point, or -1 if isn't in the array
     */
    protected int getInd(Point p){
        for (int i=0;i<_parr.length;i++){
            if(p==_parr[i])
                return i;
        }
        return -1;
    }

    /**
     * returns the parrent of given point
     * @param p point to look for
     * @return index of the parrent of p
     */
    protected int getParentInd(Point p){
        int ans;
        ans=getInd(p);
        ans=ans/2;
        return ans;
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
     * @param p point to look for
     * @return index of the right son of p
     */
    protected int getRightInd(Point p){
        int ans=getInd(p);
        ans=2*ans+1;
        return ans;
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
     * @param p point to look for
     * @return index of the left son of p
     */
    protected int getLeftInd(Point p){
        int ans=getInd(p);
        ans=2*ans;
        return ans;
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
