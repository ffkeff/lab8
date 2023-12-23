import java.util.NoSuchElementException;

public class MyList<T> {
    private Node<T> head;
    public Node<T> getHead(){
        return head;
    }
    private Node<T> tail;
    private int size;
    public int getSize(){
        return size;
    }

    public MyIterator<T> getIteratorFromStart() {
        return new MyIterator<>(head);
    }

    public MyIterator<T> getIteratorFromEnd() {
        return new MyIterator<>(tail);
    }
    class MyIterator<T>{
        private Node<T> current;

        public MyIterator(Node<T> head) {
            this.current = head;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public boolean hasPrevious(){
            return current.prev != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            T data = current.data;
            current = current.next;
            return data;
        }

        public T previous(){
            if(!hasPrevious())
                throw new NoSuchElementException();

            T data = current.data;
            current = current.prev;
            return data;
        }
    }

    public MyList(){
        size = 0;
        head = tail = null;
    }

    public MyList(MyList<T> list){
        head = list.head;
        tail = list.tail;
        size = list.getSize();
    }
    public void pushFront(T data){
        var tmp = new Node<>(head, data, null);
        if(head != null)
            head.prev = tmp;
        head = tmp;

        if(tail == null)
            tail = tmp;
        size++;
    }

    public void pushBack(T data){
        var tmp = new Node<>(null, data, tail);
        if(tail != null)
            tail.next = tmp;

        tail = tmp;
        if(head == null)
            head = tmp;

        size++;
    }
    public T pop() throws MyListException{
        if(head == null)
            throw new MyListException("head is null\n");

        Node<T> prev = head;
        head = head.next;
        if(head != null)
            head.prev = null;
        T data = prev.data;
        prev = null;
        System.gc();
        size--;
        return data;
    }

    public T pop(int index){
        Node<T> tmp = getNth(index);


        Node<T> prev = tmp;
        tmp = tmp.next;
        if(tmp != null)
            tmp.prev = null;

        T data = prev.data;
        prev = null;
        System.gc();
        size--;
        return data;
    }

    public void clear(){
        Node<T> tmp = head;
        Node<T> next;
        while(tmp != null){
            next = tmp.next;
            tmp = null;
            System.gc();
            tmp = next;
        }
        size = 0;
    }

    private Node<T> getNth(int index){
        Node<T> tmp;
        int i;

        if(index < size / 2){
            i = 0;
            tmp = head;
            while (tmp != null && i < index){
                tmp = tmp.next;
                i++;
            }
        } else {
            i = size - 1;
            tmp = tail;
            while (tmp != null && i > index){
                tmp = tmp.prev;
                i--;
            }
        }

        return tmp;
    }
}

