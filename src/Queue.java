/**
 * Created by liorbass on 14/06/2016.
 */
public class Queue {
    private QueueNode start;
    private QueueNode end;

    public Queue(){
        start=null;
        end=null;
    }

    /**
     * Insert a new point to the queue
     * @param p point to insert
     */
    public void enqueue(Point p){
        if (end==null){
            end=new QueueNode(p);
            start=end;
        }
        else{
            QueueNode t=new QueueNode(p);
            end.set_next(t);
            end=t;
        }

    }

    /**
     * get the first queued point from the queue
     * @return point
     */
    public Point dequeue(){
        if(start==null)
            return null;
        else {
            Point ans=start.getData();
            start=start.get_next();
            return ans;
        }
    }

    /**
     * check if the queue is empty
     * @return true if there is no items in the queue
     */
    public boolean isEmpty(){
        return (start==null&&end==null);

    }
}
