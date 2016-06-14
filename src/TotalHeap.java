/**
 * Created by liorbass on 07/06/2016.
 */
public class TotalHeap {
    private MinHeap _minHeap;
    private MaxHeap _maxHeap;
    private Node _midean;

    public TotalHeap(Point[] points,Point median){
        _maxHeap=new MaxHeap(points.length);
        _minHeap=new MinHeap(points.length);
        Point[] minPointArr= new Point[points.length];
        int minInd=0;
        Point[] maxPointArr= new Point[points.length];
        int maxInd=0;
        for (int i=0;i<points.length;i++){
            if(points[i].getY()>=median.getX()){
                maxPointArr[maxInd]=points[i];
                maxInd++;
            }
            else{
                minPointArr[minInd]=points[i];
                minInd++;
            }

        }

    }
    public TotalHeap(int n){
        _minHeap=new MinHeap(n/2+1);
        _maxHeap=new MaxHeap(n/2+1);
    }
    /**
     * addes a point to data stracture
     * @param p
     */
    public void add(Point p){
        if(_midean==null)   //if the array is empty
        {
            _midean=new Node(p);
        }
        else {
            if (p.getY() > _midean.getPoint().getY()) {    //if the given point is bigger than the middiean
                _minHeap.insert(p);
            }
            else {                              //given point is larger or smaller than the middiean
                _maxHeap.insert(p);
            }
            syncSize();
        }
    }
    public Point get_midean(){
        return _midean.getPoint();
    }
    /**
     * returns the median points in the heap
     * @return  Point that is the median by the Y value
     */
    public Point extractMedian()
    {
        Point ans=_midean.getPoint();
        _midean=_maxHeap.extract();
        syncSize();
        return  ans;
    }

    /**
     * returns the number of all items in the heap
     * @return  the number of all items in the heap
     */
    public int getSize(){
        return _maxHeap.get_size()+_minHeap.get_size();
    }
    public Point[] getMedianPoints(int k)
    {
        TotalHeap local= new TotalHeap(k);
        Node[] ans=new Node[k];
        Point[] points=new Point[k];
        local.add(this.extractMedian());
        for(int i=0;i<k;i++){
            ans[i]=local.extractMedianNode();
            local.add(ans[i].getLeft().getPoint());
            local.add(ans[i].getRight().getPoint());
        }
        return points;
    }
    private Node extractMedianNode(){
        Node ans=_midean;
        _midean=_maxHeap.extract();
        syncSize();
        return  ans;
    }
    /**
     * Syncs the size of both heaps
     */
    private void syncSize(){
        if (_maxHeap.get_size() > _minHeap.get_size()+1) {  // make the size differ by max 1
            Node temp=_midean;
            _midean=_maxHeap.extract();
            _minHeap.insert(temp);
        }
        if (_minHeap.get_size() > _maxHeap.get_size()+1) {
            Node temp=_midean;
            _midean=_minHeap.extract();
            _maxHeap.insert(temp);
        }
    }


}
