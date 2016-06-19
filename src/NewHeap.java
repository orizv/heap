/**
 * Created by liorbass on 19/06/2016.
 */
public abstract class NewHeap {

    protected Node[] _nodes;
    protected int _size;

    public NewHeap(Point[] parr){
        _nodes=new Node[10*parr.length*(int)Math.log(parr.length)];
        for(int i=0;i<parr.length;i++){
            _nodes[i]=new Node(parr[i+1]);
        }
        _size=parr.length;
    }
    //for(int i=0;i<)
    protected abstract void heapify(int ind);

}
