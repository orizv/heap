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
    public void enqueue(BSTNode p){
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
    public BSTNode dequeue(){
        if(start==null)
            return null;
        else {
            BSTNode ans=start.getData();
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
