/**
 * Created by liorbass on 07/06/2016.
 */
public class TotalHeap {
    private MinHeap _minHeap;
    private MaxHeap _maxHeap;
    private Node _midean;

    public TotalHeap(Point[] points, Point median) {
        Point[] minPointArr = new Point[points.length];
        int minInd = 0;
        Point[] maxPointArr = new Point[points.length];
        int maxInd = points.length / 2 - 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i].getY() > median.getY()) {
                minPointArr[minInd] = points[i];
                minInd++;
            }
            if (points[i].getY() < median.getY()) {
                maxPointArr[maxInd] = points[i];
                maxInd--;
            }
            if (points[i].getY() == median.getY()) {
                if (points[i].getX() > median.getX()) {
                    minPointArr[minInd] = points[i];
                    minInd++;
                }
                if (points[i].getX() < median.getX()) {
                    maxPointArr[maxInd] = points[i];
                    maxInd--;
                }
                if (points[i].getX() == median.getX()) {
                    _midean = new Node(points[i]);
                }
            }
        }
        _maxHeap = new MaxHeap(maxPointArr);
        _minHeap = new MinHeap(minPointArr);
        mediansons();

    }

    public TotalHeap(int n) {
        _minHeap = new MinHeap(n / 2 + 1);
        _maxHeap = new MaxHeap(n / 2 + 1);
    }

    /**
     * addes a point to data stracture
     *
     * @param p
     */
    public void add(Point p) {
        if (_midean == null)   //if the array is empty
        {
            _midean = new Node(p);
        } else {
            if (p.getY() > _midean.getPoint().getY()) {    //if the given point is bigger than the middiean
                _minHeap.insert(p);
            } else {                              //given point is larger or smaller than the middiean
                _maxHeap.insert(p);
            }
            syncSize();
        }
    }

    /**
     * add new node to the heap
     * @param n node to add
     */
    public void add(Node n) {
        if (_midean == null) {
            _midean = n;
            _midean.setLeft(null);
            _midean.setRight(null);
        } else {
            if (n.getPoint().getY() > _midean.getPoint().getY()) {
                _minHeap.insert(n);
            }
            if (n.getPoint().getY() < _midean.getPoint().getY()) {
                _maxHeap.insert(n);
            }
            if (n.getPoint().getY() == _midean.getPoint().getY()) {
                if (n.getPoint().getX() > _midean.getPoint().getX()) {
                    _minHeap.insert(n);
                }
                if (n.getPoint().getX() < _midean.getPoint().getX()) {
                    _maxHeap.insert(n);
                }
            }
            syncSize();
        }
    }

    /**
     * @return the median point in the heap
     */
    public Point get_midean() {
        return _midean.getPoint();
    }

    /**
     * returns the median points in the heap
     *
     * @return Point that is the median by the Y value
     */
    public Point extractMedian() {
        return extractMedianNode().getPoint();
    }

    /**
     * returns the number of all items in the heap
     *
     * @return the number of all items in the heap
     */
    public int getSize() {
        return _maxHeap.get_size() + _minHeap.get_size();
    }

    public Point[] getMedianPoints(int k) {
        TotalHeap local = new TotalHeap(k);
        TempNode[] ans = new TempNode[k];
        Point[] points = new Point[k];
        local.add(new TempNode(_midean));
        for (int i = 0; i < k; i++) {
            ans[i] = (TempNode) (local.extractMedianNode());
            if (ans[i].getPrevLeft() != null)
                local.add(new TempNode(ans[i].getPrevLeft()));
            if (ans[i].getPrevRight() != null)
                local.add(new TempNode(ans[i].getPrevRight()));
        }
        for (int i = 0; i < k; i++) {
            points[i] = ans[i].getPoint();
        }
        return points;
    }

    /**
     * removes the current median
     * @return a node of the median
     */
    private Node extractMedianNode() {
        Node ans = _midean;
        _midean = null;
        int n = getSize() / 2;
        if (n <= _maxHeap.get_size() - 1 & _maxHeap.get_size() > 0) {
            _midean = _maxHeap.extract();
        } else if (_minHeap.get_size() > 0) {
            _midean = _minHeap.extract();
        }

        syncSize();
        return ans;
    }

    /**
     * Syncs the size of both heaps
     */
    private void syncSize() {
        if (_maxHeap != null & _minHeap != null) {
            if (_maxHeap.get_size() - _minHeap.get_size() > 2 & _maxHeap.get_size() > 0) {
                Node temp = _midean;
                _midean = _maxHeap.extract();
                _minHeap.insert(temp);
            }
            if (_minHeap.get_size() - _maxHeap.get_size() > 1) {
                if (_minHeap.get_size() > 0) {
                    Node temp = _midean;
                    _midean = _minHeap.extract();
                    _maxHeap.insert(temp);
                }
            }
            mediansons();
        }
    }

    /**
     * set the correct sons of the median
     */
    private void mediansons() {
        if (_minHeap.getTop() != null)
            _midean.setRight(_minHeap.getTop());
        if (_maxHeap.getTop() != null)
            _midean.setLeft(_maxHeap.getTop());
    }


}
