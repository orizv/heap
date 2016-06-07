/**
 * Created by liorbass on 05/06/2016.
 */
public class MaxHeap extends Heap {

    public MaxHeap(Point[] parr){
        super(parr);
    }
    public MaxHeap(int n){super(n);}
    /**
     * standard heap heapify function
     * @param curr current index in the array
     */
    public void heapify(int curr) {
        int left=getLeftInd(curr);
        int right=getRightInd(curr);
        int largest=curr;
        if(left<=_parr.length && _parr[largest].getY()<_parr[left].getY())
            largest=left;
        if(right<=_parr.length && _parr[largest].getY()<_parr[right].getY())
            largest=right;
        if(largest!=curr){
            switchvals(curr,largest);
            heapify(largest);
        }
    }

}
