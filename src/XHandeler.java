/**
 * Created by liorbass on 07/06/2016.
 */
public class XHandeler {

    private BST tree;

    /**
     * constructor for the X array
     *
     * @param arr - the array from the company to initialize with.
     */

    public XHandeler(Point[] arr) {
        Point[] arr1=checkSort(arr);
        tree=new BST();
        tree.initialize(arr1);
    }

    /**
     *checks if the array is sorted and if not sort by the pre knowledge
     * @param arr - the initial arry
     */
    private Point[] checkSort(Point[] arr) {
        int n = arr.length;
        Point[] arr1;
        boolean sorted = true;
        for (int i = 0; i < n-1  & sorted; i++) {
            if (arr[i].getX() > arr[i + 1].getX())
                sorted = false;
        }
        if (sorted == false) {
            arr1= new Point[n];
            for (int i = 0; i <= n-1; i++) {
                arr1[arr[i].getX()] = arr[i];
            }
        }
        else arr1=arr;
        return arr1;
    }

    /**
     * insert point
     * @param p -point to insert
     */
    public void insert(Point p) {
        tree.insert(p);
    }

    /**
     * delete point
     * @param p-the point to remove
     */
    public void remove(Point p) {
        tree.remove(p);
    }

    /**
     * checks the number of point in a range
     * @param XLeft -the lower bound
     * @param XRight - the upper bound
     * @return int
     */
    public int numOfPointsInRange(int XLeft, int XRight){
        return tree.numPointsInRange(XLeft, XRight);
    }

    /**
     * checks the avarage y's in range
     * @param XLeft -the lower bound
     * @param XRight - the upper bound
     * @return int
     */
    public double averageHeightInRange(int XLeft, int XRight){
        int a=this.numOfPointsInRange(XLeft,XRight);
        if (a!=0)
            return (((double)tree.sumPointsInRange(XLeft,XRight))/this.numOfPointsInRange(XLeft,XRight));
        else
            return 0;
    }

    /**
     * gets all the points in a certain range.
     * @param XLeft -the lower bound
     * @param XRight - the upper bound
     * @return array of points
     */
    public Point[] getPointsInRange(int XLeft,int XRight){
        return tree.getPointsInRange(XLeft, XRight);
    }

    /**
     * gets all the current points
     * @return array of points
     */
    public Point[] getAllPoints(){
        return  tree.getAllPointsInRange();
    }
}
