/**
 * Created by liorbass on 06/06/2016.
 */
public class MinHeap extends Heap{

    public MinHeap(Point[] parr){
        super(parr);
    }

    @Override
    public void heapUp(int ind) {
        if (ind>1) {
            Node father=_nodes[getParentInd(ind)];
            Node cur=_nodes[ind];
            if(father.getPoint().getY()>cur.getPoint().getY())
            {
                switchvals(ind,getParentInd(ind));
                heapUp(getParentInd(ind));
            }
            if(father.getPoint().getY()==cur.getPoint().getY()&&father.getPoint().getX()>cur.getPoint().getX()){
                switchvals(ind,getParentInd(ind));
                heapUp(getParentInd(ind));
            }
        }
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
        if (left <=get_size() && (_nodes[smallest].getPoint().getY() > _nodes[left].getPoint().getY()||
                (_nodes[smallest].getPoint().getY() == _nodes[left].getPoint().getY()&&_nodes[smallest].getPoint().getX()>_nodes[left].getPoint().getX())))
            smallest = left;
        if (right <=get_size() && (_nodes[smallest].getPoint().getY() > _nodes[right].getPoint().getY()||
                (_nodes[smallest].getPoint().getY() == _nodes[right].getPoint().getY()&&_nodes[smallest].getPoint().getX()>_nodes[right].getPoint().getX())))

            smallest = right;
        if (smallest != curr) {
            switchvals(curr, smallest);
            heapify(smallest);
        }
    }
}
