
public class PointDataStructure implements PDT {

	private YHandeler _yHandler;
	private XHandeler _xHandler;

	//////////////// DON'T DELETE THIS CONSTRUCTOR ////////////////
	public PointDataStructure(Point[] points, Point initialYMedianPoint)
	{
		_yHandler=new YHandeler(points);
		_xHandler=new XHandeler(points);
		addPoint(initialYMedianPoint);
	}

	@Override
	public void addPoint(Point point) {
		_yHandler.addPoint(point);
		_xHandler.insert(point);
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
		 _yHandler.extractMedian();

	}

	@Override
	public Point[] getMedianPoints(int k) {
		_yHandler.getMedianPoints(k);
	}

	@Override
	public Point[] getAllPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO: add members, methods, etc.
	
}

