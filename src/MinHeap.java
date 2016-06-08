/**
 * Created by liorbass on 06/06/2016.
 */
public class MinHeap extends Heap{

    public MinHeap(Point[] parr){
        super(parr);
    }
    public MinHeap(int n) {super(2*n);}
    public void heapify(int curr) {
        int left = getLeftInd(curr);
        int right = getRightInd(curr);
        int smallest = curr;
        if (left <= _nodes.length && (_nodes[smallest].get_point().getY() > _nodes[left].get_point().getY()||
                (_nodes[smallest].get_point().getY() == _nodes[left].get_point().getY()&&_nodes[smallest].get_point().getX()>_nodes[left].get_point().getX())))
            smallest = left;
        if (right <= _nodes.length && (_nodes[smallest].get_point().getY() > _nodes[right].get_point().getY()||
                (_nodes[smallest].get_point().getY() == _nodes[right].get_point().getY()&&_nodes[smallest].get_point().getX()>_nodes[right].get_point().getX())))

            smallest = right;
        if (smallest != curr) {
            switchvals(curr, smallest);
            heapify(smallest);
        }
    }
}
