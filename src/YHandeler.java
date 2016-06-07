/**
 * Created by liorbass on 07/06/2016.
 */
public class YHandeler {

    TotalHeap _heap;

    public  YHandeler(Point[] points){
        _heap=new TotalHeap(points);
    }
    public Point extractMedian(){
        return _heap.extractMedian();
    }
    public Point getMedian(){
        return _heap.get_midean();
    }
    public void addPoint(Point point) {
        _heap.add(point);
    }

    public Point[] getMedianPoints(int k) {
        Point[] ans=new Point[_heap.getSize()];
        for(int i=0;i<k;i++){
            ans[i]=_heap.extractMedian();
        }
        for(int i=0;i<k;i++){
            _heap.add(ans[i]);
        }
        return ans;
    }
}
