/**
 * Created by liorbass on 14/06/2016.
 */
public class QueueNode {
    Point _this;
    QueueNode _next;
    public QueueNode(Point p){
        this._this=p;
        _next=null;
    }
    public void set_next(Point p){
        _next=new QueueNode(p);
    }
    public void set_next(QueueNode qn){
        _next=qn;
    }
    public Point getData(){
        return _this;
    }
    public QueueNode get_next(){
        return  _next;
    }

}
