/**
 * Created by liorbass on 06/06/2016.
 */
public class MinHeap extends Heap{

    public MinHeap(Point[] parr){
        super(parr);
    }
    public MinHeap(int n) {super(n);}
    public void heapify(int curr) {
        int left = getLeftInd(curr);
        int right = getRightInd(curr);
        int smallest = curr;
        if (left <= _parr.length && _parr[smallest].getY() > _parr[left].getY())
            smallest = left;
        if (right <= _parr.length && _parr[smallest].getY() > _parr[right].getY())
            smallest = right;
        if (smallest != curr) {
            switchvals(curr, smallest);
            heapify(smallest);
        }
    }
}
