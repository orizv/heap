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
     *
     * @param arr
     */
    private Point[] checkSort(Point[] arr) {
        int n = arr.length;
        Point[] arr1;
        boolean sorted = true;
        for (int i = 0; i < n - 1 & sorted; i++) {
            if (arr[i].getX() < arr[i + 1].getX())
                sorted = false;
        }
        if (sorted == false) {
            arr1= new Point[n];
            for (int i = 0; i < n; i++) {
                arr1[arr[i].getX()] = arr[i];
            }
        }
        else arr1=arr;
        return arr1;
    }

    public void insert(Point p) {
        tree.insert(p);
    }

    public void remove(Point p) {
        tree.remove(p);
    }

    public int numOfPointsInRange(int XLeft, int XRight){
        return tree.numPointsInRange(XLeft, XRight);
    }

    public double averageHeightInRange(int XLeft, int XRight){
        return (((double)tree.sumPointsInRange(XLeft,XRight))/this.numOfPointsInRange(XLeft,XRight));
    }

    public Point[] getPointsInRange(int Xleft,int Xright){
        return tree.getPointsInRange(Xleft, Xright);
    }

    public Point[] getAllPoints(){
        return  tree.getAllPointsInRange();
    }
}
