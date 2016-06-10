/**
 * Created by user on 09/06/2016.
 */
public class BST {

    private BSTNode _root;

    public BST (){

    }

    /**
     * initialize the tree with the first array that we get from the company.
     *
     * @param points - a sorted array of points (by X)
     */
    public void initialize(Point[] points){
        if (points!=null) {
            int last = points.length;
            int first = 0;
            _root = new BSTNode(points[(last + first) / 2]);
            initialize(points, _root, first, last);
        }
    }

    private void initialize (Point[] points, BSTNode n, int first, int last){
        if (last!=first){
            int mid=(first+last)/2;
            n.setLeft(new BSTNode(points[(first+mid)/2]));
            n.setRight(new BSTNode(points[(last+mid)/2]));
            initialize(points,(BSTNode)n.getLeft(),first,mid-1);
            initialize(points,(BSTNode)n.getRight(),mid+1,last);
        }
        else if(n.getPoint().getX()!=points[last].getX()){
            if (n.getPoint().getX()>points[last].getX())
                n.setLeft(new BSTNode(points[last]));
            else
                n.setRight(new BSTNode(points[last]));
        }
        if (n.getRight()!=null){
            n.addToSize(((BSTNode)n.getRight()).getSize());
            n.addToSum(((BSTNode)n.getRight()).getSum());
        }
        if (n.getLeft()!=null){
            n.addToSize(((BSTNode)n.getLeft()).getSize());
            n.addToSum(((BSTNode)n.getLeft()).getSum());
        }
    }

    public void insert(Point p){
        this.insert(p,_root);
    }

    private void insert (Point p, BSTNode t){
        if (t==null)
            t= new BSTNode(p);
        else {
            t.addToSum(p.getY());
            t.addToSize(1);
            if (t.getPoint().getX()>p.getX())
                this.insert(p,(BSTNode)t.getLeft());
            else
                this.insert(p,(BSTNode)t.getRight());
        }

    }

    public void remove(Point p){

    }

    private void remove(Point p, BSTNode t){

    }

    private BSTNode findNextInLine()

    public Point[] getPointsInRange(int left, int right){

    }

    public int numPointsInRange(int left, int right){

    }

    public int sumPointsInRange(int left, int right){

    }
}
