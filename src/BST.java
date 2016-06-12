import java.lang.reflect.Method;

/**
 * Created by user on 09/06/2016.
 */
public class BST {

    private BSTNode _root;

    /**
     * empty constructor;
     */
    public BST (){
        _root=null;
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
            _root = new BSTNode(points[(last + first) / 2]); // initialize the root
            initialize(points, _root, first, last); // calls another method
        }
    }

    /**
     * a recursive method that initialize the tree with the first array that we get from the company.
     */
    private void initialize (Point[] points, BSTNode n, int first, int last){
        if ((last-first)>1){ // checks if the recurance need to be continued after this insertion
            int mid=(first+last)/2; // the place where
            n.setLeft(new BSTNode(points[(first+mid-1)/2]));//set the left son asthe median between the mid and the start
            n.setRight(new BSTNode(points[(last+mid+1)/2])); ////set the right son as the median between the mid and the last
            ((BSTNode)n.getLeft()).setParent(n);
            ((BSTNode)n.getRight()).setParent(n);
            initialize(points,(BSTNode)n.getLeft(),first,mid-1); //as long as there is more points call the recursive method with wht is left
            initialize(points,(BSTNode)n.getRight(),mid+1,last);
        }
        else if(n.compareToPoint(points[last])!=0){//if there is only one or 2 more point to insert
            if (n.compareToPoint(points[last])>0) {//checks if to insert to the left or to the right
                n.setLeft(new BSTNode(points[last]));
                ((BSTNode)n.getLeft()).setParent(n);
                if((last-first)==1)//in case that the number of the remaining points in this end was 2
                    initialize(points,(BSTNode)n.getLeft(),first,first);
                else
                ((BSTNode)n.getLeft()).makeLeaf(true);
            }
            else {
                n.setRight(new BSTNode(points[last]));
                ((BSTNode)n.getRight()).setParent(n);
                if((last-first)==1)//in case that the number of the remaining points in this end was 2.
                    initialize(points,(BSTNode)n.getRight(),first,first);
                else
                ((BSTNode)n.getRight()).makeLeaf(true);
            }
        }
        else n.makeLeaf(true);// if this was the last point to insert in this end
        if (n.getRight()!=null){ // after finished building the tree sums the size and the summery of the y points in the subtree
            n.addToSize(((BSTNode)n.getRight()).getSize());
            n.addToSum(((BSTNode)n.getRight()).getSum());
        }
        if (n.getLeft()!=null){
            n.addToSize(((BSTNode)n.getLeft()).getSize());
            n.addToSum(((BSTNode)n.getLeft()).getSum());
        }
    }

    /**
     * inserts a new point to the tree
     * @param p - the point that needs to be added
     */
    public void insert(Point p){
            this.insert(p, _root,null);
    }

    /**
     * inserts a new point to the tree
     * @param p - the point that needs to be added
     */
    private void insert (Point p, BSTNode t,BSTNode parent){
        if (t==null) {// if it is the bottom, insert.
            t = new BSTNode(p);
            t.setParent(parent);
            parent.makeLeaf(false);
        }
        else {// find the correct place to insert and along the way increase the size and the sum accordidng to the point that is inserted
            t.addToSum(p.getY());
            t.addToSize(1);
            if (t.compareToPoint(p)>0)
                this.insert(p,(BSTNode)t.getLeft(),t);
            else
                this.insert(p,(BSTNode)t.getRight(),t);
        }

    }

    /**
     * a method to remove a point from the tree
     * @param p - the points that needed to be removed
     */
    public void remove(Point p){
        BSTNode del =search(p);
        remove(del);//calls a recursive function
    }

    /**
     * a method to remove a point from the tree recursivly
     * @param t - the node that contains the point
     */
    private void remove(BSTNode t){
        if (t.isLeaf()){ // checks if is able to delete without harming the tree structure
            this.delete(t);
        }
        else {
            BSTNode swap = findNextInLine(t); // finds the points successor so it will replace the point in the position in the middle of
            t.descreseSum(t.getPoint().getY());
            t.setPoint(swap.getPoint());
            t.addToSum(t.getPoint().getY());
            remove(swap);// continue to delete the successor from its place untill it finds a leaf
        }
    }

    /**
     * // deleting from the tree hierarchy
     * @param t the node to be deleted
     */
    private void delete(BSTNode t){
        if (t.getParent().getRight().equals(t))
            t.getParent().setRight(null);
        else
            t.getParent().setLeft(null);
        if (t.getParent().getLeft()==null&&t.getParent().getRight()==null)
            t.getParent().makeLeaf(true);
        t.setParent(null);
    }

    /**
     * find the successor of a BST node (either the minimum or the maximum)
     * @param t-the BSTNode of whom need to find the successor
     * @return the successor
     */
    private BSTNode findNextInLine(BSTNode t){
        if (t.getLeft()!=null)
            return findMinToReplace(t);
        else if(t.getRight()!=null)
            return findMaxToReplace(t);
        else
            return null;
    }

    /**
     * in case of deletion finds the successor - finds the bigger successor
     * @param t - the BSTNode that needed to be replaced
     * @return the successor
     */
    private BSTNode findMinToReplace(BSTNode t){
        BSTNode ans;
        if (t.getLeft()!=null) {
            ans = findMinToReplace((BSTNode) t.getLeft());
            t.descreseSize(1);
            t.descreseSum(ans.getPoint().getY());
        }
        else
            ans = t;
        return ans;
    }

    /**
     * in case of deletion finds the successor - finds the lower successor
     * @param t - the BSTNode that needed to be replaced
     * @return the successor
     */
    private BSTNode findMaxToReplace(BSTNode t){
        BSTNode ans;
        if (t.getRight()!=null) {
            ans = findMaxToReplace((BSTNode) t.getRight());
            t.descreseSize(1);
            t.descreseSum(ans.getPoint().getY());
        }
        else
            ans = t;
        return ans;
    }

    /**
     * searching a point in the tree
     * @param p- point to search
     * @return the successor
     */
    public BSTNode search (Point p){
        if (_root==null)
            throw new RuntimeException("BST not able to search");
        else if(_root.getPoint().equals(p))
            return _root;
        else
            return search(p,_root);
    }

    /**
     * recursive method to search
     * @param p - the point to search
     * @param t - the cuurent place that is searched
     * @return the address of the BSTNode
     */
    private BSTNode search (Point p, BSTNode t){
        BSTNode ans;
        if (t.compareToPoint(p)==0){
            ans = t;
        }
        else if (t.compareToPoint(p)>0){
            ans = search(p,(BSTNode)t.getLeft());
        }
        else {
            ans = search(p,(BSTNode)t.getRight());
        }
        return ans;
    }

    /**
     * an method that finds and return all the points in a certain range of x's
     * @param left - the lower bound of x's
     * @param right - the upper boud of x's
     * @return an array with the points in the range
     */
    public Point[] getPointsInRange(int left, int right){
        Point[] ans = new Point[numPointsInRange(left, right)];
        BSTNode parent=getPrimalParent(_root,left,right);
        fillArrayInRange(parent,ans,left,right,0);
        return ans;
    }

    /** need to fix - not correct!!!!
     * a recursive method to fill an array with point within a certain range
     * @param ins - the current node to check if
     * @param p
     * @param left
     * @param right
     * @param filled
     */
    private void fillArrayInRange (BSTNode ins,Point[] p, int left, int right,int filled) {
        if (ins.getLeft() != null) {
            if (ins.getLeft().getPoint().getX() >= left) {
                fillArrayInRange((BSTNode) ins.getLeft(), p, left, right, filled);
                filled++;
            }
        }
        if (ins.getRight() !=null) {
            if (ins.getRight().getPoint().getX() <= right) {
                fillArrayInRange((BSTNode) ins.getLeft(), p, left, right, filled+1);
            }
        }
        p[filled]=new Point(ins.getPoint());
    }

    /**
     * a method to count the number of points with x values within a certain range
     * @param left the lower bound
     * @param right -the upper bound
     * @return int
     */
    public int numPointsInRange(int left, int right){
        BSTNode parent=getPrimalParent(_root,left,right);
        BSTNode curLeft=(BSTNode) parent.getLeft();
        BSTNode curRight = (BSTNode)parent.getRight();
        int size=parent.getSize();
        while (curLeft.getPoint().getX()!=left&&curRight.getPoint().getX()!=right){
            if (curLeft.getPoint().getX()>left)
                curLeft=(BSTNode) curLeft.getLeft();
            else if (curLeft.getPoint().getX()<left){
                size=size-((BSTNode)curLeft.getLeft()).getSize();
                curLeft=(BSTNode)curLeft.getRight();
            }
            if (curRight.getPoint().getX()<right)
                curRight=(BSTNode)curRight.getRight();
            else if(curRight.getPoint().getX()>right){
                size=size-((BSTNode)curRight.getRight()).getSize();
                curLeft=(BSTNode)curRight.getLeft();
            }
        }
        if (curLeft.getLeft()!=null)
            size=size-((BSTNode)curLeft.getLeft()).getSize();
        if (curRight.getRight()!=null)
            size=size-((BSTNode)curRight.getRight()).getSize();
        return size;
    }

    /**
     * returns a summery of all the y points in range
     * @param left - the lower bound
     * @param right - the upper bound
     * @return int -the summery of all the y values within a range
     */
    public int sumPointsInRange(int left, int right){
        BSTNode parent=getPrimalParent(_root,left,right);
        BSTNode curLeft=(BSTNode) parent.getLeft();
        BSTNode curRight = (BSTNode)parent.getRight();
        int sum=parent.getSum();
        while (curLeft.getPoint().getX()!=left&&curRight.getPoint().getX()!=right){
            if (curLeft.getPoint().getX()>left)
                curLeft=(BSTNode) curLeft.getLeft();
            else if (curLeft.getPoint().getX()<left){
                sum=sum-((BSTNode)curLeft.getLeft()).getSum();
                curLeft=(BSTNode)curLeft.getRight();
            }
            if (curRight.getPoint().getX()<right)
                curRight=(BSTNode)curRight.getRight();
            else if(curRight.getPoint().getX()>right){
                sum=sum-((BSTNode)curRight.getRight()).getSum();
                curLeft=(BSTNode)curRight.getLeft();
            }
        }
        if (curLeft.getLeft()!=null)
            sum=sum-((BSTNode)curLeft.getLeft()).getSum();
        if (curRight.getRight()!=null)
            sum=sum-((BSTNode)curRight.getRight()).getSum();
        return sum;
    }

    /**
     * a method that returns the first parent of both left and right range
     * @param curr- the current node to check
     * @param left - the lower bound
     * @param right - the upper bound
     * @return BSTNode - the first parent of both of them.
     */
    private BSTNode getPrimalParent(BSTNode curr, int left, int right){
        BSTNode ans;
        if (curr.getPoint().getX()<=right)
            if(curr.getPoint().getX()>=left)
                ans=curr;
            else
                ans=getPrimalParent((BSTNode)curr.getRight(),left,right);
        else
            ans=getPrimalParent((BSTNode)curr.getLeft(),left,right);
        return ans;
    }


    
}
