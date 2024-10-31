public class LinkedListDeque<T> {

    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode pre;
        public IntNode(T i, IntNode p, IntNode n){
            item = i;
            next = n;
            pre = p;
        }


    }


    private IntNode first;

    private int  size;

    private  IntNode last;


    public LinkedListDeque(){}

    public LinkedListDeque(LinkedListDeque other){}



    public void addFirst(T item){
        size += 1;
        IntNode p = new IntNode(item,null,first);
        first.pre = p;
        first = p;

    }

    public void addLast(T item){

    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void printDeque(){

    }

    public T removeFirst(){
        T firstItem = first.item;
        first = first.next;
        return firstItem;

    }

    public T removeLast(){

        return null;
    }

    public T get(int index){
        if(index == 0) {
            return first.item;
        }
        IntNode p = first;
        while(index > 0){
            p = p.next;
        }

        return p.item;
    }


    public T getRecursive(int index){
        return null;
    }



}
