import java.util.LinkedList;

public class Problem3 {
    public static void main(String[] args) {

    }
}
class Node<T>{
    T data;
    Node<T> next;
    public Node(T data){
        this.data=data;
        this.next=null;
    }
}
class GenericLinklist<T>{
    private Node<T> head;
    private int size;

    public GenericLinklist(){
        head = new Node<>(null);
        size = 0;
    }
    // 头插法
    public boolean addList(Node<T> node){
        if(node == null)
            return false;
        else{
            node.next=head.next;
            head.next=node;
            size++;
            return true;
        }
    }
    public void removeList0(){
        if(head.next==null) {
            System.out.println("删除失败");
            return;
        }
        else{
            Node<T> current1 = head.next;
            Node<T> current2 = head;
            while(current1.next!=null) {
                current1 = current1.next;
                current2 = current2.next;
            }
            current2.next=current1.next;
            size--;
            System.out.println("删除成功");
        }
    }
    public void removelistByValue(T value){
        if(head.next==null)
            return;
        else{
            Node<T> current = head.next;
            Node<T> current_ = head;
            while(current!=null&&!(current.data.equals(value))){
                current=current.next;
                current_=current_.next;
            }
            if(current==null){
                System.out.println("未找到改节点");
            }
            else{
                current_.next=current.next;
                System.out.println("删除成功");
                size--;
            }
        }
    }
    public int find(T value){
        int res=0;
        Node<T> node=head.next;
        if(node==null) {
            System.out.println("未找到");
            return -1;
        }
        else{
            while(node!=null&&!(node.data.equals(value))){
                res++;
                node=node.next;
            }
            if(node==null){
                System.out.println("未找到");
                return -1;
            }
            else{
                return res;
            }
        }
    }
}



