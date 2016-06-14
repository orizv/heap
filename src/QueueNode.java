/**
 * Created by liorbass on 14/06/2016.
 */
public class QueueNode {
    BSTNode _this;
    QueueNode _next;
    public QueueNode(BSTNode p){
        this._this=p;
        _next=null;
    }
    public void set_next(BSTNode p){
        _next=new QueueNode(p);
    }
    public void set_next(QueueNode qn){
        _next=qn;
    }
    public BSTNode getData(){
        return _this;
    }
    public QueueNode get_next(){
        return  _next;
    }

}
