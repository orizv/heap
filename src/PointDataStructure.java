
public class PointDataStructure implements PDT {

	private YHandeler _yHandler;
	private XHandeler _xHandler;

	//////////////// DON'T DELETE THIS CONSTRUCTOR ////////////////
	public PointDataStructure(Point[] points, Point initialYMedianPoint)
	{
		_yHandler=new YHandeler(points,initialYMedianPoint);
		_xHandler=new XHandeler(points);
	}

	@Override
	public void addPoint(Point point) {
		_yHandler.addPoint(point);
		_xHandler.insert(point);
	}

	@Override
	public Point[] getPointsInRange(int XLeft, int XRight) {
		return _xHandler.getPointsInRange(XLeft, XRight);
	}

	@Override
	public int numOfPointsInRange(int XLeft, int XRight) {
		return _xHandler.numOfPointsInRange(XLeft,XRight);
	}

	@Override
	public double averageHeightInRange(int XLeft, int XRight) {
		return _xHandler.averageHeightInRange(XLeft, XRight);
	}

	@Override
	public void removeMedianPoint() {
		 Point del =_yHandler.extractMedian();
		_xHandler.remove(del);
	}

	@Override
	public Point[] getMedianPoints(int k) {
		return _yHandler.getMedianPoints(k);
	}

	@Override
	public Point[] getAllPoints() {
		return _xHandler.getAllPoints();
	}

	//TODO: add members, methods, etc.
	
}

