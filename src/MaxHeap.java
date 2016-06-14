/**
 * Created by liorbass on 05/06/2016.
 */
public class MaxHeap extends Heap {

    public MaxHeap(Point[] parr){
        super(parr);
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
        if(left<=_nodes.length && (_nodes[largest].getPoint().getY()<_nodes[left].getPoint().getY()||
                (_nodes[largest].getPoint().getY()==_nodes[left].getPoint().getY()&&_nodes[largest].getPoint().getX()<_nodes[left].getPoint().getX()))) {
            largest = left;
        }
        if(right<=_nodes.length && _nodes[largest].getPoint().getY()<_nodes[right].getPoint().getY()||
                (_nodes[largest].getPoint().getY()==_nodes[right].getPoint().getY()&&_nodes[largest].getPoint().getX()<_nodes[right].getPoint().getX())) {
            largest = right;
        }
        if(largest!=curr){
            switchvals(curr,largest);
            heapify(largest);
        }
    }

}
