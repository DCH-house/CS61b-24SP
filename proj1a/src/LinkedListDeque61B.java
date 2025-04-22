import java.util.ArrayList;
import java.util.List;

/**
 * @author Practice
 * @project proj1a
 */
public class LinkedListDeque61B<T> implements Deque61B<T>{
    /* a data abstraction of linkedListDeque61B */
    private class Node<T>{
        private Node(){}
        private Node(Node previous, T data, Node next){
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
        private Node previous;
        private T data;
        private Node next;
        void setPrevious(Node previous){
            this.previous = previous;
        }
        void setData(T data){
            this.data = data;
        }
        void setNext(Node next){
            this.next = next;
        }
        Node getPrevious() {
            return previous;
        }
        T getData(){
            return data;
        }
        Node getNext(){
            return next;
        }
    }
    /* the first item of linkedListDeque61B */
    private Node sentinel;

    private Integer size;

    /** use to recursive */
    private Node temp;
    public LinkedListDeque61B(){
        this.sentinel = new Node();
        sentinel.setPrevious(this.sentinel);
        sentinel.setNext(this.sentinel);
        this.size = 0;
        this.temp = sentinel;
    }
    @Override
    public void addFirst(T x) {
        size += 1;
        Node newNode = new Node();
        newNode.setData(x);
        Node next = sentinel.getNext();
        newNode.setNext(next);
        newNode.setPrevious(sentinel);
        sentinel.setNext(newNode);
    }

    @Override
    public void addLast(T x) {
        size += 1;
        Node newNode = new Node();
        newNode.setData(x);
        Node lastNode = sentinel.getPrevious();
        lastNode.setNext(newNode);
        newNode.setPrevious(lastNode);
        newNode.setNext(sentinel);
        sentinel.setPrevious(newNode);
    }

    @Override
    public List<T> toList() {
        List<T>list = new ArrayList<>();
        Node curr = sentinel.getNext();
        while(curr != sentinel){
            list.add((T)curr.getData());
            curr = curr.getNext();
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size.equals(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(size.equals(0)){
            return null;
        }
        size -= 1;
        Node first = sentinel.getNext();
        sentinel.setNext(first.getNext());
        first.getNext().setPrevious(sentinel);
        T data = (T)first.getData();
        first = null;
        return data;
    }

    @Override
    public T removeLast() {
        if(size.equals(0)){
            return null;
        }
        size -= 1;
        Node last = sentinel.getPrevious();
        sentinel.setPrevious(last.getPrevious());
        last.getPrevious().setNext(sentinel);
        T data = (T)last.getData();
        last = null;
        return data;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size){
            return null;
        }
        Node curr = sentinel.getNext();
        while(index > 0){
            curr = curr.getNext();
            index -= 1;
        }
        return (T)curr.getData();
    }

    @Override
    public T getRecursive(int index) {
        if(index < 0 || index > size){
            return null;
        }
        if(index == 0){
            return (T)temp.getNext().getData();
        }
        temp = temp.getNext();
        return getRecursive(index - 1);
    }
}
