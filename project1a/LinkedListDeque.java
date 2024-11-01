public class LinkedListDeque<T> {

    public class IntNode{
        public T item;
        public IntNode prev;
        public IntNode next;
        public IntNode( IntNode p,T i, IntNode n){
            item = i;
            prev= p;
            next = n;
        }
    }


    private int  size = 0;

    private IntNode sentinel;



    public LinkedListDeque(){
            sentinel = new IntNode(null,null,null);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
    }

    public LinkedListDeque(LinkedListDeque other){
          IntNode sentinel = new IntNode(null,null,null);
          sentinel.prev = sentinel;
          sentinel.next = sentinel;
          for(int i = 0; i < other.size;i++){
              addLast((T)other.get(i));
          }
    }



    public void addFirst(T item){
        IntNode p = new IntNode(sentinel,item,sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size++;
    }

    public void addLast(T item){
        IntNode p = new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;


        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public int size(){
        return size;
    }

    public void printDeque(){
       IntNode  p = sentinel.next;
       while(p != sentinel){
           System.out.print(p.item +" ");
           p = p.next;
       }
       System.out.println();
    }

    public T removeFirst(){
        T removeFirstItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removeFirstItem;
    }

    public T removeLast(){
          T removeLastItem = sentinel.prev.item;
          sentinel.prev = sentinel.prev.prev;
          sentinel.prev.next = sentinel;
          size--;
          return removeLastItem;
    }

    public T get(int index){
        if(index >= size){
            return null;
        }
        IntNode p = sentinel;
        while(index >= 0 ){
            p = p.next;
            index--;
        }
        return p.item;
    }


    public T getRecursive(int index){
            return helper(sentinel.next,index);
    }

    public T helper(IntNode x,int i){
        if( i == 0){
            return x.item;
        }
        return helper(x.next,i-1);
    }
}
