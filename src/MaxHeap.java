/**
 * Created by liorbass on 05/06/2016.
 */
public class MaxHeap extends Heap {

    public MaxHeap(Point[] parr){
        super(parr);
    }

    @Override
    public void heapUp(int ind) {
        if (ind>1) {
            Node father=_nodes[getParentInd(ind)];
            Node cur=_nodes[ind];
            if(father.getPoint().getY()<cur.getPoint().getY())
            {
                switchvals(ind,getParentInd(ind));
                heapify(getParentInd(ind));
            }
            if(father.getPoint().getY()==cur.getPoint().getY()&&father.getPoint().getX()<cur.getPoint().getX()){
                switchvals(ind,getParentInd(ind));
                heapify(getParentInd(ind));
            }
        }
    }

    public MaxHeap(int n){super(2*n);}
    /**
     * standard heap heapify function
     * @param curr current index in the array
     */
    public void heapify(int curr) {
        int left=getLeftInd(curr);
        int right=getRightInd(curr);
        int largest=curr;
        if(left<=get_size() && ((_nodes[largest].getPoint().getY()<_nodes[left].getPoint().getY())||
                (_nodes[largest].getPoint().getY()==_nodes[left].getPoint().getY()&&_nodes[largest].getPoint().getX()<_nodes[left].getPoint().getX()))) {
            largest = left;
        }
        if(right<=get_size() && ((_nodes[largest].getPoint().getY()<_nodes[right].getPoint().getY())||
                (_nodes[largest].getPoint().getY()==_nodes[right].getPoint().getY()&&_nodes[largest].getPoint().getX()<_nodes[right].getPoint().getX()))) {
            largest = right;
        }
        if(largest!=curr){
            switchvals(curr,largest);
            heapify(largest);
        }
    }

}
