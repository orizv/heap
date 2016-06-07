/**
 * Created by liorbass on 07/06/2016.
 */
public class XHandeler {

    private Point[] _currArr;
    private Point[] _addedPoints;
    private Point[] _deletedPoints;
    private int[] _sumPoints;
    static int numAdded;
    static int numDeleted;

    /**
     * constructor for the X array
     *
     * @param arr - the array from the company to initialize with.
     */

    public XHandeler(Point[] arr) {
        this.initialize(arr);
        _addedPoints = new Point[10 * (int) Math.log(arr.length)];
        _deletedPoints = new Point[10 * (int) Math.log(arr.length)];
        numAdded = 0;
        numDeleted = 0;
    }

    /**
     *
     * @param arr
     */
    private void initialize(Point[] arr) {
        int n = arr.length;
        boolean sorted = true;
        for (int i = 0; i < n - 1 & sorted; i++) {
            if (arr[i].getX() < arr[i + 1].getX())
                sorted = false;
        }
        Point[] arr1 = new Point[n];
        if (sorted == false) {
            for (int i = 0; i < n; i++) {
                arr1[arr[i].getX()] = arr[i];
            }
            _currArr = arr1;
        } else {
            _currArr = arr;
        }
    }

    public void insert(Point p) {

    }

    public Point extract(Point p) {

    }

    public boolean search(Point p){

    }



}
