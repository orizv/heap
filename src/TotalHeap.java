/**
 * Created by liorbass on 07/06/2016.
 */
public class TotalHeap {
    private MinHeap _minHeap;
    private MaxHeap _maxHeap;

    public TotalHeap(Point[] points){
        _maxHeap=new MaxHeap(points.length);
        _minHeap=new MinHeap(points.length);
    }
    public void add(Point p){
        if(_maxHeap.get_size()>_minHeap.get_size()){
            
        }
    }
}
