/**
 * Created by liorbass on 06/06/2016.
 */
public class MinHeap extends Heap{

    public MinHeap(Point[] parr){
        super(parr);
    }
    public MinHeap(int n) {super(2*n);}
    /**
     * standard heap heapify function
     * @param curr current index in the array
     */
    public void heapify(int curr) {
        int left = getLeftInd(curr);
        int right = getRightInd(curr);
        int smallest = curr;
        if (left <= _nodes.length && (_nodes[smallest].getPoint().getY() > _nodes[left].getPoint().getY()||
                (_nodes[smallest].getPoint().getY() == _nodes[left].getPoint().getY()&&_nodes[smallest].getPoint().getX()>_nodes[left].getPoint().getX())))
            smallest = left;
        if (right <= _nodes.length && (_nodes[smallest].getPoint().getY() > _nodes[right].getPoint().getY()||
                (_nodes[smallest].getPoint().getY() == _nodes[right].getPoint().getY()&&_nodes[smallest].getPoint().getX()>_nodes[right].getPoint().getX())))

            smallest = right;
        if (smallest != curr) {
            switchvals(curr, smallest);
            heapify(smallest);
        }
    }
}
