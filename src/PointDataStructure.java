
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
		_yHandler.getMedianPoints(k);
	}

	@Override
	public Point[] getAllPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO: add members, methods, etc.
	
}

