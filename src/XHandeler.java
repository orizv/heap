/**
 * Created by liorbass on 07/06/2016.
 */
public class XHandeler {

    private Point[] _currArr;
    private Point[] _addedPoints;
    private Point[] _deletedPoints;
    private  boolean[] _isDeleted;
    private boolean[] _addedDeleted;
    private int[] _sumPoints;
    private static int _numAdded;
    private static int _numDeleted;

    /**
     * constructor for the X array
     *
     * @param arr - the array from the company to initialize with.
     */

    public XHandeler(Point[] arr) {
        this.initialize(arr);
        _addedPoints = new Point[10 * (int) Math.log(arr.length)];
        _deletedPoints = new Point[10 * (int) Math.log(arr.length)];
        _isDeleted = new boolean[arr.length];
        for(int i=0;i<arr.length;i++)
            _isDeleted[i]=false;
        _addedDeleted=new boolean[10 * (int) Math.log(arr.length)];
        for (int i=0;i<_addedDeleted.length;i++)
            _addedDeleted[i]=true;
        _numAdded = 0;
        _numDeleted = 0;
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
        _sumPoints=new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum=sum+_currArr[i].getY();
            _sumPoints[i]=sum;
        }
    }

    public void insert(Point p) {
        _addedDeleted[_numAdded]=false;
        _addedPoints[_numAdded]=p;
        _numAdded++;
    }

    public void extract(Point p) {
        int index[]=search(p.getX());
        if (index[0]==1)
            _isDeleted[index[1]]=true;
        else if(index[0]==2)
            _addedDeleted[index[1]]=true;
        _deletedPoints[_numDeleted]=p;
        _numDeleted++;
    }

    public int[] search(int x){
        int ans=binSearch(x,_currArr,_currArr.length);
        if (ans==-1) {
            ans = linSearch(x, _addedPoints, _numAdded);
            if (ans != -1) {
                int[] answer = {2, ans};
                return answer;
            }
            else
                throw new RuntimeException("Fuck you it don't exist");
        }
        else{
            int[] answer = {1, ans};
            return answer;
        }
    }

    private int binSearch (int x, Point[] point, int size){
        int first = 0;
        int last = size;
        int exist=0;
        boolean found = false;
        int mid = (last - first) / 2;
        while(!found&exist==0) {
            if (last <= first)
                exist = -1;
            if (exist == 0) {
                if (point[mid].getX() == x) {
                    found = true;
                } else if (point[mid].getX() > x) {
                    last = mid - 1;
                } else first = mid + 1;
            }
        }
        if(found)
            return mid;
        else
            return -1;
    }

    private int linSearch (int x, Point[] point, int size){
        boolean found=false;
        int i;
        for (i=0;i<size&!found;i++){
            if(point[i].getX()==x){
                found=true;
                i--;
            }
        }
        if (found)
            return i;
        else
            return -1;
    }

}
