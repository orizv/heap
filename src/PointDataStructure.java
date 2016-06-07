
public class PointDataStructure implements PDT {

	private MaxHeap _maxHeap;
	private MinHeap _minHeap;

	//////////////// DON'T DELETE THIS CONSTRUCTOR ////////////////
	public PointDataStructure(Point[] points, Point initialYMedianPoint)
	{
		_maxHeap=new MaxHeap(points);
		_minHeap=new MinHeap(points);
		_maxHeap.insert(initialYMedianPoint);
	}

	@Override
	public void addPoint(Point point) {
		if(point.getY()>_maxHeap.extract().getY()){
			_minHeap.insert(point);
		}
		else{
			_maxHeap.insert(point);
		}
	}

	@Override
	public Point[] getPointsInRange(int XLeft, int XRight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numOfPointsInRange(int XLeft, int XRight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double averageHeightInRange(int XLeft, int XRight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeMedianPoint() {
		_maxHeap.extract();
	}

	@Override
	public Point[] getMedianPoints(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point[] getAllPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO: add members, methods, etc.
	
}

