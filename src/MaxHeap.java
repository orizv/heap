/**
 * Created by liorbass on 05/06/2016.
 */
public class MaxHeap extends Heap {

    public MaxHeap(Point[] parr) {
        super(parr);
    }

    public MaxHeap(int n) {
        super(2 * n);
    }

    @Override
    public void heapUp(int ind) {
        int i = ind;
        while (i > 1 &&
                ((_nodes[getParentInd(i)].getPoint().getY() < _nodes[i].getPoint().getY())
                        ||
                        (_nodes[getParentInd(i)].getPoint().getY() == _nodes[i].getPoint().getY() &&
                                _nodes[getParentInd(i)].getPoint().getX() < _nodes[i].getPoint().getY()))
                ) {
            switchvals(i, getParentInd(i));
            i = getParentInd(i);
        }
    }

    /**
     * standard heap heapify function
     *
     * @param curr current index in the array
     */
    public void heapify(int curr) {

        int left = getLeftInd(curr);
        int right = getRightInd(curr);
        int largest = curr;

        if (left <= get_size() && ((_nodes[largest].getPoint().getY() < _nodes[left].getPoint().getY()) ||
                (_nodes[largest].getPoint().getY() == _nodes[left].getPoint().getY() &&
                        _nodes[largest].getPoint().getX() < _nodes[left].getPoint().getX()))) {
            largest = left;
        }
        if (right <= get_size() && ((_nodes[largest].getPoint().getY() < _nodes[right].getPoint().getY()) ||
                (_nodes[largest].getPoint().getY() == _nodes[right].getPoint().getY() &&
                        _nodes[largest].getPoint().getX() < _nodes[right].getPoint().getX()))) {
            largest = right;
        }
        if (largest != curr) {
            switchvals(curr, largest);
            heapify(largest);
        }
    }

}
