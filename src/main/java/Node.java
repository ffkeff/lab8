public class Node<T> {
    public Node<T> next;
    public T data;
    public Node<T> prev;

    public Node(Node<T> next, T data, Node<T> prev){
        this.next = next;
        this.data = data;
        this.prev = prev;
    }
}

