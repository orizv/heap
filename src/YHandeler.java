/**
 * Created by liorbass on 07/06/2016.
 */
public class YHandeler {
    private MinHeap _minHeap;
    private MaxHeap _maxHeap;

    public  YHandeler(Point[] points){

    }
    public Point extractMedian(){
        return _maxHeap.extract();
    }
    public void addPoint(Point point) {
        if(point.getY()>_maxHeap.extract().getY()){
            _minHeap.insert(point);
        }
        else{
            _maxHeap.insert(point);
        }
    }
}
