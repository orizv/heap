/**
 * Created by liorbass on 06/06/2016.
 */
public class MinHeap extends Heap{

    public MinHeap(Point[] parr){
        super(parr);
    }
    public void heapify(int curr) {
        int left = getLeftInd(curr);
        int right = getRightInd(curr);
        int smallest = curr;
        if (left <= _parr.length && _parr[smallest].getX() > _parr[left].getX())
            smallest = left;
        if (right <= _parr.length && _parr[smallest].getX() > _parr[right].getX())
            smallest = right;
        if (smallest != curr) {
            switchvals(curr, smallest);
            heapify(smallest);
        }
    }
}
